package com.github.pomona.application.command.consulta;

import java.util.Date;

import com.github.common.service.command.Command;

public class AgendarConsultaDoPacienteCommand implements Command {
	private String idPlanoAlimentar;
	private Date dataConsulta;
	
	public AgendarConsultaDoPacienteCommand(String idPlanoAlimentar, Date dataConsulta) {
		super();
		this.idPlanoAlimentar = idPlanoAlimentar;
		this.dataConsulta = dataConsulta;
	}
	
	public String getIdPlanoAlimentar() {
		return idPlanoAlimentar;
	}
	
	public Date getDataConsulta() {
		return dataConsulta;
	}
	
}
