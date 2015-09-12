package com.github.pomona.application.command.alimento;

public class CadastrarCategoriaAlimentoCommand {
	private String nome;
	private Float caloriasPorPorcao;

	public CadastrarCategoriaAlimentoCommand(String nome, Float caloriasPorPorcao) {
		super();
		
		this.nome = nome;
		this.caloriasPorPorcao = caloriasPorPorcao;
	}

	public CadastrarCategoriaAlimentoCommand(String nome) {
		this(nome, null);
	}
	
	public String getNome() {
		return nome;
	}

	public Float getCaloriasPorPorcao() {
		return caloriasPorPorcao;
	}

}
