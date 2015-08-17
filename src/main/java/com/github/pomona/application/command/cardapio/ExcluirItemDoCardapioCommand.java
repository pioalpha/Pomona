package com.github.pomona.application.command.cardapio;

import com.github.common.service.command.Command;

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
