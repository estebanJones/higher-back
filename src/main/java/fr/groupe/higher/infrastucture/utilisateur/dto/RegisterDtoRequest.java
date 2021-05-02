package fr.groupe.higher.infrastucture.utilisateur.dto;

public class RegisterDtoRequest {
	private String email;
	private String password;
	
	public RegisterDtoRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public RegisterDtoRequest() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
