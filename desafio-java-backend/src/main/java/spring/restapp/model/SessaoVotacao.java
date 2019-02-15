package spring.restapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sessao_votacao")
public class SessaoVotacao implements Serializable {

	private static final long serialVersionUID = 698609524414698532L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sessao_votacao", nullable = false)
	private Long id;

	@JoinColumn(name = "id_pauta", referencedColumnName = "id_pauta")
	@ManyToOne
	private Pauta pauta;

	@Column(name = "inicio")
	private LocalDateTime inicio;

	@Column(name = "fim")
	private LocalDateTime fim;

	public SessaoVotacao() {
	}

	public SessaoVotacao(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}
}
