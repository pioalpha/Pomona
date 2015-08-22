package com.github.pomona.test;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.TipoPreparo;
import com.github.pomona.domain.model.TipoPreparoId;
import com.github.pomona.domain.model.TipoPreparoRepo;

public class TipoPreparoRepoImpl implements TipoPreparoRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public TipoPreparo adicionar(TipoPreparo umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<TipoPreparo> todos() {
		return manager.createQuery("from TipoPreparo", TipoPreparo.class).getResultList();
	}

	@Override
	public void remover(TipoPreparo umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public TipoPreparo tipoPreparoPeloNome(String nome) {
		return manager.createQuery("from TipoPreparo where nome = :nome", TipoPreparo.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	public TipoPreparo porId(AbstractId umaId) {
		try {
			return manager.createQuery("from TipoPreparo where uuid = :uuid", TipoPreparo.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public TipoPreparoId proximaIdentidade() {
		TipoPreparoId tipoPreparoId = null;
		do{
			tipoPreparoId = new TipoPreparoId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(tipoPreparoId) != null);
		return tipoPreparoId;
	}

}
