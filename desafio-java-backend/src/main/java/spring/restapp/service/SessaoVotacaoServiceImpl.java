package spring.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.restapp.exception.PautaNaoEncontradaException;
import spring.restapp.model.SessaoVotacao;
import spring.restapp.repository.SessaoVotacaoRepository;
import spring.restapp.response.Response;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {

	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;

	@Autowired
	private PautaService pautaService;

	public Response<SessaoVotacao> persistirSessaoVotacao(SessaoVotacao sessaoVotacao) {
		if (!pautaService.existePauta(sessaoVotacao.getPauta())) {
			throw new PautaNaoEncontradaException();
		}

		sessaoVotacao = sessaoVotacaoRepository.save(sessaoVotacao);

		return new Response<>(sessaoVotacao);
	}

	@Override
	public Boolean existeSessaoVotacao(SessaoVotacao sessaoVotacao) {
		return sessaoVotacaoRepository.existsById(sessaoVotacao.getId());
	}

}
