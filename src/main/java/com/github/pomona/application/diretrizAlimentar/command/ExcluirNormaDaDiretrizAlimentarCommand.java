package com.github.pomona.application.diretrizAlimentar.command;

import com.github.common.application.command.Command;

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
