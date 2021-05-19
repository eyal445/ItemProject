package com.items.items.exception;

public class PurchaseItemException extends Exception {

	public PurchaseItemException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PurchaseItemException [getMessage()=" + getMessage() + "]";
	}

}
