package com.github.pomona.application.consulta.command;

import java.util.Date;

import com.github.common.application.command.Command;

public class ReAgendarConsultaDoPacienteCommand implements Command {
	private String consultaId;
	private Date novaData;
	
	public ReAgendarConsultaDoPacienteCommand(String consultaId, Date novaData) {
		super();
		this.consultaId = consultaId;
		this.novaData = novaData;
	}
	
	public String getConsultaId() {
		return consultaId;
	}
	
	public Date getNovaData() {
		return novaData;
	}
	
}
