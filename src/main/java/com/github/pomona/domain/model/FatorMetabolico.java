package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;

public class FatorMetabolico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -528597959816250678L;
	private FatorMetabolicoId fatorMetabolicoId;
	private Integer idadeMinima;
	private Integer idadeMaxima;
	private float fatorMasculino;
	private int diferencialMasculino;
	private float fatorFeminino;
	private int diferencialFeminino;
	private Date dataCriacao;

	public Integer getIdadeMinima() {
		return idadeMinima;
	}

	public void setIdadeMinima(Integer idadeMinima) {
		this.idadeMinima = idadeMinima;
	}

	public Integer getIdadeMaxima() {
		return idadeMaxima;
	}

	public void setIdadeMaxima(Integer idadeMaxima) {
		this.idadeMaxima = idadeMaxima;
	}

	public float getFatorMasculino() {
		return fatorMasculino;
	}

	public void setFatorMasculino(float fatorMasculino) {
		this.fatorMasculino = fatorMasculino;
	}

	public int getDiferencialMasculino() {
		return diferencialMasculino;
	}

	public void setDiferencialMasculino(int diferencialMasculino) {
		this.diferencialMasculino = diferencialMasculino;
	}

	public float getFatorFeminino() {
		return fatorFeminino;
	}

	public void setFatorFeminino(float fatorFeminino) {
		this.fatorFeminino = fatorFeminino;
	}

	public int getDiferencialFeminino() {
		return diferencialFeminino;
	}

	public void setDiferencialFeminino(int diferencialFeminino) {
		this.diferencialFeminino = diferencialFeminino;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public FatorMetabolicoId fatorMetabolicoId() {
		return fatorMetabolicoId;
	}

	public void setFatorMetabolicoId(FatorMetabolicoId fatorMetabolicoId) {
		this.fatorMetabolicoId = fatorMetabolicoId;
	}

	@Override
	public String toString() {
		return "FatorMetabolico [fatorMetabolicoId=" + fatorMetabolicoId + ", idadeMinima=" + idadeMinima
				+ ", idadeMaxima=" + idadeMaxima + ", fatorMasculino=" + fatorMasculino + ", diferencialMasculino="
				+ diferencialMasculino + ", fatorFeminino=" + fatorFeminino + ", diferencialFeminino="
				+ diferencialFeminino + ", dataCriacao=" + dataCriacao + "]";
	}
	
}
