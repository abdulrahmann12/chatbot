package com.learn.chatbot.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChatHistoryDto {
    private List<ChatMessageDto> messages;
}