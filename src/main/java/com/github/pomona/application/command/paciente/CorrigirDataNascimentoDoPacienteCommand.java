package com.github.pomona.application.command.paciente;

import java.util.Date;

import com.github.common.service.command.Command;

public class CorrigirDataNascimentoDoPacienteCommand implements Command {
	private String planoAlimentarId;
	private Date dataNascimento;
	
	public CorrigirDataNascimentoDoPacienteCommand(String planoAlimentarId, Date dataNascimento) {
		super();
		this.planoAlimentarId = planoAlimentarId;
		this.dataNascimento = dataNascimento;
	}
	
	public String getPlanoAlimentarId() {
		return planoAlimentarId;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
}
