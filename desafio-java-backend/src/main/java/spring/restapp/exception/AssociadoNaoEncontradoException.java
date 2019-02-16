package spring.restapp.exception;

public class AssociadoNaoEncontradoException extends VotacaoRuntimeException{

	private static final long serialVersionUID = -2005922446221519048L;

	public AssociadoNaoEncontradoException() {
		super("Associado informado não foi encontrado.");
	}

}
