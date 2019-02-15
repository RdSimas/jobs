package spring.restapp.dto;

import javax.validation.constraints.NotNull;

import spring.restapp.model.Associado;
import spring.restapp.model.SessaoVotacao;
import spring.restapp.model.Voto;
import spring.restapp.model.enums.VotoEnum;

public class PersistirVotoDTO {

	@NotNull(message = "Identificador do Associado não pode ser vazio.")
	private Long idAssociado;
	@NotNull(message = "Identificador da Sessão de Votação não pode ser vazio.")
	private Long idSessaoVotacao;
	@NotNull(message = "Valor não pode ser vazio.")
	private VotoEnum valor;
	
	public Voto toVoto() {
		Voto voto = new Voto();
		voto.setAssociado(new Associado(getIdAssociado()));
		voto.setSessao(new SessaoVotacao(getIdSessaoVotacao()));
		voto.setValor(getValor());
		return voto;
	}

	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public Long getIdSessaoVotacao() {
		return idSessaoVotacao;
	}

	public void setIdSessaoVotacao(Long idSessaoVotacao) {
		this.idSessaoVotacao = idSessaoVotacao;
	}

	public VotoEnum getValor() {
		return valor;
	}

	public void setValor(VotoEnum valor) {
		this.valor = valor;
	}
}
