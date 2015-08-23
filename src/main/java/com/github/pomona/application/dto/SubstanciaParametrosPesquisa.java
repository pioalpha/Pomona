package com.github.pomona.application.dto;

import com.github.common.service.query.ParametrosPesquisa;

public class SubstanciaParametrosPesquisa extends ParametrosPesquisa {
	private String nome;

	
	public SubstanciaParametrosPesquisa() {
		super();
	}

	public SubstanciaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);
	}

	public SubstanciaParametrosPesquisa(String nome) {
		super();

		this.nome = nome;
	}
	
	public SubstanciaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, String nome) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
