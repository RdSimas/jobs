package spring.restapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import spring.restapp.model.Voto;

@Repository
public class VotoRepositoryImpl implements VotoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Voto> recuperarByPauta(Long idPauta) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Voto> cq = cb.createQuery(Voto.class);

		Root<Voto> book = cq.from(Voto.class);
		Predicate predicate = null;

		if (idPauta != null) {
			predicate = cb.equal(book.get("sessao").get("pauta").get("id"), idPauta);
		}

		cq.where(predicate);

		return em.createQuery(cq).getResultList();
	}
	
	
	public Boolean existeVotoPorAssociadoNaPauta(Long idPauta, Long idAssociado) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Voto> cq = cb.createQuery(Voto.class);

		Root<Voto> book = cq.from(Voto.class);
		
		Predicate pautaPredicate = cb.equal(book.get("sessao").get("pauta").get("id"), idPauta);
		Predicate associadoPredicate = cb.equal(book.get("associado").get("id"), idAssociado);

		cq.where(pautaPredicate, associadoPredicate);
		
		return !CollectionUtils.isEmpty(em.createQuery(cq).getResultList());
	}

}
