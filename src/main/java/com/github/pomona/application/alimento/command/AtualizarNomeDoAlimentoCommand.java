package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class AtualizarNomeDoAlimentoCommand  implements Command{
	private String alimentoId;
	private String nome;
	
	public AtualizarNomeDoAlimentoCommand(String alimentoId, String nome) {
		super();
		this.alimentoId = alimentoId;
		this.nome = nome;
	}
	
	public String getAlimentoId() {
		return alimentoId;
	}
	
	public String getNome() {
		return nome;
	}
	
}
