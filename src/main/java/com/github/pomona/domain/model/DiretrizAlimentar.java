package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiretrizAlimentar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4193654293828343527L;
	private DiretrizAlimentarId diretrizAlimentarId;
	private String nome;
	private List<NormaAlimentar> normasAlimentares;
	private Date dataRevogacao;

	public DiretrizAlimentar() {
		super();
		
		this.normasAlimentares = new ArrayList<NormaAlimentar>();
	}

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

	public DiretrizAlimentarId diretrizAlimentarId() {
		return diretrizAlimentarId;
	}

	public void setDiretrizAlimentarId(DiretrizAlimentarId diretrizAlimentarId) {
		this.diretrizAlimentarId = diretrizAlimentarId;
	}

	@Override
	public String toString() {
		return "DiretrizAlimentar [diretrizAlimentarId=" + diretrizAlimentarId + ", nome=" + nome
				+ ", normasAlimentares=" + normasAlimentares + ", dataRevogacao=" + dataRevogacao + "]";
	}

}
