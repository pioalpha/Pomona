package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class CadastrarTipoPreparoDoAlimentoGranelCommand implements Command {
	private String nome;

	public CadastrarTipoPreparoDoAlimentoGranelCommand(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
