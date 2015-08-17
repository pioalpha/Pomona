package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;

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
