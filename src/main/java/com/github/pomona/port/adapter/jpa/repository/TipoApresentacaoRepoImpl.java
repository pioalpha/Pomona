package com.github.pomona.port.adapter.jpa.repository;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.TipoApresentacao;
import com.github.pomona.domain.model.TipoApresentacaoId;
import com.github.pomona.domain.model.TipoApresentacaoRepo;

public class TipoApresentacaoRepoImpl implements TipoApresentacaoRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public TipoApresentacao adicionar(TipoApresentacao umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<TipoApresentacao> todos() {
		return manager.createQuery("from TipoApresentacao", TipoApresentacao.class).getResultList();
	}

	@Override
	public void remover(TipoApresentacao umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public TipoApresentacao tipoApresentacaoPeloNome(String nome) {
		return manager.createQuery("from TipoApresentacao where nome = :nome", TipoApresentacao.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	public TipoApresentacao porId(AbstractId umaId) {
		try {
			return manager.createQuery("from TipoApresentacao where uuid = :uuid", TipoApresentacao.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public TipoApresentacaoId proximaIdentidade() {
		TipoApresentacaoId tipoApresentacaoId = null;
		do{
			tipoApresentacaoId = new TipoApresentacaoId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(tipoApresentacaoId) != null);
		return tipoApresentacaoId;
	}

}
