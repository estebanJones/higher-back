package fr.groupe.higher.infrastucture.exceptions;

import java.util.function.Supplier;

public class UserException extends Exception {
	private String message;
	public UserException(String message) {
		super(message);
	}

}
