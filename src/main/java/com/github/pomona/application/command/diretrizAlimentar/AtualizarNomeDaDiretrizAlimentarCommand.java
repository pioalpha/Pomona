package com.github.pomona.application.command.diretrizAlimentar;

import com.github.common.service.command.Command;

public class AtualizarNomeDaDiretrizAlimentarCommand implements Command {
	private String idDiretrizAlimentar;
	private String nome;
	
	public AtualizarNomeDaDiretrizAlimentarCommand(String idDiretrizAlimentar, String nome) {
		super();
		this.idDiretrizAlimentar = idDiretrizAlimentar;
		this.nome = nome;
	}
	
	public String getIdDiretrizAlimentar() {
		return idDiretrizAlimentar;
	}
	
	public String getNome() {
		return nome;
	}
	
}
