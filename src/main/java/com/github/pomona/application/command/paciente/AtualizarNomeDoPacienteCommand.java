package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;

public class AtualizarNomeDoPacienteCommand implements Command {
	private String planoAlimentarId;
	private String nome;

	public AtualizarNomeDoPacienteCommand(String planoAlimentarId, String nome) {
		super();
		this.planoAlimentarId = planoAlimentarId;
		this.nome = nome;
	}
	
	public String getPlanoAlimentarId() {
		return planoAlimentarId;
	}
	
	public String getNome() {
		return nome;
	}
}
