package com.github.pomona.application.substancia.command;

import com.github.common.application.command.Command;

public class PriorizarOrdemDaSubstanciaCommand implements Command {
	private String substanciaId;

	public PriorizarOrdemDaSubstanciaCommand(String substanciaId) {
		super();
		this.substanciaId = substanciaId;
	}

	public String getSubstanciaId() {
		return substanciaId;
	}
	
}
