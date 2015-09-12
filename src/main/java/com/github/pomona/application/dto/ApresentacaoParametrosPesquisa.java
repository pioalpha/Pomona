package com.github.pomona.application.dto;

import com.github.common.service.query.ParametrosPesquisa;

public class ApresentacaoParametrosPesquisa extends ParametrosPesquisa {
	private String nome;

	public ApresentacaoParametrosPesquisa() {
		super();
	}

	public ApresentacaoParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);
	}

	public ApresentacaoParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, String nome) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.nome = nome;
	}
	
	public ApresentacaoParametrosPesquisa(String nome) {
		super();
		
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
