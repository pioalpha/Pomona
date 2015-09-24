package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class ExcluirComponenteAlimentarCommand implements Command {
	private String componenteAlimentarId;

	public ExcluirComponenteAlimentarCommand(String componenteAlimentarId) {
		super();
		this.componenteAlimentarId = componenteAlimentarId;
	}

	public String getComponenteAlimentarId() {
		return componenteAlimentarId;
	}
	
}
