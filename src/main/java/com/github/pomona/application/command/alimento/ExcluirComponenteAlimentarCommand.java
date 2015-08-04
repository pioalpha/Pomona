package com.github.pomona.application.command.alimento;

public class ExcluirComponenteAlimentarCommand {
	private String idComponenteAlimentar;

	public ExcluirComponenteAlimentarCommand(String idComponenteAlimentar) {
		super();
		this.idComponenteAlimentar = idComponenteAlimentar;
	}

	public String getIdComponenteAlimentar() {
		return idComponenteAlimentar;
	}
	
}
