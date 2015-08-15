package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface TipoPreparoRepo extends GenericoRepo<TipoPreparo, TipoPreparoId> {
	public TipoPreparo tipoPreparoPeloNome(String nome);
}
