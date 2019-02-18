package spring.restapp.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import spring.restapp.model.Pauta;

public class PersistirPautaDTO {

	@NotEmpty(message = "Descrição não pode ser vazio.")
	@Length(max = 50, message = "Descrição deve ter no máximo 50 caracteres.")
	private String descricao;
	
	public Pauta toPauta() {
		Pauta pauta = new Pauta();
		pauta.setDescricao(getDescricao());
		return pauta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
