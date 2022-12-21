package it.prova.materialapirest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Ruolo {
	
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_CLASSIC_USER = "ROLE_CLASSIC_USER";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codice")
	private String codice;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ruolo")
	private Set<Utente> utenti = new HashSet<Utente>(0);
	
	public Ruolo() {
	}
	
	public Ruolo(Long id) {
		this.id = id;
	}
	

	public Ruolo(Long id, String codice) {
		super();
		this.id = id;
		this.codice = codice;
	
	}

	public Ruolo(String codice) {
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}
	


}
