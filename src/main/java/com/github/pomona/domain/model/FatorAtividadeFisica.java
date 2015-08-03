package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;

public class FatorAtividadeFisica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1511121012847428282L;
	private String atividade;
	private float fator;
	private Date dataCadastro;
	private Date dataRevogacao;
	
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public float getFator() {
		return fator;
	}
	public void setFator(float fator) {
		this.fator = fator;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataRevogacao() {
		return dataRevogacao;
	}
	public void setDataRevogacao(Date dataRevogacao) {
		this.dataRevogacao = dataRevogacao;
	}
}
