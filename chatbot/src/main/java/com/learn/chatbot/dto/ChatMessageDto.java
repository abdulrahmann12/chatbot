package com.learn.chatbot.dto;

import java.time.LocalDateTime;

import com.learn.chatbot.model.SenderType;

import lombok.Data;

@Data
public class ChatMessageDto {
    private String message;
    private SenderType senderType;
    private LocalDateTime timestamp;
}