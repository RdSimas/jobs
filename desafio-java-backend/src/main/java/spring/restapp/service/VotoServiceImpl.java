package spring.restapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import spring.restapp.exception.AssociadoNaoEncontradoException;
import spring.restapp.exception.PautaNaoEncontradaException;
import spring.restapp.exception.PautaSemVotosException;
import spring.restapp.exception.SessaoVotacaoNaoEncontradaException;
import spring.restapp.model.Voto;
import spring.restapp.repository.VotoRepository;
import spring.restapp.response.Response;

@Service
public class VotoServiceImpl implements VotoService {

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private AssociadoService associadoService;

	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;

	@Autowired
	private PautaService pautaService;

	@Override
	public Response<Voto> persistirVoto(Voto voto) {
		if (!associadoService.existeAssociado(voto.getAssociado())) {
			throw new AssociadoNaoEncontradoException();
		}

		if (!sessaoVotacaoService.existeSessaoVotacao(voto.getSessao())) {
			throw new SessaoVotacaoNaoEncontradaException();
		}

		voto = votoRepository.save(voto);

		return new Response<>(voto);
	}

	public Response<List<Voto>> recuperarByPauta(Long idPauta) {

		if (!pautaService.existePauta(idPauta)) {
			throw new PautaNaoEncontradaException();
		}

		List<Voto> votos = votoRepository.recuperarByPauta(idPauta);

		if (CollectionUtils.isEmpty(votos)) {
			throw new PautaSemVotosException();
		}

		return new Response<>(votos);
	}

}
