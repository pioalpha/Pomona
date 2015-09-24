package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.model.PlanoAlimentarId;
import com.github.pomona.domain.model.PlanoAlimentarRepo;

public class PlanoAlimentarRepoImpl implements PlanoAlimentarRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public PlanoAlimentar adicionar(PlanoAlimentar umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<PlanoAlimentar> todos() {
		return manager.createQuery("from PlanoAlimentar", PlanoAlimentar.class).getResultList();
	}

	@Override
	public void remover(PlanoAlimentar umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public PlanoAlimentar planoAlimentarPeloNomePaciente(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanoAlimentar porId(AbstractId umaId) {
		try {
			return manager.createQuery("from PlanoAlimentar where uuid = :uuid", PlanoAlimentar.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public PlanoAlimentarId proximaIdentidade() {
		PlanoAlimentarId planoAlimentarId = null;
		do{
			planoAlimentarId = new PlanoAlimentarId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(planoAlimentarId) != null);
		return planoAlimentarId;
	}

}
