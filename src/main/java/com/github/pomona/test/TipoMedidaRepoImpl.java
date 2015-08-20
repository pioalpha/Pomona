package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.TipoMedida;
import com.github.pomona.domain.model.TipoMedidaId;
import com.github.pomona.domain.model.TipoMedidaRepo;

@Singleton
public class TipoMedidaRepoImpl implements TipoMedidaRepo {
	private static final long serialVersionUID = 1L;

	private Map<TipoMedidaId, TipoMedida> repo = new HashMap<TipoMedidaId, TipoMedida>();

	@Override
	public TipoMedida adicionar(TipoMedida umObjeto) {
		repo.put(umObjeto.tipoMedidaId(), umObjeto);
		return null;
	}

	@Override
	public Collection<TipoMedida> todos() {
		return repo.values();
	}

	@Override
	public void remover(TipoMedida umObjeto) {
		repo.remove(umObjeto.tipoMedidaId());
	}

	@Override
	public TipoMedida tipoMedidaPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoMedida porId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public TipoMedidaId proximaIdentidade() {
		TipoMedidaId tipoMedidaId = null;
		do{
			tipoMedidaId = new TipoMedidaId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(tipoMedidaId));
		return tipoMedidaId;
	}

}
