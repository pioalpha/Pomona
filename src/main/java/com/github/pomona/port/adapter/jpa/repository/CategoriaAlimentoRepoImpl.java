package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.CategoriaAlimento;
import com.github.pomona.domain.model.CategoriaAlimentoId;
import com.github.pomona.domain.model.CategoriaAlimentoRepo;

public class CategoriaAlimentoRepoImpl implements CategoriaAlimentoRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public CategoriaAlimento adicionar(CategoriaAlimento umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<CategoriaAlimento> todos() {
		return manager.createQuery("from CategoriaAlimento", CategoriaAlimento.class).getResultList();
	}

	@Override
	public CategoriaAlimento porId(AbstractId umaId) {
		try {
			return manager.createQuery("from CategoriaAlimento where uuid = :uuid", CategoriaAlimento.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void remover(CategoriaAlimento umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public CategoriaAlimentoId proximaIdentidade() {
		CategoriaAlimentoId categoriaAlimentoId = null;
		do{
			categoriaAlimentoId = new CategoriaAlimentoId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(categoriaAlimentoId) != null);
		return categoriaAlimentoId;
	}

}
