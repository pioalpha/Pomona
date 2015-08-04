package com.github.pomona.application.command.alimento;

public class ExcluirTipoMedidaDoAlimentoGranelCommand {
	private String idTipoMedida;

	public ExcluirTipoMedidaDoAlimentoGranelCommand(String idTipoMedida) {
		super();
		this.idTipoMedida = idTipoMedida;
	}

	public String getIdTipoMedida() {
		return idTipoMedida;
	}
	
}
