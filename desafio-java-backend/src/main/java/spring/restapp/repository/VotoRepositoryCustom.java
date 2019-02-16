package spring.restapp.repository;

import java.util.List;

import spring.restapp.model.Voto;

public interface VotoRepositoryCustom {
	
	List<Voto> recuperarByPauta(Long idPauta);

}
