package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class ExcluirTipoPreparoDoAlimentoGranelCommand implements Command {
	private String tipoPreparoId;

	public ExcluirTipoPreparoDoAlimentoGranelCommand(String tipoPreparoId) {
		super();
		this.tipoPreparoId = tipoPreparoId;
	}

	public String getTipoPreparoId() {
		return tipoPreparoId;
	}
	
}
