package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;

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
