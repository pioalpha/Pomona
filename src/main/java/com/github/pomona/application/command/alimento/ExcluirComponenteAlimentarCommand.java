package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class ExcluirComponenteAlimentarCommand implements Command {
	private String idComponenteAlimentar;

	public ExcluirComponenteAlimentarCommand(String idComponenteAlimentar) {
		super();
		this.idComponenteAlimentar = idComponenteAlimentar;
	}

	public String getIdComponenteAlimentar() {
		return idComponenteAlimentar;
	}
	
}
