package spring.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.restapp.Response.Response;
import spring.restapp.model.SessaoVotacao;
import spring.restapp.repository.SessaoVotacaoRepository;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {

	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;

	@Autowired
	private PautaService pautaService;

	public Response<SessaoVotacao> persistirSessaoVotacao(SessaoVotacao sessaoVotacao) {
		Response<SessaoVotacao> response = new Response<>();

		if (pautaService.existePauta(sessaoVotacao.getPauta())) {
			response.setData(sessaoVotacaoRepository.save(sessaoVotacao));
		} else {
			response.getErrors().add("Pauta informada não foi encontrada.");
		}

		return response;
	}

	@Override
	public Boolean existeSessaoVotacao(SessaoVotacao sessaoVotacao) {
		return sessaoVotacaoRepository.existsById(sessaoVotacao.getId());
	}

}
