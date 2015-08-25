package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.query.ParametrosPesquisa;

public class AlimentoParametrosPesquisa extends ParametrosPesquisa {
	private boolean paraEdicao; 
	private String nome;
	private String categoria;
	private Date dataConsulta;
	
	public AlimentoParametrosPesquisa() {
		super();
		
		this.paraEdicao = false;
		this.dataConsulta = new Date();
	}
	
	public AlimentoParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.paraEdicao = false;
		this.dataConsulta = new Date();
	}
	
	public AlimentoParametrosPesquisa(boolean paraEdicao, Date dataConsulta, String nome, String categoria) {
		super();
		
		this.paraEdicao = paraEdicao;
		this.nome = nome;
		this.categoria = categoria;
		this.dataConsulta = dataConsulta; // Data não deve ser nula
	}

	public AlimentoParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, boolean paraEdicao, Date dataConsulta, String nome,
			String categoria) {
		super(numeroResultadosPorPagina, numeroDaPagina);
		
		this.paraEdicao = paraEdicao;
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

	public boolean isParaEdicao() {
		return paraEdicao;
	}
	
}
