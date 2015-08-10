package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;

public class RemoverAntropometriaDobraNaConsultaCommand implements Command {
	private String idAntropometriaDobra;

	public RemoverAntropometriaDobraNaConsultaCommand(String idAntropometriaDobra) {
		super();
		this.idAntropometriaDobra = idAntropometriaDobra;
	}

	public String getIdAntropometriaDobra() {
		return idAntropometriaDobra;
	}

}
