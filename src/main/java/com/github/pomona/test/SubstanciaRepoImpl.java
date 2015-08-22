package com.github.pomona.test;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.model.SubstanciaId;
import com.github.pomona.domain.model.SubstanciaRepo;

public class SubstanciaRepoImpl implements SubstanciaRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public Substancia adicionar(Substancia umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<Substancia> todos() {
		return manager.createQuery("from Substancia", Substancia.class).getResultList();
	}

	@Override
	public void remover(Substancia umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public Substancia substanciaPeloNome(String nome) {
		return manager.createQuery("from Substancia where nome = :nome", Substancia.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	public SubstanciaId proximaIdentidade() {
		SubstanciaId substanciaId = null;
		do{
			substanciaId = new SubstanciaId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(substanciaId) != null);
		return substanciaId;
	}

	@Override
	public Long proximaOrdem() {
		CriteriaBuilder qb = manager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(Substancia.class)));
		//cq.where(/*your stuff*/);
		return manager.createQuery(cq).getSingleResult();
	}

	@Override
	public Substancia porId(AbstractId umaId) {
		try {
			return manager.createQuery("from Substancia where uuid = :uuid", Substancia.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
