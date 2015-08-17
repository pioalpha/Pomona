package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarNomeDoTipoPreparoCommand  implements Command{
	private String preparoId;
	private String nome;
	
	public AtualizarNomeDoTipoPreparoCommand(String preparoId, String nome) {
		super();
		this.preparoId = preparoId;
		this.nome = nome;
	}
	
	public String getPreparoId() {
		return preparoId;
	}
	
	public String getNome() {
		return nome;
	}
	
}
