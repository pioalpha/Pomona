package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarPorcaoDoAlimentoGranelCommand  implements Command{
	private String alimentoGranelId;
	private float porcao;
	
	public AtualizarPorcaoDoAlimentoGranelCommand(String alimentoGranelId, float porcao) {
		super();
		this.alimentoGranelId = alimentoGranelId;
		this.porcao = porcao;
	}
	
	public String getAlimentoGranelId() {
		return alimentoGranelId;
	}
	
	public float getPorcao() {
		return porcao;
	}
	
}
