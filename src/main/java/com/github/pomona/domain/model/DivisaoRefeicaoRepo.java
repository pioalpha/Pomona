package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface DivisaoRefeicaoRepo extends GenericoRepo<DivisaoRefeicao, DivisaoRefeicaoId> {
	public DivisaoRefeicao divisaoRefeicaoPeloNome(String nome);
}
