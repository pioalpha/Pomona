package com.github.pomona.application.command.cardapio;

public class ExcluirItemDoCardapioCommand {
	private String idItemCardapio;

	public ExcluirItemDoCardapioCommand(String idItemCardapio) {
		super();
		this.idItemCardapio = idItemCardapio;
	}

	public String getIdItemCardapio() {
		return idItemCardapio;
	}
	
}
