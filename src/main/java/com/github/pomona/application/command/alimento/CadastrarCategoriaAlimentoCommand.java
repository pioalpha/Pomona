package com.github.pomona.application.command.alimento;

public class CadastrarCategoriaAlimentoCommand {
	private String nome;

	public CadastrarCategoriaAlimentoCommand(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
