package spring.restapp.service;

import spring.restapp.model.Pauta;

public interface PautaService {
	
	/**
	 * Persiste a Pauta no banco de dados
	 * 
	 * @param pauta
	 * @return Pauta
	 */
	Pauta persistirPauta(Pauta pauta);
	
	/**
	 * Verifica se a Pauta existe
	 *  
	 * @param pauta
	 * @return Boolean
	 */
	Boolean existePauta(Pauta pauta);
	
	/**
	 * Verifica se a Pauta existe
	 *  
	 * @param idPauta
	 * @return Boolean
	 */
	Boolean existePauta(Long idPauta);

}
