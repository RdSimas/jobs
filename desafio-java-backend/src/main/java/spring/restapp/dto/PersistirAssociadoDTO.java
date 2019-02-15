package spring.restapp.dto;

import javax.validation.constraints.NotEmpty;

import spring.restapp.model.Associado;
import spring.restapp.security.utils.SenhaUtils;

public class PersistirAssociadoDTO {

	@NotEmpty(message = "Login não pode ser vazio.")
	private String login;
	@NotEmpty(message = "Senha não pode ser vazio.")
	private String senha;
	
	public Associado toAssociado() {
		Associado associado = new Associado();
		associado.setLogin(getLogin());
		associado.setSenha(SenhaUtils.gerarBCrypt(getSenha()));
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

}
