package com.learn.chatbot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.learn.chatbot.config.Messages;
import com.learn.chatbot.dto.BasicResponse;
import com.learn.chatbot.dto.ConversationDto;
import com.learn.chatbot.dto.ConversationHistoryDto;
import com.learn.chatbot.dto.NewConversationRequest;
import com.learn.chatbot.model.User;
import com.learn.chatbot.service.ConversationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
@Tag(name = "Conversations", description = "Endpoints for managing user conversations")
public class ConversationController {

    private final ConversationService conversationService;

    @Operation(summary = "Create a new conversation", description = "User creates a new conversation with a custom title")
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<BasicResponse> createConversation(
            @RequestBody NewConversationRequest request,
            @AuthenticationPrincipal User user
    		) {
        ConversationDto conversation = conversationService.createConversation(user.getId(), request);
        return ResponseEntity.ok(new BasicResponse(Messages.ADD_CONVERSATION, conversation));
    }

    @Operation(summary = "Get all conversations of a user", description = "Retrieve all conversations belonging to a specific user")
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<BasicResponse> getUserConversations(@AuthenticationPrincipal User user) {
        List<ConversationDto> conversations = conversationService.getUserConversations(user.getId());
        return ResponseEntity.ok(new BasicResponse(Messages.CONVERSATIONS_FETCHED, conversations));
    }

    @Operation(summary = "Get conversation history", description = "Retrieve a specific conversation with all its messages")
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{conversationId}")
    public ResponseEntity<BasicResponse> getConversationHistory(
    		@AuthenticationPrincipal User user,
            @PathVariable Long conversationId) {
        ConversationHistoryDto history = conversationService.getConversationHistory(conversationId, user.getId());
        return ResponseEntity.ok(new BasicResponse(Messages.CONVERSATION_HISTORY_FETCHED, history));
    }

    @Operation(summary = "Delete a conversation", description = "Delete a specific conversation by ID for the given user")
    @DeleteMapping("/{conversationId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<BasicResponse> deleteConversation(
    		@AuthenticationPrincipal User user,
    		@PathVariable Long conversationId) {
        conversationService.deleteConversation(conversationId, user.getId());
        return ResponseEntity.ok(new BasicResponse(Messages.DELETE_CONVERSATION));
    }
}
