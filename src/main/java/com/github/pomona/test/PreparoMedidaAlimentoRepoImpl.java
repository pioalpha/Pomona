package com.github.pomona.test;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.PreparoMedidaAlimento;
import com.github.pomona.domain.model.PreparoMedidaAlimentoId;
import com.github.pomona.domain.model.PreparoMedidaAlimentoRepo;

public class PreparoMedidaAlimentoRepoImpl implements PreparoMedidaAlimentoRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public PreparoMedidaAlimento adicionar(PreparoMedidaAlimento umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<PreparoMedidaAlimento> todos() {
		return manager.createQuery("from PreparoMedidaAlimento", PreparoMedidaAlimento.class).getResultList();
	}

	@Override
	public void remover(PreparoMedidaAlimento umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public PreparoMedidaAlimento preparoMedidaAlimentoPeloAlimento(AlimentoGranel alimento) {
		return manager.createQuery("from PreparoMedidaAlimento where alimentoGranel = :alimento", PreparoMedidaAlimento.class)
				.setParameter("alimento", alimento)
				.getSingleResult();
	}

	@Override
	public PreparoMedidaAlimento porId(AbstractId umaId) {
		try {
			return manager.createQuery("from PreparoMedidaAlimento where uuid = :uuid", PreparoMedidaAlimento.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public PreparoMedidaAlimentoId proximaIdentidade() {
		PreparoMedidaAlimentoId preparoMedidaAlimentoId = null;
		do{
			preparoMedidaAlimentoId = new PreparoMedidaAlimentoId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(preparoMedidaAlimentoId) != null);
		return preparoMedidaAlimentoId;
	}

}
