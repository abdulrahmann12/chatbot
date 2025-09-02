package com.learn.chatbot.exception;

import com.learn.chatbot.config.Messages;

public class UsernameAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistsException() {
		super(Messages.USERNAME_ALREADY_EXISTS);
	}
	
}