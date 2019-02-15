package spring.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.restapp.model.Voto;
import spring.restapp.repository.VotoRepository;

@Service
public class VotoServiceImpl implements VotoService{
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Override
	public Voto persistirVoto(Voto voto) {
		return votoRepository.save(voto);
	}

}
