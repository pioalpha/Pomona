package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.DivisaoRefeicaoId;
import com.github.pomona.domain.model.DivisaoRefeicaoRepo;

public class DivisaoRefeicaoRepoImpl implements DivisaoRefeicaoRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public DivisaoRefeicao adicionar(DivisaoRefeicao umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<DivisaoRefeicao> todos() {
		return manager.createQuery("from DivisaoRefeicao", DivisaoRefeicao.class).getResultList();
	}

	@Override
	public void remover(DivisaoRefeicao umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public DivisaoRefeicao divisaoRefeicaoPeloNome(String nome) {
		return manager.createQuery("from DivisaoRefeicao where nome = :nome", DivisaoRefeicao.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	public DivisaoRefeicao porId(AbstractId umaId) {
		try {
			return manager.createQuery("from DivisaoRefeicao where uuid = :uuid", DivisaoRefeicao.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public DivisaoRefeicaoId proximaIdentidade() {
		DivisaoRefeicaoId divisaoRefeicaoId = null;
		do{
			divisaoRefeicaoId = new DivisaoRefeicaoId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(divisaoRefeicaoId) != null);
		return divisaoRefeicaoId;
	}


}
