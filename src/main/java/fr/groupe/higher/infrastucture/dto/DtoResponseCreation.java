package fr.groupe.higher.infrastucture.dto;

public class DtoResponseCreation {
	private String message;

	public DtoResponseCreation(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
