package com.github.pomona.application.command.cardapio;

import com.github.common.service.command.Command;

public class AtualizarPreparoItemNoCardapioCommand implements Command {
	private String itemCardapioId;
	private String tipoPreparoId;

	public AtualizarPreparoItemNoCardapioCommand(String itemCardapioId, String tipoPreparoId) {
		super();
		this.itemCardapioId = itemCardapioId;
		this.tipoPreparoId = tipoPreparoId;
	}

	public String getItemCardapioId() {
		return itemCardapioId;
	}

	public String getTipoPreparoId() {
		return tipoPreparoId;
	}

}
