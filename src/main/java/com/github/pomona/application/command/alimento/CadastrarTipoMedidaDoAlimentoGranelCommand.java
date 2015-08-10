package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

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
