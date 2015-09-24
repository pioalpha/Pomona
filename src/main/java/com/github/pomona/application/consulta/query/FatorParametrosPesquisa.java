package com.github.pomona.application.consulta.query;

import java.util.Date;

import com.github.common.application.query.ParametrosPesquisa;

public class FatorParametrosPesquisa extends ParametrosPesquisa {
	private String nome;
	private Date dataConsulta;

	public FatorParametrosPesquisa(String nome, Date dataConsulta) {
		super();
		
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
