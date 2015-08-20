package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.PreparoMedidaAlimento;
import com.github.pomona.domain.model.PreparoMedidaAlimentoId;
import com.github.pomona.domain.model.PreparoMedidaAlimentoRepo;

@Singleton
public class PreparoMedidaAlimentoRepoImpl implements PreparoMedidaAlimentoRepo {
	private static final long serialVersionUID = 1L;

	private Map<PreparoMedidaAlimentoId, PreparoMedidaAlimento> repo = new HashMap<PreparoMedidaAlimentoId, PreparoMedidaAlimento>();

	@Override
	public PreparoMedidaAlimento adicionar(PreparoMedidaAlimento umObjeto) {
		repo.put(umObjeto.preparoMedidaAlimentoId(), umObjeto);
		return null;
	}

	@Override
	public Collection<PreparoMedidaAlimento> todos() {
		return repo.values();
	}

	@Override
	public void remover(PreparoMedidaAlimento umObjeto) {
		repo.remove(umObjeto.preparoMedidaAlimentoId());
	}

	@Override
	public PreparoMedidaAlimento preparoMedidaAlimentoPeloAlimento(AlimentoGranel alimento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparoMedidaAlimento porId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public PreparoMedidaAlimentoId proximaIdentidade() {
		PreparoMedidaAlimentoId preparoMedidaAlimentoId = null;
		do{
			preparoMedidaAlimentoId = new PreparoMedidaAlimentoId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(preparoMedidaAlimentoId));
		return preparoMedidaAlimentoId;
	}

}
