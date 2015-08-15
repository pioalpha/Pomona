package com.github.common.service.query;

import java.util.Collection;

import com.github.common.service.dto.DTO;

public interface Query<TParametros extends ParametrosPesquisa, TResultado extends DTO> {
	public Collection<TResultado> Executar(TParametros parametros);
}
