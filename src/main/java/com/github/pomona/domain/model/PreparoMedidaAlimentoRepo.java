package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface PreparoMedidaAlimentoRepo extends GenericoRepo<PreparoMedidaAlimento, PreparoMedidaAlimentoId> {
	public PreparoMedidaAlimento preparoMedidaAlimentoPeloAlimento(AlimentoGranel alimento);
}
