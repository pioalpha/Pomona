package com.github.pomona.application.command.diretrizAlimentar;

public class AtualizarNomeDaDiretrizAlimentarCommand {
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
