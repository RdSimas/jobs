package spring.restapp.service;

import java.util.List;

import spring.restapp.Response.Response;
import spring.restapp.model.Voto;

public interface VotoService {
	
	Response<Voto> persistirVoto(Voto voto);
	
	Response<List<Voto>> recuperarByPauta(Long idPauta);

}
