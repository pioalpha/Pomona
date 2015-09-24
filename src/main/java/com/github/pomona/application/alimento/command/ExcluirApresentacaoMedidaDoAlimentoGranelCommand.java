package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class ExcluirApresentacaoMedidaDoAlimentoGranelCommand implements Command {
	private String apresentacaoMedidaId;

	public ExcluirApresentacaoMedidaDoAlimentoGranelCommand(String apresentacaoMedidaId) {
		super();
		this.apresentacaoMedidaId = apresentacaoMedidaId;
	}

	public String getApresentacaoMedidaId() {
		return apresentacaoMedidaId;
	}
	
}
