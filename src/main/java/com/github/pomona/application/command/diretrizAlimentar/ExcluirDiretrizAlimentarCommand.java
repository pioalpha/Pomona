package com.github.pomona.application.command.diretrizAlimentar;

import com.github.common.service.command.Command;

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
