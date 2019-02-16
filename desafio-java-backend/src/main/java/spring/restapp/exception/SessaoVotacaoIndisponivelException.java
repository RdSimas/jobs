package spring.restapp.exception;

public class SessaoVotacaoIndisponivelException extends VotacaoRuntimeException {

	private static final long serialVersionUID = -7667591015239579640L;

	public SessaoVotacaoIndisponivelException() {
		super("Sessão não está aberta para votação.");
	}

}
