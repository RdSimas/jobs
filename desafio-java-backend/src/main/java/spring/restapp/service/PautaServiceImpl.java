package spring.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.restapp.model.Pauta;
import spring.restapp.repository.PautaRepository;

@Service
public class PautaServiceImpl implements PautaService {

	@Autowired
	private PautaRepository pautaRepository;

	@Override
	public Pauta persistirPauta(Pauta pauta) {
		return pautaRepository.save(pauta);
	}
	
	@Override
	public Boolean existePauta(Pauta pauta) {
		return existePauta(pauta.getId());
	}
	
	@Override
	public Boolean existePauta(Long idPauta) {
		return pautaRepository.existsById(idPauta);
	}

}
