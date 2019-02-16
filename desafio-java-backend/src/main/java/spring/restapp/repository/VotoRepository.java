package spring.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.restapp.model.Associado;
import spring.restapp.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long>, VotoRepositoryCustom {

	Boolean existsByAssociado(Associado associado);
	
}
