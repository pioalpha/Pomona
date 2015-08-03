package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DiretrizAlimentar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4193654293828343527L;
	private String nome;
	private List<NormaAlimentar> normasAlimentares;
	private Date dataRevogacao;
	
	public Date getDataRevogacao() {
		return dataRevogacao;
	}
	public void setDataRevogacao(Date dataRevogacao) {
		this.dataRevogacao = dataRevogacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<NormaAlimentar> getNormasAlimentares() {
		return normasAlimentares;
	}
	public void setNormasAlimentares(List<NormaAlimentar> normasAlimentares) {
		this.normasAlimentares = normasAlimentares;
	}
}
