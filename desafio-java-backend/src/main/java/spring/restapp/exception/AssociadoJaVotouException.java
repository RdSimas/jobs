package spring.restapp.exception;

public class AssociadoJaVotouException extends VotacaoRuntimeException{

	private static final long serialVersionUID = 1676924792254833412L;

	public AssociadoJaVotouException() {
		super("Associado não pode votar duas vezes na mesma Pauta.");
	}

}
