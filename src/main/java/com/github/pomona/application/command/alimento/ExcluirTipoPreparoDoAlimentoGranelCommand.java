package com.github.pomona.application.command.alimento;

public class ExcluirTipoPreparoDoAlimentoGranelCommand {
	private String idTipoPreparo;

	public ExcluirTipoPreparoDoAlimentoGranelCommand(String idTipoPreparo) {
		super();
		this.idTipoPreparo = idTipoPreparo;
	}

	public String getIdPreparo() {
		return idTipoPreparo;
	}
	
}
