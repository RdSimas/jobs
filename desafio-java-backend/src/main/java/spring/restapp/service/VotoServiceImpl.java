package spring.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import spring.restapp.dto.RecuperarVotoDTO;
import spring.restapp.exception.AssociadoJaVotouException;
import spring.restapp.exception.AssociadoNaoEncontradoException;
import spring.restapp.exception.PautaNaoEncontradaException;
import spring.restapp.exception.PautaSemVotosException;
import spring.restapp.exception.SessaoVotacaoIndisponivelException;
import spring.restapp.exception.SessaoVotacaoNaoEncontradaException;
import spring.restapp.model.Associado;
import spring.restapp.model.Pauta;
import spring.restapp.model.SessaoVotacao;
import spring.restapp.model.Voto;
import spring.restapp.repository.VotoRepository;

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
	public Voto persistirVoto(Voto voto) {
		validarPersistenciaDeVoto(voto);
		return votoRepository.save(voto);
	}

	private void validarPersistenciaDeVoto(Voto voto) {
		if (!associadoService.existeAssociado(voto.getAssociado())) {
			throw new AssociadoNaoEncontradoException();
		}

		Optional<SessaoVotacao> sessaoCarregada = sessaoVotacaoService.findById(voto.getSessao().getId());
		
		if (!sessaoCarregada.isPresent()) {
			throw new SessaoVotacaoNaoEncontradaException();
		}
		
		if (!sessaoCarregada.get().sessaoAberta()) {
			throw new SessaoVotacaoIndisponivelException();
		}

		if (existeVoto(voto.getAssociado(), sessaoCarregada.get().getPauta())) {
			throw new AssociadoJaVotouException();
		}
	}

	@Override
	public RecuperarVotoDTO recuperarByPauta(Long idPauta) {

		if (!pautaService.existePauta(idPauta)) {
			throw new PautaNaoEncontradaException();
		}

		List<Voto> votos = votoRepository.recuperarByPauta(idPauta);

		if (CollectionUtils.isEmpty(votos)) {
			throw new PautaSemVotosException();
		}

		return new RecuperarVotoDTO(votos);
	}

	@Override
	public Boolean existeVoto(Associado associado, Pauta pauta) {
		return votoRepository.existeVotoPorAssociadoNaPauta(pauta.getId(), associado.getId());
	}

}
