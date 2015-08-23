package com.github.pomona.application.dto;

import com.github.common.service.query.ParametrosPesquisa;

public class MedidaParametrosPesquisa extends ParametrosPesquisa {
	private String nome;

	public MedidaParametrosPesquisa() {
		super();
	}

	public MedidaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);
	}

	public MedidaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, String nome) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.nome = nome;
	}
	
	public MedidaParametrosPesquisa(String nome) {
		super();
		
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
