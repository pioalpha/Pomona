package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;

public class RemoverAntropometriaCircunferenciaNaConsultaCommand implements Command {
	private String antropometriaCircunferenciaId;

	public RemoverAntropometriaCircunferenciaNaConsultaCommand(String antropometriaCircunferenciaId) {
		super();
		this.antropometriaCircunferenciaId = antropometriaCircunferenciaId;
	}

	public String getAntropometriaCircunferenciaId() {
		return antropometriaCircunferenciaId;
	}
	
}
