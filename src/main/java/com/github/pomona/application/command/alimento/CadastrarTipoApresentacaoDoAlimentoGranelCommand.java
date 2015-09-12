package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

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
