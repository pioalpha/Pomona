package com.github.pomona.application.command.diretrizAlimentar;

import com.github.common.service.command.Command;

public class DesativarDiretrizAlimentarCommand implements Command {
	private String idDiretrizAlimentar;

	public DesativarDiretrizAlimentarCommand(String idDiretrizAlimentar) {
		super();
		this.idDiretrizAlimentar = idDiretrizAlimentar;
	}

	public String getIdDiretrizAlimentar() {
		return idDiretrizAlimentar;
	}
	
}
