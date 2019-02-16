package spring.restapp.exception;

public class SessaoVotacaoNaoEncontradaException extends VotacaoRuntimeException{

	private static final long serialVersionUID = -5368133925568541626L;

	public SessaoVotacaoNaoEncontradaException() {
		super("Sessão Votação informada não foi encontrada.");
	}

}
