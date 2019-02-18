package spring.restapp.service;

import spring.restapp.model.Associado;

public interface AssociadoService {
	
	/**
	 * Persiste o Associado no banco de dados
	 * 
	 * @param associado
	 * @return Associado
	 */
	Associado persistirAssociado(Associado associado);
	
	/**
	 * Verifica se o Associado existe
	 * 
	 * @param associado
	 * @return Boolean
	 */
	Boolean existeAssociado(Associado associado);

}
