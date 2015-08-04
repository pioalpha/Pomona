package com.github.pomona.application.command.cardapio;

public class AtualizarPreparoItemNoCardapioCommand {
	private String idItemCardapio;
	private String idTipoPreparo;
	public AtualizarPreparoItemNoCardapioCommand(String idItemCardapio, String idTipoPreparo) {
		super();
		this.idItemCardapio = idItemCardapio;
		this.idTipoPreparo = idTipoPreparo;
	}
	public String getIdItemCardapio() {
		return idItemCardapio;
	}
	public String getIdTipoPreparo() {
		return idTipoPreparo;
	}
	
}
