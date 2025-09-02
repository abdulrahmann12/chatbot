package com.learn.chatbot.exception;

import com.learn.chatbot.config.Messages;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super(Messages.USER_NOT_FOUND);
	}
}