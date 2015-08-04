package com.github.pomona.application.command.alimento;

public class AtualizarNomeDoTipoPreparoCommand {
	private String idPreparo;
	private String nome;
	
	public AtualizarNomeDoTipoPreparoCommand(String idPreparo, String nome) {
		super();
		this.idPreparo = idPreparo;
		this.nome = nome;
	}
	
	public String getIdPreparo() {
		return idPreparo;
	}
	
	public String getNome() {
		return nome;
	}
	
}
