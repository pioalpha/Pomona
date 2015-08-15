package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface EnergiaAlimentoRepo extends GenericoRepo<EnergiaAlimento, EnergiaAlimentoId> {
	public EnergiaAlimento energiaAlimentoPeloAlimento(AlimentoUnitario alimento);
}
