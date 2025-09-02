package com.learn.chatbot.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.learn.chatbot.config.Messages;
import com.learn.chatbot.dto.AuthResponse;
import com.learn.chatbot.dto.LoginRequest;
import com.learn.chatbot.dto.RegisterRequest;
import com.learn.chatbot.exception.InvalidTokenException;
import com.learn.chatbot.exception.UserNotFoundException;
import com.learn.chatbot.model.User;
import com.learn.chatbot.model.User.Role;
import com.learn.chatbot.repository.TokenRepository;
import com.learn.chatbot.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenRepository tokenRepository;
	private final JwtService jwtService;

	@Transactional
	public AuthResponse login(LoginRequest loginRequest) {
		User user = userRepository.findByUsername(loginRequest.getUsernameOrEmail())
				.or(() -> userRepository.findByEmail(loginRequest.getUsernameOrEmail()))
				.orElseThrow(UserNotFoundException::new);
		String accessToken = jwtService.generateToken(user);
		String refreshToken = jwtService.generateRefreshToken(user);
		jwtService.revokeAllUserTokens(user);
		jwtService.saveUserToken(user, accessToken);
		return new AuthResponse(accessToken, refreshToken);
	}

	@Transactional
	public AuthResponse createUser(RegisterRequest registerRequest) {

		if (userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
	        throw new RuntimeException(Messages.USERNAME_ALREADY_EXISTS);
	    }
	    if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
	        throw new RuntimeException(Messages.EMAIL_ALREADY_EXISTS);
	    }

	    // Create user entity
	    User user = new User();
	    user.setUsername(registerRequest.getUsername());
	    user.setEmail(registerRequest.getEmail());
	    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
	    user.setRole(Role.USER);

	    userRepository.save(user);

	    // Generate tokens
	    String accessToken = jwtService.generateToken(user);
	    String refreshToken = jwtService.generateRefreshToken(user);

	    jwtService.saveUserToken(user, accessToken);

	    return new AuthResponse(accessToken, refreshToken);
	}


	public User getUserByEmail(String username) {
		return userRepository.findByUsername(username).or(() -> userRepository.findByEmail(username))
				.orElseThrow(UserNotFoundException::new);
	}

	@Transactional
	public void logout(String token) {
		var storedToken = tokenRepository.findByToken(token).orElse(null);
		if (storedToken != null && !storedToken.isExpired()) {
			storedToken.setExpired(true);
			storedToken.setRevoked(true);
			tokenRepository.save(storedToken);
		} else {
			throw new InvalidTokenException(Messages.ALREADY_LOGGED_OUT);
		}
	}

	@Transactional
	public AuthResponse refreshToken(HttpServletRequest request) {
		final String authHeader = request.getHeader("Authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			throw new InvalidTokenException(Messages.INVALID_REFRESH_TOKEN);
		}

		final String refreshToken = authHeader.substring(7);
		final String username = jwtService.extractUsername(refreshToken);

		if (username == null) {
			throw new InvalidTokenException(Messages.COULD_NOT_EXTRACT_USER);
		}

		User user = getUserByEmail(username);

		if (!jwtService.validateToken(refreshToken, user)) {
			throw new InvalidTokenException(Messages.INVALID_REFRESH_TOKEN);
		}

		String accessToken = jwtService.generateToken(user);
		jwtService.revokeAllUserTokens(user);
		jwtService.saveUserToken(user, accessToken);
		return new AuthResponse(accessToken, refreshToken);
	}

	@Transactional
	public void logoutByRequest(HttpServletRequest request) {
		final String authHeader = request.getHeader("Authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			throw new InvalidTokenException(Messages.TOKEN_NOT_FOUND);
		}
		String token = authHeader.substring(7);
		logout(token);
	}
}