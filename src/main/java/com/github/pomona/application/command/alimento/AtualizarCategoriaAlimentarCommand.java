package com.github.pomona.application.command.alimento;

public class AtualizarCategoriaAlimentarCommand {
	private String categoriaAlimentoId;
	private String nome;
	private Float caloriasPorPorcao;

	public AtualizarCategoriaAlimentarCommand(String categoriaAlimentoId, String nome, Float caloriasPorPorcao) {
		super();
		
		this.categoriaAlimentoId = categoriaAlimentoId;
		this.nome = nome;
		this.caloriasPorPorcao = caloriasPorPorcao;
	}

	public String getCategoriaAlimentoId() {
		return categoriaAlimentoId;
	}

	public String getNome() {
		return nome;
	}

	public Float getCaloriasPorPorcao() {
		return caloriasPorPorcao;
	}

}
