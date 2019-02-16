package spring.restapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import spring.restapp.Response.Response;
import spring.restapp.model.Voto;
import spring.restapp.repository.VotoRepository;

@Service
public class VotoServiceImpl implements VotoService{
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private AssociadoService associadoService;
	
	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;
	
	
	@Override
	public Response<Voto> persistirVoto(Voto voto) {
		Response<Voto> response = new Response<>();
		
		if(!associadoService.existeAssociado(voto.getAssociado())) {
			response.getErrors().add("Associado informado não foi encontrado.");
		}
		if(!sessaoVotacaoService.existeSessaoVotacao(voto.getSessao())) {
			response.getErrors().add("Sessão Votação informada não foi encontrada.");
		}
		
		response.setData(response.getErrors().isEmpty() ? votoRepository.save(voto) : null);
		
		return response;
	}
	
	public Response<List<Voto>> recuperarByPauta(Long idPauta){
		List<Voto> votos = votoRepository.recuperarByPauta(idPauta);
		Response<List<Voto>> response = new Response<>(votos);

		if (CollectionUtils.isEmpty(votos)) {
			response.getErrors().add("Nenhum registro foi encontrado.");
		}
		
		return response;
	}

}
