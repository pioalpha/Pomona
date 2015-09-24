package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.EnergiaAlimento;
import com.github.pomona.domain.model.EnergiaAlimentoId;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;

public class EnergiaAlimentoRepoImpl implements EnergiaAlimentoRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public EnergiaAlimento adicionar(EnergiaAlimento umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<EnergiaAlimento> todos() {
		return manager.createQuery("from EnergiaAlimento", EnergiaAlimento.class).getResultList();
	}

	@Override
	public void remover(EnergiaAlimento umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public EnergiaAlimento energiaAlimentoPeloAlimento(AlimentoUnitario alimento) {
		return manager.createQuery("from EnergiaAlimento where alimentoUnitario = :alimento", EnergiaAlimento.class)
				.setParameter("alimento", alimento)
				.getSingleResult();
	}

	@Override
	public EnergiaAlimento porId(AbstractId umaId) {
		try {
			return manager.createQuery("from EnergiaAlimento where uuid = :uuid", EnergiaAlimento.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public EnergiaAlimentoId proximaIdentidade() {
		EnergiaAlimentoId energiaAlimentoId = null;
		do{
			energiaAlimentoId = new EnergiaAlimentoId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(energiaAlimentoId) != null);
		return energiaAlimentoId;
	}

}
