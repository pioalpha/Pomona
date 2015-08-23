package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.query.ParametrosPesquisa;

public class DivisaoParametrosPesquisa extends ParametrosPesquisa {
	private String nome;
	private Date dataConsulta;

	public DivisaoParametrosPesquisa(String nome, Date dataConsulta) {
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
