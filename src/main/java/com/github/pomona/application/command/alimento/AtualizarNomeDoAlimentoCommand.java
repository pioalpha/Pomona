package com.github.pomona.application.command.alimento;

public class AtualizarNomeDoAlimentoCommand {
	private String idAlimento;
	private String nome;
	
	public AtualizarNomeDoAlimentoCommand(String idAlimento, String nome) {
		super();
		this.idAlimento = idAlimento;
		this.nome = nome;
	}
	
	public String getIdAlimento() {
		return idAlimento;
	}
	
	public String getNome() {
		return nome;
	}
	
}
