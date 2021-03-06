package com.github.pomona.application.diretrizAlimentar.command;

import com.github.common.application.command.Command;

public class AtualizarNomeDaDiretrizAlimentarCommand implements Command {
	private String diretrizAlimentarId;
	private String nome;
	
	public AtualizarNomeDaDiretrizAlimentarCommand(String diretrizAlimentarId, String nome) {
		super();
		this.diretrizAlimentarId = diretrizAlimentarId;
		this.nome = nome;
	}
	
	public String getDiretrizAlimentarId() {
		return diretrizAlimentarId;
	}
	
	public String getNome() {
		return nome;
	}
	
}
