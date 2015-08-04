package com.github.pomona.application.command.alimento;

public class AtualizarNomeDoTipoMedidaCommand {
	private String idTipoMedida;
	private String nome;
	
	public AtualizarNomeDoTipoMedidaCommand(String idTipoMedida, String nome) {
		super();
		this.idTipoMedida = idTipoMedida;
		this.nome = nome;
	}
	
	public String getIdTipoMedida() {
		return idTipoMedida;
	}
	
	public String getNome() {
		return nome;
	}
	
}
