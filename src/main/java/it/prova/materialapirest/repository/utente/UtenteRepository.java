package it.prova.materialapirest.repository.utente;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.materialapirest.model.StatoUtente;
import it.prova.materialapirest.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> ,PagingAndSortingRepository<Utente, Long>, JpaSpecificationExecutor<Utente>,CustomUtenteRepository{

	@EntityGraph(attributePaths = { "ruolo" })
	Optional<Utente> findByUsername(String username);

	@Query("from Utente u left join fetch u.ruolo where u.id = ?1")
	Optional<Utente> findByIdConRuoli(Long id);

	Utente findByUsernameAndPassword(String username, String password);

	@EntityGraph(attributePaths = { "ruolo" })
	Utente findByUsernameAndPasswordAndStato(String username, String password, StatoUtente stato);

}
