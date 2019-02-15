package spring.restapp.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import spring.restapp.model.Pauta;
import spring.restapp.model.SessaoVotacao;

public class PersistirSessaoVotacaoDTO {

	private static final Long TEMPO_DEFAULT = 1L;

	private Integer duracaoEmMinutos;

	@NotNull(message = "Identificador da Pauta não pode ser vazio.")
	private Long idPauta;

	public SessaoVotacao toSessaoVotacao() {
		SessaoVotacao sessaoVotacao = new SessaoVotacao();
		sessaoVotacao.setInicio(LocalDateTime.now());
		sessaoVotacao.setFim(processaDataFim(sessaoVotacao));
		sessaoVotacao.setPauta(new Pauta(getIdPauta()));
		return sessaoVotacao;
	}

	private LocalDateTime processaDataFim(SessaoVotacao sessaoVotacao) {
		return getDuracaoEmMinutos() == null ? sessaoVotacao.getInicio().plusMinutes(TEMPO_DEFAULT)
				: sessaoVotacao.getInicio().plusMinutes(getDuracaoEmMinutos());
	}

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

	public Integer getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}
}
