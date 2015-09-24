package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class AtualizarQuantidadeComponenteAlimentarCommand  implements Command{
	private String alimentoId;
	private String substanciaId;
	private Float quantidade;
	
	public AtualizarQuantidadeComponenteAlimentarCommand(String alimentoId, String substanciaId, Float quantidade) {
		super();
		
		this.alimentoId = alimentoId;
		this.substanciaId = substanciaId;
		this.quantidade = quantidade;
	}
	
	public String getAlimentoId() {
		return alimentoId;
	}
	
	public String getSubstanciaId() {
		return substanciaId;
	}

	public Float getQuantidade() {
		return quantidade;
	}
	
}
