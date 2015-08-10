package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;

public class AtualizarNomeDoPacienteCommand implements Command {
	private String idPlanoAlimentar;
	private String nome;

	public AtualizarNomeDoPacienteCommand(String idPlanoAlimentar, String nome) {
		super();
		this.idPlanoAlimentar = idPlanoAlimentar;
		this.nome = nome;
	}
	
	public String getIdPlanoAlimentar() {
		return idPlanoAlimentar;
	}
	
	public String getNome() {
		return nome;
	}
}
