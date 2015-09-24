package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.EnergiaSubstancia;
import com.github.pomona.domain.model.EnergiaSubstanciaId;
import com.github.pomona.domain.model.EnergiaSubstanciaRepo;
import com.github.pomona.domain.model.Substancia;

public class EnergiaSubstanciaRepoImpl implements EnergiaSubstanciaRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public EnergiaSubstancia adicionar(EnergiaSubstancia umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<EnergiaSubstancia> todos() {
		return manager.createQuery("from EnergiaSubstancia", EnergiaSubstancia.class).getResultList();
	}

	@Override
	public void remover(EnergiaSubstancia umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public EnergiaSubstancia energiaSubstanciaPelaSubstancia(Substancia substancia) {
		return manager.createQuery("from EnergiaSubstancia where substancia = :substancia", EnergiaSubstancia.class)
				.setParameter("substancia", substancia)
				.getSingleResult();
	}

	@Override
	public EnergiaSubstancia porId(AbstractId umaId) {
		try {
			return manager.createQuery("from EnergiaSubstancia where uuid = :uuid", EnergiaSubstancia.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public EnergiaSubstanciaId proximaIdentidade() {
		EnergiaSubstanciaId energiaSubstanciaId = null;
		do{
			energiaSubstanciaId = new EnergiaSubstanciaId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(energiaSubstanciaId) != null);
		return energiaSubstanciaId;
	}

}
