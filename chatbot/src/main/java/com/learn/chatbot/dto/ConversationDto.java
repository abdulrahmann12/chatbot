package com.learn.chatbot.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ConversationDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
}