package fr.groupe.higher.infrastucture.utilisateur.dto;

public class RegisterDtoRequest {
	private String email;
	private String password;
	private String nationalite;
	private String username;
	
	public RegisterDtoRequest(String email, String password, String nationalite, String username) {
		this.email = email;
		this.password = password;
		this.nationalite = nationalite;
		this.username = username;
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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
