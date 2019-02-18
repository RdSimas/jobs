package spring.restapp.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import spring.restapp.model.Associado;
import spring.restapp.security.utils.SenhaUtils;

public class PersistirAssociadoDTO {

	@Length(max = 50, message = "Nome deve ter no máximo 50 caracteres.")
	@NotEmpty(message = "Nome não pode ser vazio.")
	private String nome;
	@Length(max = 15, message = "Login deve ter no máximo 15 caracteres.")
	private String login;
	@Length(max = 15, message = "Senha deve ter no máximo 15 caracteres.")
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
