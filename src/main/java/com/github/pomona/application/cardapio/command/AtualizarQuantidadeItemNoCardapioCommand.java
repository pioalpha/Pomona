package com.github.pomona.application.cardapio.command;

import com.github.common.application.command.Command;

public class AtualizarQuantidadeItemNoCardapioCommand implements Command {
	private String itemCardapioId;
	private float quantidade;
	
	public AtualizarQuantidadeItemNoCardapioCommand(String itemCardapioId, float quantidade) {
		super();
		this.itemCardapioId = itemCardapioId;
		this.quantidade = quantidade;
	}
	
	public String getItemCardapioId() {
		return itemCardapioId;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
