package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;

public class RemoverAntropometriaCircunferenciaNaConsultaCommand implements Command {
	private String idAntropometriaCircunferencia;

	public RemoverAntropometriaCircunferenciaNaConsultaCommand(String idAntropometriaCircunferencia) {
		super();
		this.idAntropometriaCircunferencia = idAntropometriaCircunferencia;
	}

	public String getIdAntropometriaCircunferencia() {
		return idAntropometriaCircunferencia;
	}
	
}
