package com.github.pomona.application.command.diretrizAlimentar;

import com.github.common.service.command.Command;

public class ExcluirDiretrizAlimentarCommand implements Command {
	private String idDiretrizAlimentar;

	public ExcluirDiretrizAlimentarCommand(String idDiretrizAlimentar) {
		super();
		this.idDiretrizAlimentar = idDiretrizAlimentar;
	}

	public String getIdDiretrizAlimentar() {
		return idDiretrizAlimentar;
	}
	
}
