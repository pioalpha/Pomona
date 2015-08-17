package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.PreparoMedidaAlimentoId;
import com.github.pomona.domain.model.TipoMedida;
import com.github.pomona.domain.model.TipoMedidaId;
import com.github.pomona.domain.model.TipoMedidaRepo;

public class TipoMedidaRepoImpl implements TipoMedidaRepo {
	private Map<TipoMedidaId, TipoMedida> repo = new HashMap<TipoMedidaId, TipoMedida>();

	@Override
	public void adicionar(TipoMedida umObjeto) {
		repo.put(umObjeto.tipoMedidaId(), umObjeto);
	}

	@Override
	public Collection<TipoMedida> todosObjetos() {
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
	public TipoMedida objetoDeId(AbstractId umaId) {
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
