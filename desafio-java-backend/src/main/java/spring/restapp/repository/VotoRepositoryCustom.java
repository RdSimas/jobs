package spring.restapp.repository;

import java.util.List;

import spring.restapp.model.Voto;

public interface VotoRepositoryCustom {
	
	/**
	 * Recupera Votos através de uma Pauta
	 * 
	 * @param idPauta
	 * @return List<Voto>
	 */
	List<Voto> recuperarByPauta(Long idPauta);
	
	/**
	 * Verifica se Associado já votou na Pauta
	 * 
	 * @param idPauta
	 * @param idAssociado
	 * @return Boolean
	 */
	Boolean existeVotoPorAssociadoNaPauta(Long idPauta, Long idAssociado);

}
