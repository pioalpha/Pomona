package com.github.pomona.application.consulta.command;

import com.github.common.application.command.Command;

public class AtualizarDiretrizAlimentarNaConsultaCommand implements Command {
	private String consultaId;
	private String diretrizAlimentarId;

	public AtualizarDiretrizAlimentarNaConsultaCommand(String consultaId, String diretrizAlimentarId) {
		super();
		this.consultaId = consultaId;
		this.diretrizAlimentarId = diretrizAlimentarId;
	}

	public String getConsultaId() {
		return consultaId;
	}

	public String getDiretrizAlimentarId() {
		return diretrizAlimentarId;
	}

}
