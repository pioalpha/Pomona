package com.github.pomona.application.command.alimento;

public class AtualizarCategoriaAlimentoCommand {
	private String categoriaAlimentoId;
	private String nome;

	public AtualizarCategoriaAlimentoCommand(String categoriaAlimentoId, String nome) {
		super();
		this.categoriaAlimentoId = categoriaAlimentoId;
		this.nome = nome;
	}

	public String getCategoriaAlimentoId() {
		return categoriaAlimentoId;
	}

	public String getNome() {
		return nome;
	}

}
