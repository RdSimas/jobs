package spring.restapp.service;

import spring.restapp.dto.RecuperarVotoDTO;
import spring.restapp.model.Associado;
import spring.restapp.model.Pauta;
import spring.restapp.model.Voto;

public interface VotoService {

	/**
	 * Persiste o Voto no banco de dados
	 * 
	 * @param voto
	 * @return Voto
	 */
	Voto persistirVoto(Voto voto);

	/**
	 * Gera o resumo da votação de uma Pauta
	 * 
	 * @param idPauta
	 * @return RecuperarVotoDTO
	 */
	RecuperarVotoDTO recuperarByPauta(Long idPauta);

	/**
	 * Verifica se Associado já votou na Pauta
	 * 
	 * @param associado
	 * @param pauta
	 * @return Boolean
	 */
	Boolean existeVoto(Associado associado, Pauta pauta);

}
