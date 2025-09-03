package com.learn.chatbot.exception;

import com.learn.chatbot.config.Messages;

public class ConversationNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ConversationNotFoundException() {
		super(Messages.CONVERSATION_NOT_FOUND);
	}
}