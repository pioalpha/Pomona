package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class ExcluirAlimentoCommand implements Command {
	private String idAlimento;

	public ExcluirAlimentoCommand(String idAlimento) {
		super();
		this.idAlimento = idAlimento;
	}

	public String getIdAlimento() {
		return idAlimento;
	}
	
}
