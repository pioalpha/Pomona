package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.TipoPreparo;
import com.github.pomona.domain.model.TipoPreparoId;
import com.github.pomona.domain.model.TipoPreparoRepo;

@Singleton
public class TipoPreparoRepoImpl implements TipoPreparoRepo {
	private static final long serialVersionUID = 1L;

	private Map<TipoPreparoId, TipoPreparo> repo = new HashMap<TipoPreparoId, TipoPreparo>();

	@Override
	public TipoPreparo adicionar(TipoPreparo umObjeto) {
		repo.put(umObjeto.tipoPreparoId(), umObjeto);
		return null;
	}

	@Override
	public Collection<TipoPreparo> todos() {
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
	public TipoPreparo porId(AbstractId umaId) {
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
