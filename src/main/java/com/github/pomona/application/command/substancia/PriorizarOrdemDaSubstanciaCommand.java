package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;

public class PriorizarOrdemDaSubstanciaCommand implements Command {
	private String idSubstancia;

	public PriorizarOrdemDaSubstanciaCommand(String idSubstancia) {
		super();
		this.idSubstancia = idSubstancia;
	}

	public String getIdSubstancia() {
		return idSubstancia;
	}
	
}
