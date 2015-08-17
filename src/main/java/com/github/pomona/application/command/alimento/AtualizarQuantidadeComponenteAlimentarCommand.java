package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarQuantidadeComponenteAlimentarCommand  implements Command{
	private String componenteAlimentarId;
	private float quantidade;
	
	public AtualizarQuantidadeComponenteAlimentarCommand(String componenteAlimentarId, float quantidade) {
		super();
		this.componenteAlimentarId = componenteAlimentarId;
		this.quantidade = quantidade;
	}
	
	public String getComponenteAlimentarId() {
		return componenteAlimentarId;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
