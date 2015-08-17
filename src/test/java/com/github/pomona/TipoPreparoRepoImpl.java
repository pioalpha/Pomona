package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.TipoPreparo;
import com.github.pomona.domain.model.TipoPreparoId;
import com.github.pomona.domain.model.TipoPreparoRepo;

public class TipoPreparoRepoImpl implements TipoPreparoRepo {
	private Map<TipoPreparoId, TipoPreparo> repo = new HashMap<TipoPreparoId, TipoPreparo>();

	@Override
	public void adicionar(TipoPreparo umObjeto) {
		repo.put(umObjeto.tipoPreparoId(), umObjeto);
	}

	@Override
	public Collection<TipoPreparo> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(TipoPreparo umObjeto) {
		repo.remove(umObjeto.tipoPreparoId());
	}

	@Override
	public TipoPreparo tipoPreparoPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoPreparo objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public TipoPreparoId proximaIdentidade() {
		TipoPreparoId tipoPreparoId = null;
		do{
			tipoPreparoId = new TipoPreparoId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(tipoPreparoId));
		return tipoPreparoId;
	}

}
