package com.github.pomona.application.command.diretrizAlimentar;

import com.github.common.service.command.Command;

public class ExcluirNormaDaDiretrizAlimentarCommand implements Command {
	private String normaId;

	public ExcluirNormaDaDiretrizAlimentarCommand(String normaId) {
		super();
		this.normaId = normaId;
	}

	public String getNormaId() {
		return normaId;
	}
	
}
