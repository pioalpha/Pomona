package com.github.pomona.application.command.consulta;

public class RemoverAntropometriaDobraNaConsultaCommand {
	private String idAntropometriaDobra;

	public RemoverAntropometriaDobraNaConsultaCommand(String idAntropometriaDobra) {
		super();
		this.idAntropometriaDobra = idAntropometriaDobra;
	}

	public String getIdAntropometriaDobra() {
		return idAntropometriaDobra;
	}

}
