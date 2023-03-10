package it.prova.materialapirest.web.api;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.materialapirest.dto.UtenteDTO;
import it.prova.materialapirest.model.Utente;
import it.prova.materialapirest.security.dto.UtenteInfoJWTResponseDTO;
import it.prova.materialapirest.service.utente.UtenteService;
import it.prova.materialapirest.web.api.exception.IdNotNullForInsertException;
import it.prova.materialapirest.web.api.exception.UtenteNotFoundException;

@RestController
@RequestMapping("/api/utente")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UtenteController {
	@Autowired
	private UtenteService utenteService;

	// questa mi serve solo per capire se solo ADMIN vi ha accesso
	@GetMapping("/testSoloAdmin")
	public String test() {
		return "OK";
	}

	@GetMapping("/mostraRuoli")
	public String mostra(Utente utente) {
		return utenteService.mostraRuoli(utente);

	}

	@GetMapping(value = "/userInfo")
	public ResponseEntity<UtenteInfoJWTResponseDTO> getUserInfo() {

		// se sono qui significa che sono autenticato quindi devo estrarre le info dal
		// contesto
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		// estraggo le info dal principal
		Utente utenteLoggato = utenteService.findByUsername(username);
		String ruolo = utenteLoggato.getRuolo().getCodice();

		return ResponseEntity.ok(new UtenteInfoJWTResponseDTO(utenteLoggato.getNome(), utenteLoggato.getCognome(),
				utenteLoggato.getUsername(), ruolo));
	}

	@GetMapping
	public List<UtenteDTO> getAllList() {
		return UtenteDTO.createUtenteDTOListFromModelList(utenteService.listAllUtenti());
	}

	@PostMapping
	public void createNew(@Valid @RequestBody UtenteDTO utenteInput) {
		if (utenteInput.getId() != null)
			throw new IdNotNullForInsertException("Non ?? ammesso fornire un id per la creazione");
	    utenteService.inserisciNuovo(utenteInput.buildUtenteModel());
	}

	@GetMapping("/{id}")
	public UtenteDTO findById(@PathVariable(value = "id", required = true) long id) {
		Utente utente = utenteService.caricaSingoloUtenteConRuoli(id);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		if (utente == null)
			throw new UtenteNotFoundException("Utente not found con id: " + id);
		//aggiungere condizione utente

		return UtenteDTO.buildUtenteDTOFromModel(utente);
	}

	@PutMapping("/{id}")
	public void update(@Valid @RequestBody UtenteDTO utenteInput, @PathVariable(required = true) Long id) {
		Utente utente = utenteService.caricaSingoloUtente(id);

		if (utente == null)
			throw new UtenteNotFoundException("Utente not found con id: " + id);

		utenteInput.setId(id);
		utenteService.aggiorna(utenteInput.buildUtenteModel());
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true) Long id) {
		if (utenteService.caricaSingoloUtente(id) == null)
			throw new UtenteNotFoundException("Utente not found con id: " + id);
		utenteService.rimuovi(id);
	}

	@PostMapping("/search")
	public List<UtenteDTO> search(@RequestBody UtenteDTO example, Principal principal) {
		return UtenteDTO.createUtenteDTOListFromModelList(utenteService.findByExample(example.buildUtenteModel()));
	}

	@PutMapping("/cambiaStato/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeUserAbilitation(@PathVariable(value = "id", required = true) long id) {
		utenteService.changeUserAbilitation(id);
	}
	
	@PutMapping("/disabilita/{id}")
	public void disabilita(@PathVariable(required = true) Long id) {
		Utente utente = utenteService.caricaSingoloUtente(id);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (utente == null)
			throw new UtenteNotFoundException("Utente not found con id: " + id);
		utenteService.disabilityUserAbilitation(id);
	}

	
	 /* @PostMapping("/list") public String listRegisti(RegistaDTO
	 * registaExample, @RequestParam(defaultValue = "0") Integer pageNo,
	 * 
	 * @RequestParam(defaultValue = "10") Integer
	 * pageSize, @RequestParam(defaultValue = "id") String sortBy, ModelMap model) {
	 * 
	 * List<Regista> registi =
	 * registaService.findByExampleWithPagination(registaExample.buildRegistaModel()
	 * , pageNo, pageSize, sortBy).getContent();
	 * 
	  model.addAttribute("registi_list_attribute",
	  RegistaDTO.createRegistaDTOListFromModelList(registi)); return
	  "regista/list"; } */
	  
}
