package com.learn.chatbot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.chatbot.model.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByUserId(Long userId);
    
    @EntityGraph(attributePaths = "messages")
    Optional<Conversation> findByIdAndUserId(Long id, Long userId);
    boolean existsByUserIdAndTitle(Long userId, String title);}