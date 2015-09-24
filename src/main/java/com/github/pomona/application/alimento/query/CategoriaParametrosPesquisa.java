package com.github.pomona.application.alimento.query;

import com.github.common.application.query.ParametrosPesquisa;

public class CategoriaParametrosPesquisa extends ParametrosPesquisa {
	private String nome;

	public CategoriaParametrosPesquisa() {
		super();
	}

	public CategoriaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);
	}

	public CategoriaParametrosPesquisa(String nome) {
		super();

		this.nome = nome;
	}

	public CategoriaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, String nome) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
