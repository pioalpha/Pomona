package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.query.ParametrosPesquisa;

public class SubstanciaParametrosPesquisa extends ParametrosPesquisa {
	private String nome;
	private Date dataConsulta;
	
	public SubstanciaParametrosPesquisa() {
		super();
		this.dataConsulta = new Date();
	}

	public SubstanciaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);
		this.dataConsulta = new Date();
	}

	public SubstanciaParametrosPesquisa(String nome, Date dataConsulta) {
		super();

		this.nome = nome;
		this.dataConsulta = dataConsulta;
	}
	
	public SubstanciaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, String nome, Date dataConsulta) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.nome = nome;
		this.dataConsulta = dataConsulta;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

}
