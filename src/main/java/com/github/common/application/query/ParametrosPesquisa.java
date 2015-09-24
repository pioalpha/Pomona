package com.github.common.application.query;

public abstract class ParametrosPesquisa {
	private Integer numeroResultadosPorPagina;
	private int numeroDaPagina;

	public ParametrosPesquisa() {
		super();
		
		this.numeroResultadosPorPagina = null;
		this.numeroDaPagina = 1;
	}

	public ParametrosPesquisa(Integer numeroResultadosPorPagina, int numeroDaPagina) {
		super();
		
		this.numeroResultadosPorPagina = numeroResultadosPorPagina;
		this.numeroDaPagina = numeroDaPagina;
	}
	
	public Integer getNumeroResultadosPorPagina() {
		return numeroResultadosPorPagina;
	}

	public int getNumeroDaPagina() {
		return numeroDaPagina;
	}
}
