package com.github.pomona.application.command.consulta;

public class RemoverAntropometriaCircunferenciaNaConsultaCommand {
	private String idAntropometriaCircunferencia;

	public RemoverAntropometriaCircunferenciaNaConsultaCommand(String idAntropometriaCircunferencia) {
		super();
		this.idAntropometriaCircunferencia = idAntropometriaCircunferencia;
	}

	public String getIdAntropometriaCircunferencia() {
		return idAntropometriaCircunferencia;
	}
	
}
