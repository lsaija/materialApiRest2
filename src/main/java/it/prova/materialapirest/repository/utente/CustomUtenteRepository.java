package it.prova.materialapirest.repository.utente;

import java.util.List;

import it.prova.materialapirest.model.Utente;


public interface CustomUtenteRepository {
	List<Utente> findByExample(Utente example);

}
