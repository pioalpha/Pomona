package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class AtualizarNomeDoTipoMedidaCommand  implements Command{
	private String tipoMedidaId;
	private String nome;
	
	public AtualizarNomeDoTipoMedidaCommand(String tipoMedidaId, String nome) {
		super();
		this.tipoMedidaId = tipoMedidaId;
		this.nome = nome;
	}
	
	public String getTipoMedidaId() {
		return tipoMedidaId;
	}
	
	public String getNome() {
		return nome;
	}
	
}
