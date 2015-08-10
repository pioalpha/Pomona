package com.github.pomona.application.command.cardapio;

import com.github.common.service.command.Command;

public class ExcluirItemDoCardapioCommand implements Command {
	private String idItemCardapio;

	public ExcluirItemDoCardapioCommand(String idItemCardapio) {
		super();
		this.idItemCardapio = idItemCardapio;
	}

	public String getIdItemCardapio() {
		return idItemCardapio;
	}
	
}
