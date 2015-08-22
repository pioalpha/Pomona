package com.github.pomona.test;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.ClassificacaoIMC;
import com.github.pomona.domain.model.ClassificacaoIMCId;
import com.github.pomona.domain.model.ClassificacaoIMCRepo;

public class ClassificacaoIMCRepoImpl implements ClassificacaoIMCRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public ClassificacaoIMC adicionar(ClassificacaoIMC umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<ClassificacaoIMC> todos() {
		return manager.createQuery("from ClassificacaoIMC", ClassificacaoIMC.class).getResultList();
	}

	@Override
	public void remover(ClassificacaoIMC umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public ClassificacaoIMC classificacaoPeloNome(String nome) {
		return manager.createQuery("from ClassificacaoIMC where nome = :nome", ClassificacaoIMC.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	@Override
	public ClassificacaoIMC porId(AbstractId umaId) {
		try {
			return manager.createQuery("from ClassificacaoIMC where uuid = :uuid", ClassificacaoIMC.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public ClassificacaoIMCId proximaIdentidade() {
		ClassificacaoIMCId classificacaoIMCId = null;
		do{
			classificacaoIMCId = new ClassificacaoIMCId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(classificacaoIMCId) != null);
		return classificacaoIMCId;
	}

}
