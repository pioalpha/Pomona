package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface TipoMedidaRepo extends GenericoRepo<TipoMedida, TipoMedidaId> {
	public TipoMedida tipoMedidaPeloNome(String nome);
}
