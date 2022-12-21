package it.prova.materialapirest.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.materialapirest.model.Ruolo;
import it.prova.materialapirest.model.StatoUtente;
import it.prova.materialapirest.model.Utente;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtenteDTO {
	

	private Long id;

	@NotBlank(message = "{username.notblank}")
	@Size(min = 3, max = 15, message = "Il valore inserito '${validatedValue}' deve essere lungo tra {min} e {max} caratteri")
	private String username;

	@NotBlank(message = "{password.notblank}")
	@Size(min = 8, max = 15, message = "Il valore inserito deve essere lungo tra {min} e {max} caratteri")
	private String password;

	private String confermaPassword;

	@NotBlank(message = "{nome.notblank}")
	private String nome;

	@NotBlank(message = "{cognome.notblank}")
	private String cognome;

	private Date dataNascita;

	private StatoUtente stato;

	private RuoloDTO ruoloDTO;


	public UtenteDTO() {
	}

	public UtenteDTO(Long id, String username, String nome, String cognome, StatoUtente stato) {
		super();
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.stato = stato;
	}
	

	public UtenteDTO(Long id,String username,String nome,String cognome,
			Date dataNascita, StatoUtente stato, RuoloDTO ruoloDTO) {
		super();
		this.id = id;
		this.username = username;
		this.nome=nome;
		this.cognome=cognome;
		this.dataNascita = dataNascita;
		this.stato = stato;
		this.ruoloDTO = ruoloDTO;
	}
	
	public UtenteDTO(Long id,String username,String nome, String cognome,Date dataNascita,StatoUtente stato) {
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

	public String getConfermaPassword() {
		return confermaPassword;
	}

	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}


	public RuoloDTO getRuoloDTO() {
		return ruoloDTO;
	}

	public void setRuolODTO(Ruolo RuoloDTO) {
		this.ruoloDTO = ruoloDTO;
	}
	
//Aggiungere boolean tavolo presente
	public Utente buildUtenteModel() {
		Utente result = new Utente(this.id, this.username, this.password, this.nome, this.cognome,
				this.dataNascita, this.stato);
			result.setRuolo(RuoloDTO.buildRuoloModel(ruoloDTO));
		return result;
	}


	public static UtenteDTO buildUtenteDTOFromModel(Utente utenteModel) {
		UtenteDTO result = new UtenteDTO(utenteModel.getId(), utenteModel.getUsername(), utenteModel.getNome(),
				utenteModel.getCognome(),utenteModel.getDataNascita(),utenteModel.getStato());

		return result;
	}

	public static List<UtenteDTO> createUtenteDTOListFromModelList(List<Utente> modelListInput) {
		return modelListInput.stream().map(utenteEntity -> {
			return UtenteDTO.buildUtenteDTOFromModel(utenteEntity);
		}).collect(Collectors.toList());
	}
	
	public static Set<UtenteDTO> createUtenteDTOSetFromModelSet(Set<Utente> modelListInput) {
		return modelListInput.stream().map(utenteEntity -> {
			return UtenteDTO.buildUtenteDTOFromModel(utenteEntity);
		}).collect(Collectors.toSet());
	}


}
