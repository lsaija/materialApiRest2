package it.prova.materialapirest.service.ruolo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.materialapirest.model.Ruolo;
import it.prova.materialapirest.repository.ruolo.RuoloRepository;

@Service
@Transactional(readOnly = true)
public class RuoloServiceImpl implements RuoloService {

	@Autowired
	private RuoloRepository ruoloRepository;

	public List<Ruolo> listAll() {
		return (List<Ruolo>) ruoloRepository.findAll();
	}

	public Ruolo caricaSingoloElemento(Long id) {
		return ruoloRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Ruolo ruoloInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void inserisciNuovo(Ruolo ruoloInstance) {
		ruoloRepository.save(ruoloInstance);
	}

	@Transactional
	public void rimuovi(Long idToRemove) {
		// TODO Auto-generated method stub

	}
	
	@Transactional
	public Ruolo cercaPerCodice(String codice) {
		return ruoloRepository.findByCodice(codice);
	}
}
