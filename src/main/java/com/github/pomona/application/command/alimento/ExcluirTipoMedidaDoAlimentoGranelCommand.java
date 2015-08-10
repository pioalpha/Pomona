package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class ExcluirTipoMedidaDoAlimentoGranelCommand implements Command {
	private String idTipoMedida;

	public ExcluirTipoMedidaDoAlimentoGranelCommand(String idTipoMedida) {
		super();
		this.idTipoMedida = idTipoMedida;
	}

	public String getIdTipoMedida() {
		return idTipoMedida;
	}
	
}
