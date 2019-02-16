package spring.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.restapp.model.Associado;
import spring.restapp.repository.AssociadoRepository;

@Service
public class AssociadoServiceImpl implements AssociadoService{
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Override
	public Associado persistirAssociado(Associado associado) {
		return associadoRepository.save(associado);
	}
	
	@Override
	public Boolean existeAssociado(Associado associado) {
		return associadoRepository.existsById(associado.getId());
	}

}
