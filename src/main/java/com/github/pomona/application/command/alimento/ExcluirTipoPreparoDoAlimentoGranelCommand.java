package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class ExcluirTipoPreparoDoAlimentoGranelCommand implements Command {
	private String idTipoPreparo;

	public ExcluirTipoPreparoDoAlimentoGranelCommand(String idTipoPreparo) {
		super();
		this.idTipoPreparo = idTipoPreparo;
	}

	public String getIdPreparo() {
		return idTipoPreparo;
	}
	
}
