package spring.restapp.dto;

import javax.validation.constraints.NotEmpty;

import spring.restapp.model.Pauta;

public class PersistirPautaDTO {

	private Long id;

	@NotEmpty(message = "Descrição não pode ser vazio.")
	private String descricao;
	
	public Pauta toPauta() {
		Pauta pauta = new Pauta();
		pauta.setId(getId());
		pauta.setDescricao(getDescricao());
		return pauta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
