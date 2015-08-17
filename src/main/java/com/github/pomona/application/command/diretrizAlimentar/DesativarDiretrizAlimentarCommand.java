package com.github.pomona.application.command.diretrizAlimentar;

import com.github.common.service.command.Command;

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
