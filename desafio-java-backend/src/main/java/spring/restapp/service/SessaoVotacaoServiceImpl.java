package spring.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.restapp.model.SessaoVotacao;
import spring.restapp.repository.SessaoVotacaoRepository;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {
	
	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	public SessaoVotacao persistirSessaoVotacao(SessaoVotacao sessaoVotacao) {
		return sessaoVotacaoRepository.save(sessaoVotacao);
	}

}
