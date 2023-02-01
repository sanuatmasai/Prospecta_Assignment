package com.prospecta.exception;

import lombok.NoArgsConstructor;

public class APIFetchingException extends Exception {
	public APIFetchingException() {
		
	}

	public APIFetchingException(String message) {
		super(message);
	}
}
