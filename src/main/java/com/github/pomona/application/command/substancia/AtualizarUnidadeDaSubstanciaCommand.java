package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class AtualizarUnidadeDaSubstanciaCommand implements Command {
	private String substanciaId;
	private UnidadeSubstancia unidadeSubstancia;
	
	public AtualizarUnidadeDaSubstanciaCommand(String substanciaId, UnidadeSubstancia unidadeSubstancia) {
		super();
		this.substanciaId = substanciaId;
		this.unidadeSubstancia = unidadeSubstancia;
	}
	
	public String getSubstanciaId() {
		return substanciaId;
	}
	
	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}
	
}
