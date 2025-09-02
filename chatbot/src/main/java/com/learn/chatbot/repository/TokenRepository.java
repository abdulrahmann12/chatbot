package com.learn.chatbot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.chatbot.model.Token;



@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
    @Query("""
    	    SELECT t FROM Token t WHERE t.user.id = :userId AND t.expired = false AND t.revoked = false
    	""")
    	List<Token> findAllValidTokenByUser(Long userId);
}