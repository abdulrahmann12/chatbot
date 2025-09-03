package com.learn.chatbot.exception;

import com.learn.chatbot.config.Messages;

public class ConversationAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ConversationAlreadyExistsException() {
		super(Messages.CONVERSATION_ALREADY_EXISTS);
	}
	
}