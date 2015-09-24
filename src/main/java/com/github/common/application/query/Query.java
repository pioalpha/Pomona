package com.github.common.application.query;

import java.io.Serializable;
import java.util.List;

public interface Query<TParametros extends ParametrosPesquisa, TResultado extends DTO> extends Serializable {
	public List<TResultado> Executar(TParametros parametros);
}
