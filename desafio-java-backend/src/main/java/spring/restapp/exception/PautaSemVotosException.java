package spring.restapp.exception;

public class PautaSemVotosException extends VotacaoRuntimeException {

	private static final long serialVersionUID = -2852570200514897218L;

	public PautaSemVotosException() {
		super("Pauta informada não recebeu votos.");
	}

}
