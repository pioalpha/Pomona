package com.github.pomona.application.cardapio.command;

import com.github.common.application.command.Command;

public class AtualizarApresentacaoItemNoCardapioCommand implements Command {
	private String itemCardapioId;
	private String tipoApresentacaoId;

	public AtualizarApresentacaoItemNoCardapioCommand(String itemCardapioId, String tipoApresentacaoId) {
		super();
		this.itemCardapioId = itemCardapioId;
		this.tipoApresentacaoId = tipoApresentacaoId;
	}

	public String getItemCardapioId() {
		return itemCardapioId;
	}

	public String getTipoApresentacaoId() {
		return tipoApresentacaoId;
	}

}
