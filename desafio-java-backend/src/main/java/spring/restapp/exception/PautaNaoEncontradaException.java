package spring.restapp.exception;

public class PautaNaoEncontradaException extends VotacaoRuntimeException{

	private static final long serialVersionUID = 7644651016663201007L;

	public PautaNaoEncontradaException() {
		super("Pauta informada não foi encontrada.");
	}

}
