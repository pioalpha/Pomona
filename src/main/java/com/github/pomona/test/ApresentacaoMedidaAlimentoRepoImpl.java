package com.github.pomona.test;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.ApresentacaoMedidaAlimento;
import com.github.pomona.domain.model.ApresentacaoMedidaAlimentoId;
import com.github.pomona.domain.model.ApresentacaoMedidaAlimentoRepo;

public class ApresentacaoMedidaAlimentoRepoImpl implements ApresentacaoMedidaAlimentoRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public ApresentacaoMedidaAlimento adicionar(ApresentacaoMedidaAlimento umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<ApresentacaoMedidaAlimento> todos() {
		return manager.createQuery("from ApresentacaoMedidaAlimento", ApresentacaoMedidaAlimento.class).getResultList();
	}

	@Override
	public void remover(ApresentacaoMedidaAlimento umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public ApresentacaoMedidaAlimento apresentacaoMedidaAlimentoPeloAlimento(AlimentoGranel alimento) {
		return manager.createQuery("from ApresentacaoMedidaAlimento where alimentoGranel = :alimento", ApresentacaoMedidaAlimento.class)
				.setParameter("alimento", alimento)
				.getSingleResult();
	}

	@Override
	public ApresentacaoMedidaAlimento porId(AbstractId umaId) {
		try {
			return manager.createQuery("from ApresentacaoMedidaAlimento where uuid = :uuid", ApresentacaoMedidaAlimento.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public ApresentacaoMedidaAlimentoId proximaIdentidade() {
		ApresentacaoMedidaAlimentoId apresentacaoMedidaAlimentoId = null;
		do{
			apresentacaoMedidaAlimentoId = new ApresentacaoMedidaAlimentoId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(apresentacaoMedidaAlimentoId) != null);
		return apresentacaoMedidaAlimentoId;
	}

}
