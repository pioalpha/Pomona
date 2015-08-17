package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class ExcluirPreparoMedidaDoAlimentoGranelCommand implements Command {
	private String preparoMedidaId;

	public ExcluirPreparoMedidaDoAlimentoGranelCommand(String preparoMedidaId) {
		super();
		this.preparoMedidaId = preparoMedidaId;
	}

	public String getPreparoMedidaId() {
		return preparoMedidaId;
	}
	
}
