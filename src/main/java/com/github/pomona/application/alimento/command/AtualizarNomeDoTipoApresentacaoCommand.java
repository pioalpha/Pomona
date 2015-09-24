package com.github.pomona.application.alimento.command;

import com.github.common.application.command.Command;

public class AtualizarNomeDoTipoApresentacaoCommand  implements Command{
	private String apresentacaoId;
	private String nome;
	
	public AtualizarNomeDoTipoApresentacaoCommand(String apresentacaoId, String nome) {
		super();
		this.apresentacaoId = apresentacaoId;
		this.nome = nome;
	}
	
	public String getApresentacaoId() {
		return apresentacaoId;
	}
	
	public String getNome() {
		return nome;
	}
	
}
