package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

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
