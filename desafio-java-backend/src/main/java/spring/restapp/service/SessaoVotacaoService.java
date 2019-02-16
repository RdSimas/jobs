package spring.restapp.service;

import spring.restapp.Response.Response;
import spring.restapp.model.SessaoVotacao;

public interface SessaoVotacaoService {

	Response<SessaoVotacao> persistirSessaoVotacao(SessaoVotacao sessaoVotacao);
	
	Boolean existeSessaoVotacao(SessaoVotacao sessaoVotacao);

}
