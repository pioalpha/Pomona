package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

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
