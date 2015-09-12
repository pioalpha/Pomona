package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class ExcluirTipoApresentacaoDoAlimentoGranelCommand implements Command {
	private String tipoApresentacaoId;

	public ExcluirTipoApresentacaoDoAlimentoGranelCommand(String tipoApresentacaoId) {
		super();
		this.tipoApresentacaoId = tipoApresentacaoId;
	}

	public String getTipoApresentacaoId() {
		return tipoApresentacaoId;
	}
	
}
