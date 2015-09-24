package com.github.pomona.application.alimento.query;

import java.util.Date;

import com.github.common.application.query.ParametrosPesquisa;

public class AlimentoParametrosPesquisa extends ParametrosPesquisa {
	private String nome;
	private String categoria;
	private Date dataConsulta;
	
	public AlimentoParametrosPesquisa() {
		super();
		
		this.dataConsulta = new Date();
	}
	
	public AlimentoParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.dataConsulta = new Date();
	}
	
	public AlimentoParametrosPesquisa(Date dataConsulta, String nome, String categoria) {
		super();
		
		this.nome = nome;
		this.categoria = categoria;
		this.dataConsulta = dataConsulta; // Data não deve ser nula
	}

	public AlimentoParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, Date dataConsulta, String nome,
			String categoria) {
		super(numeroResultadosPorPagina, numeroDaPagina);
		
		this.nome = nome;
		this.categoria = categoria;
		this.dataConsulta = dataConsulta; // Data não deve ser nula
	}
	
	public String getNome() {
		return nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}
	
}
