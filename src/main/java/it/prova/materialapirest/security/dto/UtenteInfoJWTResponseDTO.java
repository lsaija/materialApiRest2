package it.prova.materialapirest.security.dto;

import java.util.List;

public class UtenteInfoJWTResponseDTO {

	private String nome;
	private String cognome;
	private String type = "Bearer";
	private String username;
	private String email;
	private String role;

	public UtenteInfoJWTResponseDTO(String nome, String cognome, String username, String email, String role) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
		this.role = role;
	}

	public UtenteInfoJWTResponseDTO(String nome, String cognome, String username, String role) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.role = role;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}