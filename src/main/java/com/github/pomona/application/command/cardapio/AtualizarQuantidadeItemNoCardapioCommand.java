package com.github.pomona.application.command.cardapio;

public class AtualizarQuantidadeItemNoCardapioCommand {
	private String idItemCardapio;
	private float quantidade;
	
	public AtualizarQuantidadeItemNoCardapioCommand(String idItemCardapio, float quantidade) {
		super();
		this.idItemCardapio = idItemCardapio;
		this.quantidade = quantidade;
	}
	
	public String getIdItemCardapio() {
		return idItemCardapio;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
