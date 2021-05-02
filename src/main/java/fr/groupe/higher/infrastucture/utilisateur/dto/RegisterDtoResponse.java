package fr.groupe.higher.infrastucture.utilisateur.dto;

public class RegisterDtoResponse {
	private String message;
	
	public RegisterDtoResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
