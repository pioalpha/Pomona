package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;

public class RemoverAntropometriaDobraNaConsultaCommand implements Command {
	private String antropometriaDobraId;

	public RemoverAntropometriaDobraNaConsultaCommand(String antropometriaDobraId) {
		super();
		this.antropometriaDobraId = antropometriaDobraId;
	}

	public String getAntropometriaDobraId() {
		return antropometriaDobraId;
	}

}
