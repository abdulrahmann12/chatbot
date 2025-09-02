package com.learn.chatbot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.learn.chatbot.dto.*;
import com.learn.chatbot.model.Conversation;

@Mapper(componentModel = "spring", uses = { ChatMessageMapper.class })
public interface ConversationMapper {

    ConversationDto toDto(Conversation conversation);

    @Mapping(source = "id", target = "conversationId")
    ConversationHistoryDto toHistoryDto(Conversation conversation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)  
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "createdAt", ignore = true) 
    Conversation toEntity(NewConversationRequest request);
}
