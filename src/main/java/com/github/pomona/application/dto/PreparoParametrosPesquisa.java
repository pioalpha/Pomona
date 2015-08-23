package com.github.pomona.application.dto;

import com.github.common.service.query.ParametrosPesquisa;

public class PreparoParametrosPesquisa extends ParametrosPesquisa {
	private String nome;

	public PreparoParametrosPesquisa() {
		super();
	}

	public PreparoParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);
	}

	public PreparoParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, String nome) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.nome = nome;
	}
	
	public PreparoParametrosPesquisa(String nome) {
		super();
		
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
