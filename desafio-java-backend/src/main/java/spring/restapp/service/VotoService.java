package spring.restapp.service;

import java.util.List;

import spring.restapp.model.Voto;
import spring.restapp.response.Response;

public interface VotoService {
	
	Response<Voto> persistirVoto(Voto voto);
	
	Response<List<Voto>> recuperarByPauta(Long idPauta);

}
