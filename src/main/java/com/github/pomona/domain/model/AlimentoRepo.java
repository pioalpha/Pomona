package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface AlimentoRepo extends GenericoRepo<AlimentoUnitario, AlimentoId> {
	public AlimentoUnitario alimentoPeloNome(String nome);
}
