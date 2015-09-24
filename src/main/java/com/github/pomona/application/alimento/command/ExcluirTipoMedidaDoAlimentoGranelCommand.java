package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class ExcluirTipoMedidaDoAlimentoGranelCommand implements Command {
	private String tipoMedidaId;

	public ExcluirTipoMedidaDoAlimentoGranelCommand(String tipoMedidaId) {
		super();
		this.tipoMedidaId = tipoMedidaId;
	}

	public String getTipoMedidaId() {
		return tipoMedidaId;
	}
	
}
