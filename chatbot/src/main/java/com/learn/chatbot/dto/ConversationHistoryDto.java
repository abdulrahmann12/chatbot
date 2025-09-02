package com.learn.chatbot.dto;

import java.util.List;

import lombok.Data;

@Data
public class ConversationHistoryDto {
    private Long conversationId;
    private String title;
    private List<ChatMessageDto> messages;
}