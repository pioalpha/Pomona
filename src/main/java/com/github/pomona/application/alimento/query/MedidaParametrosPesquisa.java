package com.github.pomona.application.alimento.query;

import com.github.common.application.query.ParametrosPesquisa;

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
