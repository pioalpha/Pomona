package com.github.pomona.application.command.diretrizAlimentar;

import com.github.common.service.command.Command;

public class ExcluirNormaDaDiretrizAlimentarCommand implements Command {
	private String idNorma;

	public ExcluirNormaDaDiretrizAlimentarCommand(String idNorma) {
		super();
		this.idNorma = idNorma;
	}

	public String getIdNorma() {
		return idNorma;
	}
	
}
