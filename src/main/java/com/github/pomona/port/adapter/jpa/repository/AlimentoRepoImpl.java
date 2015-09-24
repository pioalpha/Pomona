package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.AlimentoUnitario;

public class AlimentoRepoImpl implements AlimentoRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Override
	public AlimentoUnitario adicionar(AlimentoUnitario umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<AlimentoUnitario> todos() {
		return manager.createQuery("from AlimentoUnitario", AlimentoUnitario.class).getResultList();
	}

	@Override
	public void remover(AlimentoUnitario umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public AlimentoUnitario alimentoPeloNome(String nome) {
		return manager.createQuery("from AlimentoUnitario where nome = :nome", AlimentoUnitario.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	public AlimentoId proximaIdentidade() {
		AlimentoId alimentoId = null;
		do{
			alimentoId = new AlimentoId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(alimentoId) != null);
		return alimentoId;
	}

	@Override
	public AlimentoUnitario porId(AbstractId umaId) {
		try {
			return manager.createQuery("from AlimentoUnitario where uuid = :uuid", AlimentoUnitario.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
