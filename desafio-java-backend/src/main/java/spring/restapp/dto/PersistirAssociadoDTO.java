package spring.restapp.dto;

import javax.validation.constraints.NotEmpty;

import spring.restapp.model.Associado;
import spring.restapp.security.utils.SenhaUtils;

public class PersistirAssociadoDTO {

	@NotEmpty(message = "Nome não pode ser vazio.")
	private String nome;
	private String login;
	private String senha;

	public Associado toAssociado() {
		Associado associado = new Associado();
		associado.setLogin(getLogin());
		associado.setSenha(SenhaUtils.gerarBCrypt(getSenha()));
		associado.setNome(getNome());
		return associado;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
