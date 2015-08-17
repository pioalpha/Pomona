package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

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
