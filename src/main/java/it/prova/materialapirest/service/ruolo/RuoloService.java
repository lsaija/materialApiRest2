package it.prova.materialapirest.service.ruolo;

import java.util.List;

import it.prova.materialapirest.model.Ruolo;

public interface RuoloService {
	public List<Ruolo> listAll();

	public Ruolo caricaSingoloElemento(Long id);

	public void aggiorna(Ruolo ruoloInstance);

	public void inserisciNuovo(Ruolo ruoloInstance);

	public void rimuovi(Long idToRemove);
	
	public Ruolo cercaPerCodice(String codice);
}
