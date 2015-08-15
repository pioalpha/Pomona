package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface FatorAtividadeFisicaRepo extends GenericoRepo<FatorAtividadeFisica, FatorAtividadeFisicaId> {
	public FatorAtividadeFisica fatorAtividadeFisicaPeloNome(String nome);
}
