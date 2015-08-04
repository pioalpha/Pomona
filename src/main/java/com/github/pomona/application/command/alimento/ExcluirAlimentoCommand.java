package com.github.pomona.application.command.alimento;

public class ExcluirAlimentoCommand {
	private String idAlimento;

	public ExcluirAlimentoCommand(String idAlimento) {
		super();
		this.idAlimento = idAlimento;
	}

	public String getIdAlimento() {
		return idAlimento;
	}
	
}
