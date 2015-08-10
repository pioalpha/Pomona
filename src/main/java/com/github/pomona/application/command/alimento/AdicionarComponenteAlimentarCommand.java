package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AdicionarComponenteAlimentarCommand implements Command {
	private String idAlimento;
	private String idSubstancia;
	private float quantidade;
	
	public AdicionarComponenteAlimentarCommand(String idAlimento, String idSubstancia, float quantidade) {
		super();
		this.idAlimento = idAlimento;
		this.idSubstancia = idSubstancia;
		this.quantidade = quantidade;
	}
	
	public String getIdAlimento() {
		return idAlimento;
	}
	
	public String getIdSubstancia() {
		return idSubstancia;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
