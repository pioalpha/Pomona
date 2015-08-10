package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarNomeDoTipoMedidaCommand  implements Command{
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
