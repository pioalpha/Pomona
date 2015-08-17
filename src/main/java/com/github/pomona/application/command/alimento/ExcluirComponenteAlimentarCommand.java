package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

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
