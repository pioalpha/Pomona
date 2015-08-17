package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarPorcaoPreparoMedidaDoAlimentoCommand implements Command {
	private String preparoMedidaId;
	private float porcao;
	
	public AtualizarPorcaoPreparoMedidaDoAlimentoCommand(String preparoMedidaId, float porcao) {
		super();
		this.preparoMedidaId = preparoMedidaId;
		this.porcao = porcao;
	}
	
	public String getPreparoMedidaId() {
		return preparoMedidaId;
	}
	
	public float getPorcao() {
		return porcao;
	}
	
}
