package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;

public class ExcluirSubstanciaCommand implements Command {
	private String idSubstancia;

	public ExcluirSubstanciaCommand(String idSubstancia) {
		super();
		this.idSubstancia = idSubstancia;
	}

	public String getIdSubstancia() {
		return idSubstancia;
	}
	
}
