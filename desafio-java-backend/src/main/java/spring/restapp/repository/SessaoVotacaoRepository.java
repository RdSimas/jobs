package spring.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.restapp.model.SessaoVotacao;

public interface SessaoVotacaoRepository  extends JpaRepository<SessaoVotacao, Long>{

}
