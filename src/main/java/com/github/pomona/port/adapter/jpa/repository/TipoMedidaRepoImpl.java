package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.TipoMedida;
import com.github.pomona.domain.model.TipoMedidaId;
import com.github.pomona.domain.model.TipoMedidaRepo;

public class TipoMedidaRepoImpl implements TipoMedidaRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public TipoMedida adicionar(TipoMedida umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<TipoMedida> todos() {
		return manager.createQuery("from TipoMedida", TipoMedida.class).getResultList();
	}

	@Override
	public void remover(TipoMedida umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public TipoMedida tipoMedidaPeloNome(String nome) {
		return manager.createQuery("from TipoMedida where nome = :nome", TipoMedida.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	public TipoMedida porId(AbstractId umaId) {
		try {
			return manager.createQuery("from TipoMedida where uuid = :uuid", TipoMedida.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public TipoMedidaId proximaIdentidade() {
		TipoMedidaId tipoMedidaId = null;
		do{
			tipoMedidaId = new TipoMedidaId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(tipoMedidaId) != null);
		return tipoMedidaId;
	}

}
