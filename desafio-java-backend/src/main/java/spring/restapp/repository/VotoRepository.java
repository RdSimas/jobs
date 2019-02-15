package spring.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.restapp.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {

}
