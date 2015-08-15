package com.github.common.service.query;

public abstract class ParametrosPesquisa {
	private Integer numeroResultadosPorPagina;
	private int numeroDaPagina;

	public ParametrosPesquisa() {
		super();
		this.numeroResultadosPorPagina = 20;
		this.numeroDaPagina = 1;
	}

	public Integer getNumeroResultadosPorPagina() {
		return numeroResultadosPorPagina;
	}

	public void setNumeroResultadosPorPagina(int numeroResultadosPorPagina) {
		this.numeroResultadosPorPagina = numeroResultadosPorPagina;
	}

	public int getNumeroDaPagina() {
		return numeroDaPagina;
	}

	public void setNumeroDaPagina(int numeroDaPagina) {
		this.numeroDaPagina = numeroDaPagina;
	}
}
