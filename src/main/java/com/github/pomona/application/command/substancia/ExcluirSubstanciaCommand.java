package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;

public class ExcluirSubstanciaCommand implements Command {
	private String substanciaId;

	public ExcluirSubstanciaCommand(String substanciaId) {
		super();
		this.substanciaId = substanciaId;
	}

	public String getSubstanciaId() {
		return substanciaId;
	}
	
}
