package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarPorcaoPreparoMedidaDoAlimentoCommand implements Command {
	private String idPreparoMedida;
	private float porcao;
	
	public AtualizarPorcaoPreparoMedidaDoAlimentoCommand(String idPreparoMedida, float porcao) {
		super();
		this.idPreparoMedida = idPreparoMedida;
		this.porcao = porcao;
	}
	
	public String getIdPreparoMedida() {
		return idPreparoMedida;
	}
	
	public float getPorcao() {
		return porcao;
	}
	
}
