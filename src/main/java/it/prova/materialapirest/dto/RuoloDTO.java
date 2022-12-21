package it.prova.materialapirest.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.prova.materialapirest.model.Ruolo;


public class RuoloDTO {
	private Long id;
	private String codice;
	

	public RuoloDTO(Long id, String codice) {
		this.id = id;
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

	
	public static Ruolo buildRuoloModel(RuoloDTO ruoloDTO) {
		return new Ruolo(ruoloDTO.id,ruoloDTO.codice);
	}
	
	public static RuoloDTO buildRuoloDTOFromModel(Ruolo ruoloModel) {
		return new RuoloDTO(ruoloModel.getId(), ruoloModel.getCodice());
	}

	public static List<RuoloDTO> createRuoloDTOListFromModelSet(Set<Ruolo> modelListInput) {
		return modelListInput.stream().map(ruoloEntity -> {
			return RuoloDTO.buildRuoloDTOFromModel(ruoloEntity);
		}).collect(Collectors.toList());
	}
	
	public static List<RuoloDTO> createRuoloDTOListFromModelList(List<Ruolo> modelListInput) {
		return modelListInput.stream().map(ruoloEntity -> {
			return RuoloDTO.buildRuoloDTOFromModel(ruoloEntity);
		}).collect(Collectors.toList());
	}
	

}
