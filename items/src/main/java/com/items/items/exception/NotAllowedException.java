package com.items.items.exception;

public class NotAllowedException extends Exception {

	public NotAllowedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NotAllowedException [getMessage()=" + getMessage() + "]";
	}

}
