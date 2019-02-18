package spring.restapp.service;

import java.util.Optional;

import spring.restapp.model.SessaoVotacao;

public interface SessaoVotacaoService {

	/**
	 * Persiste a Sessão de Votação no banco de dados
	 * 
	 * @param sessaoVotacao
	 * @return SessaoVotacao
	 */
	SessaoVotacao persistirSessaoVotacao(SessaoVotacao sessaoVotacao);
	
	/**
	 * Recupera a Sessão de Votação
	 * 
	 * @param idSessaoVotacao
	 * @return Optional<SessaoVotacao>
	 */
	Optional<SessaoVotacao> findById(Long idSessaoVotacao);

}
