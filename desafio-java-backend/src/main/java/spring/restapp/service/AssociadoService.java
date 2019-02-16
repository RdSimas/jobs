package spring.restapp.service;

import spring.restapp.model.Associado;

public interface AssociadoService {
	
	Associado persistirAssociado(Associado associado);
	
	Boolean existeAssociado(Associado associado);

}
