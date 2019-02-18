package spring.restapp.service;

import java.util.Optional;

import spring.restapp.model.SessaoVotacao;

public interface SessaoVotacaoService {

	SessaoVotacao persistirSessaoVotacao(SessaoVotacao sessaoVotacao);
	
	Optional<SessaoVotacao> findById(Long idSessaoVotacao);

}
