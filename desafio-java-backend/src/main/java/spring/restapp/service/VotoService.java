package spring.restapp.service;

import spring.restapp.dto.RecuperarVotoDTO;
import spring.restapp.model.Voto;
import spring.restapp.response.Response;

public interface VotoService {
	
	Response<Voto> persistirVoto(Voto voto);
	
	Response<RecuperarVotoDTO> recuperarByPauta(Long idPauta);

}
