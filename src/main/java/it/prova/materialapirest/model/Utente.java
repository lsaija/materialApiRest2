package it.prova.materialapirest.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "dataNascita")
	private Date dataNascita;

	@Enumerated(EnumType.STRING)
	private StatoUtente stato;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ruolo_id", nullable = false)
	private Ruolo ruolo;

	public Utente() {
	}

	public Utente(Long id, String username, String password, String nome, String cognome, Date dataNascita, StatoUtente stato) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.stato = stato;
	}
	
	public Utente(String username, String password, String nome, String cognome, Date dataNascita) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	public Utente(String username, String password, String nome, String cognome, Date dataNascita, StatoUtente stato,
			Ruolo ruolo) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.stato = stato;
		this.ruolo = ruolo;
	}

	public Utente(Long id, String username, String nome, String cognome, Date dataNascita, StatoUtente stato,
			Ruolo ruolo) {
		super();
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.stato = stato;
		this.ruolo = ruolo;
	}

	public Utente(Long id, String username, String password, String nome, String cognome, Date dataNascita,
			StatoUtente stato, Ruolo ruolo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.stato = stato;
		this.ruolo = ruolo;
	}
	
	

	public Utente(Long id, String username, String nome, String cognome) {
		super();
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
	}
	public Utente(Long id, String username, String nome, String cognome,Date dataNascita) {
		super();
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
	    this.dataNascita=dataNascita;
	}
	
	public Utente(Long id,String username,String nome, String cognome,Date dataNascita,StatoUtente stato) {
		super();
		this.id=id;
		this.username=username;
		this.nome=nome;
		this.cognome=cognome;
		this.dataNascita=dataNascita;
		this.stato=stato;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public StatoUtente getStato() {
		return stato;
	}

	public void setStato(StatoUtente stato) {
		this.stato = stato;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public boolean isAdmin() {
		if (this.ruolo.getCodice().equals(Ruolo.ROLE_ADMIN))
			return true;
		return false;
	}

	public boolean isAttivo() {
		return this.stato != null && this.stato.equals(StatoUtente.ATTIVO);
	}

	public boolean isDisabilitato() {
		return this.stato != null && this.stato.equals(StatoUtente.DISABILITATO);
	}

}
