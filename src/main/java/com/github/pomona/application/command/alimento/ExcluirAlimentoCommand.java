package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class ExcluirAlimentoCommand implements Command {
	private String alimentoId;

	public ExcluirAlimentoCommand(String alimentoId) {
		super();
		this.alimentoId = alimentoId;
	}

	public String getAlimentoId() {
		return alimentoId;
	}
	
}
