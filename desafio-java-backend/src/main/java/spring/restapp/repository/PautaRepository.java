package spring.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.restapp.model.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long>{

}
