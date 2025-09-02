package com.learn.chatbot.mapper;

import com.learn.chatbot.dto.ChatMessageDto;
import com.learn.chatbot.dto.ChatRequest;
import com.learn.chatbot.model.ChatMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChatMessageMapper {

    ChatMessageDto toDto(ChatMessage entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "conversation", ignore = true)
    @Mapping(target = "senderType", ignore = true) 
    @Mapping(target = "timestamp", ignore = true)
    ChatMessage toEntity(ChatRequest chatRequest);
}
