package com.github.pomona.application.alimento.query;

import java.util.Date;

import com.github.common.application.query.ParametrosPesquisa;

public class ComponenteParametrosPesquisa extends ParametrosPesquisa {
	private String uuidAlimento;
	private String nomeAlimento;
	private Date dataConsulta;
	
	public ComponenteParametrosPesquisa() {
		super();

		this.dataConsulta = new Date();
	}

	public ComponenteParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.dataConsulta = new Date();
	}

	public ComponenteParametrosPesquisa(String uuidAlimento, String nomeAlimento, Date dataConsulta) {
		super();

		this.uuidAlimento = uuidAlimento;
		this.nomeAlimento = nomeAlimento;
		this.dataConsulta = dataConsulta;
	}

	public ComponenteParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, String uuidAlimento, String nomeAlimento, Date dataConsulta) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.uuidAlimento = uuidAlimento;
		this.nomeAlimento = nomeAlimento;
		this.dataConsulta = dataConsulta;
	}
	
	public String getUuidAlimento() {
		return uuidAlimento;
	}

	public String getNomeAlimento() {
		return nomeAlimento;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

}
