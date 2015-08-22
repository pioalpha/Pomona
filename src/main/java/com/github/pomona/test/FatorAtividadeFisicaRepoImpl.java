package com.github.pomona.test;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.FatorAtividadeFisica;
import com.github.pomona.domain.model.FatorAtividadeFisicaId;
import com.github.pomona.domain.model.FatorAtividadeFisicaRepo;

public class FatorAtividadeFisicaRepoImpl implements FatorAtividadeFisicaRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public FatorAtividadeFisica adicionar(FatorAtividadeFisica umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<FatorAtividadeFisica> todos() {
		return manager.createQuery("from FatorAtividadeFisica", FatorAtividadeFisica.class).getResultList();
	}

	@Override
	public void remover(FatorAtividadeFisica umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public FatorAtividadeFisica fatorAtividadeFisicaPeloNome(String nome) {
		return manager.createQuery("from FatorAtividadeFisica where nome = :nome", FatorAtividadeFisica.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	public FatorAtividadeFisica porId(AbstractId umaId) {
		try {
			return manager.createQuery("from FatorAtividadeFisica where uuid = :uuid", FatorAtividadeFisica.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public FatorAtividadeFisicaId proximaIdentidade() {
		FatorAtividadeFisicaId fatorAtividadeFisicaId = null;
		do{
			fatorAtividadeFisicaId = new FatorAtividadeFisicaId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(fatorAtividadeFisicaId) != null);
		return fatorAtividadeFisicaId;
	}

}
