package com.learn.chatbot.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.learn.chatbot.config.Messages;
import com.learn.chatbot.dto.ConversationDto;
import com.learn.chatbot.dto.ConversationHistoryDto;
import com.learn.chatbot.dto.NewConversationRequest;
import com.learn.chatbot.exception.ConversationAlreadyExistsException;
import com.learn.chatbot.exception.ConversationNotFoundException;
import com.learn.chatbot.exception.UserNotFoundException;
import com.learn.chatbot.mapper.ConversationMapper;
import com.learn.chatbot.model.Conversation;
import com.learn.chatbot.model.User;
import com.learn.chatbot.repository.ConversationRepository;
import com.learn.chatbot.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class ConversationService {

	private final ConversationRepository conversationRepository;
	private final ConversationMapper conversationMapper;
	private final UserRepository userRepository;
	
	@Transactional
	public ConversationDto createConversation(Long userId, @Valid NewConversationRequest request) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException());
		
        boolean exists = conversationRepository.existsByUserIdAndTitle(userId, request.getTitle());

		if(exists) {
			throw new ConversationAlreadyExistsException();
		}
		
		Conversation conversation = Conversation.builder().user(user).title(request.getTitle()).build();
		
		Conversation savedConversation = conversationRepository.save(conversation);
		
		return conversationMapper.toDto(savedConversation);

	}
	
    public List<ConversationDto> getUserConversations(Long userId) {
		userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException());
		List<Conversation> conversations = conversationRepository.findByUserId(userId);
        return conversations.stream()
                .map(conversationMapper::toDto)
                .collect(Collectors.toList());
    	
    }
    
    public ConversationHistoryDto getConversationHistory(Long conversationId, Long userId) {
		userRepository.findById(userId)
		.orElseThrow(() -> new UserNotFoundException());

		conversationRepository.findById(conversationId)
		.orElseThrow(() -> new ConversationNotFoundException());
		
        Optional<Conversation> conversation = conversationRepository.findByIdAndUserId(conversationId, userId);
        return conversationMapper.toHistoryDto(conversation.get());
    }

    public void deleteConversation(Long conversationId, Long userId) {
		userRepository.findById(userId)
		.orElseThrow(() -> new UserNotFoundException());

		Conversation conversation = conversationRepository.findById(conversationId)
		.orElseThrow(() -> new ConversationNotFoundException());
		if(conversation.getUser().getId() != userId) {
			throw new IllegalArgumentException(Messages.CONVERSATION_NOT_BELONG_TO_USER);
		}
        conversationRepository.delete(conversation);
    }
}
