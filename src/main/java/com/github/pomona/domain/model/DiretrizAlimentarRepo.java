package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface DiretrizAlimentarRepo extends GenericoRepo<DiretrizAlimentar, DiretrizAlimentarId> {
	public DiretrizAlimentar diretrizAlimentarPeloNome(String nome);
}
