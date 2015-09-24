package com.github.pomona.application.diretrizAlimentar.query;

import java.util.Date;

import com.github.common.application.query.ParametrosPesquisa;

public class DiretrizParametrosPesquisa extends ParametrosPesquisa {
	private String nome;
	private boolean incluirDesativados;
	private Date dataConsulta;

	public DiretrizParametrosPesquisa(String nome, boolean incluirDesativados, Date dataConsulta) {
		super();
		
		this.nome = nome;
		this.incluirDesativados = incluirDesativados;
		this.dataConsulta = dataConsulta;
	}

	public String getNome() {
		return nome;
	}

	public boolean incluirDesativados() {
		return incluirDesativados;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

}
