package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarNomeDoTipoPreparoCommand  implements Command{
	private String idPreparo;
	private String nome;
	
	public AtualizarNomeDoTipoPreparoCommand(String idPreparo, String nome) {
		super();
		this.idPreparo = idPreparo;
		this.nome = nome;
	}
	
	public String getIdPreparo() {
		return idPreparo;
	}
	
	public String getNome() {
		return nome;
	}
	
}