package com.github.pomona.application.command.alimento;

public class AtualizarQuantidadeComponenteAlimentarCommand {
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
