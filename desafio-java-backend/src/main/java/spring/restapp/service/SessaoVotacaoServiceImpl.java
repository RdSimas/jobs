package spring.restapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.restapp.exception.PautaNaoEncontradaException;
import spring.restapp.model.SessaoVotacao;
import spring.restapp.repository.SessaoVotacaoRepository;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {

	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;

	@Autowired
	private PautaService pautaService;

	public SessaoVotacao persistirSessaoVotacao(SessaoVotacao sessaoVotacao) {
		if (!pautaService.existePauta(sessaoVotacao.getPauta())) {
			throw new PautaNaoEncontradaException();
		}

		sessaoVotacao = sessaoVotacaoRepository.save(sessaoVotacao);

		return sessaoVotacao;
	}

	@Override
	public Optional<SessaoVotacao> findById(Long idSessaoVotacao) {
		return sessaoVotacaoRepository.findById(idSessaoVotacao);
	}

}
