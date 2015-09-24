package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class AtualizarCategoriaDoAlimentoCommand implements Command{
	private String alimentoId;
	private String categoriaId;
	
	public AtualizarCategoriaDoAlimentoCommand(String alimentoId, String categoriaId) {
		super();
		
		this.alimentoId = alimentoId;
		this.categoriaId = categoriaId;
	}

	public String getAlimentoId() {
		return alimentoId;
	}

	public String getCategoriaId() {
		return categoriaId;
	}
	
}
