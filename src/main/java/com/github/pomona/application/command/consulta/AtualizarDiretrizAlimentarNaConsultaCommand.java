package com.github.pomona.application.command.consulta;

import com.github.common.service.command.Command;

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
