package com.github.pomona.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class DiretrizAlimentar extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -4193654293828343527L;
	
	@Embedded
	private DiretrizAlimentarId diretrizAlimentarId;
	@Column(nullable = false, length = 100)
	private String nome;
	@OneToMany(mappedBy = "diretrizAlimentar", cascade = CascadeType.ALL)
	private List<NormaAlimentar> normasAlimentares;
	@Temporal(TemporalType.DATE)
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
