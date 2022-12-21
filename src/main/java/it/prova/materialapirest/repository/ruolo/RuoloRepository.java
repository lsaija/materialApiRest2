package it.prova.materialapirest.repository.ruolo;

import org.springframework.data.repository.CrudRepository;

import it.prova.materialapirest.model.Ruolo;


public interface RuoloRepository extends CrudRepository<Ruolo, Long>{
	Ruolo findByCodice(String codice);
}
