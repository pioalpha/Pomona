package com.github.pomona.application.command.paciente;

import java.util.Date;

import com.github.common.service.command.Command;

public class CorrigirDataNascimentoDoPacienteCommand implements Command {
	private String idPlanoAlimentar;
	private Date dataNascimento;
	
	public CorrigirDataNascimentoDoPacienteCommand(String idPlanoAlimentar, Date dataNascimento) {
		super();
		this.idPlanoAlimentar = idPlanoAlimentar;
		this.dataNascimento = dataNascimento;
	}
	
	public String getIdPlanoAlimentar() {
		return idPlanoAlimentar;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
}
