package spring.restapp.service;

import spring.restapp.model.SessaoVotacao;
import spring.restapp.response.Response;

public interface SessaoVotacaoService {

	Response<SessaoVotacao> persistirSessaoVotacao(SessaoVotacao sessaoVotacao);
	
	Boolean existeSessaoVotacao(SessaoVotacao sessaoVotacao);
	
	Boolean isSessaoAberta(SessaoVotacao sessaoVotacao);

}
