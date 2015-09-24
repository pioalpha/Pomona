package com.github.pomona.application.diretrizAlimentar.command;

import com.github.common.application.command.Command;

public class ExcluirDiretrizAlimentarCommand implements Command {
	private String diretrizAlimentarId;

	public ExcluirDiretrizAlimentarCommand(String diretrizAlimentarId) {
		super();
		this.diretrizAlimentarId = diretrizAlimentarId;
	}

	public String getDiretrizAlimentarId() {
		return diretrizAlimentarId;
	}
	
}
