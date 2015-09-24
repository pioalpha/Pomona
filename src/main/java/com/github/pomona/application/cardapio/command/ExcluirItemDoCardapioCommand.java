package com.github.pomona.application.cardapio.command;

import com.github.common.application.command.Command;

public class ExcluirItemDoCardapioCommand implements Command {
	private String itemCardapioId;

	public ExcluirItemDoCardapioCommand(String itemCardapioId) {
		super();
		this.itemCardapioId = itemCardapioId;
	}

	public String getIdItemCardapio() {
		return itemCardapioId;
	}
	
}
