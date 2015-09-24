package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class AdicionarComponenteAlimentarCommand implements Command {
	private String alimentoId;
	private String substanciaId;
	private float quantidade;
	
	public AdicionarComponenteAlimentarCommand(String alimentoId, String substanciaId, float quantidade) {
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
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
