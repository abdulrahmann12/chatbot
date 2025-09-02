package com.learn.chatbot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewConversationRequest {

    @NotBlank(message = "Title cannot be empty")
    private String title;

}
