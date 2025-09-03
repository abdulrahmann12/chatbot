package com.learn.chatbot.mapper;

import com.learn.chatbot.dto.*;
import com.learn.chatbot.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
    UserResponseDTO toUserResponseDTO(User user);

    @Mapping(target = "id", ignore = true) 
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "conversations", ignore = true)
    @Mapping(target = "role", ignore = true)
	User toENTITY(RegisterRequest registerRequest);   
}
