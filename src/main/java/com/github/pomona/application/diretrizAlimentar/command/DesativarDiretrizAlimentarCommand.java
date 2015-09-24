package com.github.pomona.application.diretrizAlimentar.command;

import com.github.common.application.command.Command;

public class DesativarDiretrizAlimentarCommand implements Command {
	private String diretrizAlimentarId;

	public DesativarDiretrizAlimentarCommand(String diretrizAlimentarId) {
		super();
		this.diretrizAlimentarId = diretrizAlimentarId;
	}

	public String getDiretrizAlimentarId() {
		return diretrizAlimentarId;
	}
	
}
