package com.github.pomona.application.command.alimento;

public class ExcluirPreparoMedidaDoAlimentoGranelCommand {
	private String idPreparoMedida;

	public ExcluirPreparoMedidaDoAlimentoGranelCommand(String idPreparoMedida) {
		super();
		this.idPreparoMedida = idPreparoMedida;
	}

	public String getIdPreparoMedida() {
		return idPreparoMedida;
	}
	
}
