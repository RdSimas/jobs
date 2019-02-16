package spring.restapp.model.enums;

public enum VotoEnum {

	SIM("Sim"), NAO("Não");

	VotoEnum(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
