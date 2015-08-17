package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class CadastrarPreparoMedidaDoAlimentoGranelCommand implements Command {
	public String alimentoGranelId;
	public String tipoPreparoId;
	public String tipoMedidaId;
	public float quantidade;
	
	public CadastrarPreparoMedidaDoAlimentoGranelCommand(String alimentoGranelId, String tipoPreparoId,
			String tipoMedidaId, float quantidade) {
		super();
		this.alimentoGranelId = alimentoGranelId;
		this.tipoPreparoId = tipoPreparoId;
		this.tipoMedidaId = tipoMedidaId;
		this.quantidade = quantidade;
	}
	
	public String getAlimentoGranelId() {
		return alimentoGranelId;
	}
	
	public String getTipoPreparoId() {
		return tipoPreparoId;
	}
	
	public String getTipoMedidaId() {
		return tipoMedidaId;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
