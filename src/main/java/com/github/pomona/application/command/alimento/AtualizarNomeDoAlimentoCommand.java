package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarNomeDoAlimentoCommand  implements Command{
	private String idAlimento;
	private String nome;
	
	public AtualizarNomeDoAlimentoCommand(String idAlimento, String nome) {
		super();
		this.idAlimento = idAlimento;
		this.nome = nome;
	}
	
	public String getIdAlimento() {
		return idAlimento;
	}
	
	public String getNome() {
		return nome;
	}
	
}
