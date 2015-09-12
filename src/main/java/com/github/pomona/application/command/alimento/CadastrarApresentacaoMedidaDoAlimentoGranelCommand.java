package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class CadastrarApresentacaoMedidaDoAlimentoGranelCommand implements Command {
	public String alimentoGranelId;
	public String tipoApresentacaoId;
	public String tipoMedidaId;
	public float quantidade;
	
	public CadastrarApresentacaoMedidaDoAlimentoGranelCommand(String alimentoGranelId, String tipoApresentacaoId,
			String tipoMedidaId, float quantidade) {
		super();
		this.alimentoGranelId = alimentoGranelId;
		this.tipoApresentacaoId = tipoApresentacaoId;
		this.tipoMedidaId = tipoMedidaId;
		this.quantidade = quantidade;
	}
	
	public String getAlimentoGranelId() {
		return alimentoGranelId;
	}
	
	public String getTipoApresentacaoId() {
		return tipoApresentacaoId;
	}
	
	public String getTipoMedidaId() {
		return tipoMedidaId;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
