package com.github.pomona.domain.model;

import java.util.Date;

import com.github.common.domain.model.GenericoRepo;

import java.util.Collection;

public interface CardapioRepo extends GenericoRepo<Cardapio, CardapioId> {

	public Collection<Cardapio> todosCardapios(Consulta consulta);

	public Cardapio cardapioPelaData(Date dia);

}
