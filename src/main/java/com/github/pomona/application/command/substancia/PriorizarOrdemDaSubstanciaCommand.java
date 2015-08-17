package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;

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
