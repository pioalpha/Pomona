package com.github.common.service.query;

import java.io.Serializable;
import java.util.List;

import com.github.common.service.dto.DTO;

public interface Query<TParametros extends ParametrosPesquisa, TResultado extends DTO> extends Serializable {
	public List<TResultado> Executar(TParametros parametros);
}
