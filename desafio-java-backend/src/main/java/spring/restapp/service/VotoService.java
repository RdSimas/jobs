package spring.restapp.service;

import spring.restapp.dto.RecuperarVotoDTO;
import spring.restapp.model.Associado;
import spring.restapp.model.Pauta;
import spring.restapp.model.Voto;

public interface VotoService {

	Voto persistirVoto(Voto voto);

	RecuperarVotoDTO recuperarByPauta(Long idPauta);

	Boolean existeVoto(Associado associado, Pauta pauta);

}
