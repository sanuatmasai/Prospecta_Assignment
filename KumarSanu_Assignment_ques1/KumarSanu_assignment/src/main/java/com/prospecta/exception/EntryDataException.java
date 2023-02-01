package com.prospecta.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntryDataException extends Exception {

	public EntryDataException(String str) {
		super(str);
	}
}
