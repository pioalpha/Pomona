package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.FatorMetabolico;
import com.github.pomona.domain.model.FatorMetabolicoId;
import com.github.pomona.domain.model.FatorMetabolicoRepo;

public class FatorMetabolicoRepoImpl implements FatorMetabolicoRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public FatorMetabolico adicionar(FatorMetabolico umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<FatorMetabolico> todos() {
		return manager.createQuery("from FatorMetabolico", FatorMetabolico.class).getResultList();
	}

	@Override
	public void remover(FatorMetabolico umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public FatorMetabolico fatorMetabolicoPeloNome(String nome) {
		return manager.createQuery("from FatorMetabolico where nome = :nome", FatorMetabolico.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	public FatorMetabolico porId(AbstractId umaId) {
		try {
			return manager.createQuery("from FatorMetabolico where uuid = :uuid", FatorMetabolico.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public FatorMetabolicoId proximaIdentidade() {
		FatorMetabolicoId fatorMetabolicoId = null;
		do{
			fatorMetabolicoId = new FatorMetabolicoId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(fatorMetabolicoId) != null);
		return fatorMetabolicoId;
	}

}
