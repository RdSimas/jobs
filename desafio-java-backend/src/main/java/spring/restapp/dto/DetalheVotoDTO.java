package spring.restapp.dto;

import java.time.format.DateTimeFormatter;

import spring.restapp.model.Voto;

public class DetalheVotoDTO {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	private Long idAssociado;
	private String nomeAssociado;
	private Long idSessaoVotacao;
	private String inicioSessao;
	private String fimSessao;
	private String voto;

	public DetalheVotoDTO(Voto voto) {
		setIdAssociado(voto.getAssociado().getId());
		setNomeAssociado(voto.getAssociado().getNome());
		setIdSessaoVotacao(voto.getSessao().getId());
		setInicioSessao(voto.getSessao().getInicio().format(FORMATTER));
		setFimSessao(voto.getSessao().getFim().format(FORMATTER));
		setVoto(voto.getValor().getDescricao());
	}

	public Long getIdSessaoVotacao() {
		return idSessaoVotacao;
	}

	public void setIdSessaoVotacao(Long idSessaoVotacao) {
		this.idSessaoVotacao = idSessaoVotacao;
	}

	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public String getNomeAssociado() {
		return nomeAssociado;
	}

	public void setNomeAssociado(String nomeAssociado) {
		this.nomeAssociado = nomeAssociado;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public String getInicioSessao() {
		return inicioSessao;
	}

	public void setInicioSessao(String inicioSessao) {
		this.inicioSessao = inicioSessao;
	}

	public String getFimSessao() {
		return fimSessao;
	}

	public void setFimSessao(String fimSessao) {
		this.fimSessao = fimSessao;
	}
}
