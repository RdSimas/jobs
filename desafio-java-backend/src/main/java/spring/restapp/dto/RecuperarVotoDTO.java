package spring.restapp.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import spring.restapp.model.Pauta;
import spring.restapp.model.Voto;

public class RecuperarVotoDTO {

	private Long idPauta;
	private String descricaoPauta;
	private List<DetalheVotoDTO> detalhes;

	public RecuperarVotoDTO(List<Voto> votos) {
		if (!CollectionUtils.isEmpty(votos)) {
			Pauta pauta = votos.get(0).getSessao().getPauta();
			setIdPauta(pauta.getId());
			setDescricaoPauta(pauta.getDescricao());
			votos.stream().forEach(voto -> getDetalhes().add(new DetalheVotoDTO(voto)));
		}
	}

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

	public String getDescricaoPauta() {
		return descricaoPauta;
	}

	public void setDescricaoPauta(String descricaoPauta) {
		this.descricaoPauta = descricaoPauta;
	}

	public List<DetalheVotoDTO> getDetalhes() {
		if (detalhes == null) {
			setDetalhes(new ArrayList<>());
		}
		return detalhes;
	}

	public void setDetalhes(List<DetalheVotoDTO> detalhes) {
		this.detalhes = detalhes;
	}
}
