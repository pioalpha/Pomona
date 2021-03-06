package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.DiretrizAlimentarId;
import com.github.pomona.domain.model.DiretrizAlimentarRepo;

public class DiretrizAlimentarRepoImpl implements DiretrizAlimentarRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Override
	public DiretrizAlimentar adicionar(DiretrizAlimentar umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<DiretrizAlimentar> todos() {
		return manager.createQuery("from DiretrizAlimentar", DiretrizAlimentar.class).getResultList();
	}

	@Override
	public void remover(DiretrizAlimentar umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public DiretrizAlimentar diretrizAlimentarPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiretrizAlimentar porId(AbstractId umaId) {
		try {
			return manager.createQuery("from DiretrizAlimentar where uuid = :uuid", DiretrizAlimentar.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public DiretrizAlimentarId proximaIdentidade() {
		DiretrizAlimentarId diretrizAlimentarId = null;
		do{
			diretrizAlimentarId = new DiretrizAlimentarId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(diretrizAlimentarId) != null);
		return diretrizAlimentarId;
	}

}
