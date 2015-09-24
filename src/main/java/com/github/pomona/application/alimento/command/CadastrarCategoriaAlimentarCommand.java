package com.github.pomona.application.alimento.command;

public class CadastrarCategoriaAlimentarCommand {
	private String nome;
	private Float caloriasPorPorcao;

	public CadastrarCategoriaAlimentarCommand(String nome, Float caloriasPorPorcao) {
		super();
		
		this.nome = nome;
		this.caloriasPorPorcao = caloriasPorPorcao;
	}

	public CadastrarCategoriaAlimentarCommand(String nome) {
		this(nome, null);
	}
	
	public String getNome() {
		return nome;
	}

	public Float getCaloriasPorPorcao() {
		return caloriasPorPorcao;
	}

}
