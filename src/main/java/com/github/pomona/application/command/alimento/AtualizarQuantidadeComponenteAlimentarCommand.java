package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarQuantidadeComponenteAlimentarCommand  implements Command{
	private String idComponenteAlimentar;
	private float quantidade;
	
	public AtualizarQuantidadeComponenteAlimentarCommand(String idComponenteAlimentar, float quantidade) {
		super();
		this.idComponenteAlimentar = idComponenteAlimentar;
		this.quantidade = quantidade;
	}
	
	public String getIdComponenteAlimentar() {
		return idComponenteAlimentar;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
