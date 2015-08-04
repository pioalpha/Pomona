package com.github.pomona.application.command.divisaoRefeicao;

public class AtualizarNomeDaDivisaoRefeicaoCommand {
	private String idDivisaoRefeicao;
	private String nome;
	
	public AtualizarNomeDaDivisaoRefeicaoCommand(String idDivisaoRefeicao, String nome) {
		super();
		this.idDivisaoRefeicao = idDivisaoRefeicao;
		this.nome = nome;
	}
	
	public String getIdDivisaoRefeicao() {
		return idDivisaoRefeicao;
	}
	
	public String getNome() {
		return nome;
	}
	
}
