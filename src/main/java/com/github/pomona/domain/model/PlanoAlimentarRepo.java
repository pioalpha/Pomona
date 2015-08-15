package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface PlanoAlimentarRepo extends GenericoRepo<PlanoAlimentar, PlanoAlimentarId> {
	public PlanoAlimentar planoAlimentarPeloNomePaciente(String nome);
}
