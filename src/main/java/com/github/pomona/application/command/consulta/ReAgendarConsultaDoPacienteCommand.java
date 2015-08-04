package com.github.pomona.application.command.consulta;

import java.util.Date;

public class ReAgendarConsultaDoPacienteCommand {
	private String idConsulta;
	private Date novaData;
	
	public ReAgendarConsultaDoPacienteCommand(String idConsulta, Date novaData) {
		super();
		this.idConsulta = idConsulta;
		this.novaData = novaData;
	}
	
	public String getIdConsulta() {
		return idConsulta;
	}
	
	public Date getNovaData() {
		return novaData;
	}
	
}
