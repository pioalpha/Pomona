package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class ExcluirPreparoMedidaDoAlimentoGranelCommand implements Command {
	private String idPreparoMedida;

	public ExcluirPreparoMedidaDoAlimentoGranelCommand(String idPreparoMedida) {
		super();
		this.idPreparoMedida = idPreparoMedida;
	}

	public String getIdPreparoMedida() {
		return idPreparoMedida;
	}
	
}
