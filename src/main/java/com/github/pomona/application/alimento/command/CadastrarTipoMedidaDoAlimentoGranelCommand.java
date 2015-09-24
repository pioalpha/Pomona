package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class CadastrarTipoMedidaDoAlimentoGranelCommand implements Command {
	public String nome;

	public CadastrarTipoMedidaDoAlimentoGranelCommand(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
