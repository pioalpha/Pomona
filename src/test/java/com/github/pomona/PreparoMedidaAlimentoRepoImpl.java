package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.PreparoMedidaAlimento;
import com.github.pomona.domain.model.PreparoMedidaAlimentoId;
import com.github.pomona.domain.model.PreparoMedidaAlimentoRepo;

public class PreparoMedidaAlimentoRepoImpl implements PreparoMedidaAlimentoRepo {
	private Map<PreparoMedidaAlimentoId, PreparoMedidaAlimento> repo = new HashMap<PreparoMedidaAlimentoId, PreparoMedidaAlimento>();

	@Override
	public void adicionar(PreparoMedidaAlimento umObjeto) {
		repo.put(umObjeto.preparoMedidaAlimentoId(), umObjeto);
	}

	@Override
	public Collection<PreparoMedidaAlimento> todosObjetos() {
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
	public PreparoMedidaAlimento objetoDeId(AbstractId umaId) {
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
