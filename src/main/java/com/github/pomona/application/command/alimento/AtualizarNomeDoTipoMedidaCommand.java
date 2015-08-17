package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

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
