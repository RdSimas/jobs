package spring.restapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import spring.restapp.model.enums.VotoEnum;

@Entity
@Table(name = "voto")
public class Voto implements Serializable {

	private static final long serialVersionUID = -1755060030178184751L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voto", nullable = false)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "valor")
	private VotoEnum valor;

	@JoinColumn(name = "id_associado", referencedColumnName = "id_associado")
    @ManyToOne
	private Associado associado;

	@JoinColumn(name = "id_sessao_votacao", referencedColumnName = "id_sessao_votacao")
    @ManyToOne
	private SessaoVotacao sessao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VotoEnum getValor() {
		return valor;
	}

	public void setValor(VotoEnum valor) {
		this.valor = valor;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public SessaoVotacao getSessao() {
		return sessao;
	}

	public void setSessao(SessaoVotacao sessao) {
		this.sessao = sessao;
	}

}
