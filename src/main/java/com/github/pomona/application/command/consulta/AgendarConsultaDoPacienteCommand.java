package com.github.pomona.application.command.consulta;

import java.util.Date;

import com.github.common.service.command.Command;

public class AgendarConsultaDoPacienteCommand implements Command {
	private String planoAlimentarId;
	private Date dataConsulta;
	
	public AgendarConsultaDoPacienteCommand(String planoAlimentarId, Date dataConsulta) {
		super();
		this.planoAlimentarId = planoAlimentarId;
		this.dataConsulta = dataConsulta;
	}
	
	public String getPlanoAlimentarId() {
		return planoAlimentarId;
	}
	
	public Date getDataConsulta() {
		return dataConsulta;
	}
	
}
