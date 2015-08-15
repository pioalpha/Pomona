package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface FatorMetabolicoRepo extends GenericoRepo<FatorMetabolico, FatorMetabolicoId> {
	public FatorMetabolico fatorMetabolicoPeloNome(String nome);
}
