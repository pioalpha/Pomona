package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class CadastrarTipoApresentacaoDoAlimentoGranelCommand implements Command {
	private String nome;

	public CadastrarTipoApresentacaoDoAlimentoGranelCommand(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
