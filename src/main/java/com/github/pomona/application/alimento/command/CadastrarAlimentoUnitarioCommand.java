package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class CadastrarAlimentoUnitarioCommand implements Command {
	private String nome;
	private String categoriaAlimentoId;

	public CadastrarAlimentoUnitarioCommand(String nome, String categoriaAlimentoId) {
		super();
		
		this.nome = nome;
		this.categoriaAlimentoId = categoriaAlimentoId;
	}

	public String getNome() {
		return nome;
	}

	public String getCategoriaAlimentoId() {
		return categoriaAlimentoId;
	}
	
}
