package com.github.pomona.application.command.paciente;

import java.util.Date;

public class CorrigirDataNascimentoDoPacienteCommand {
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
