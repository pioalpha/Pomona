package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

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
