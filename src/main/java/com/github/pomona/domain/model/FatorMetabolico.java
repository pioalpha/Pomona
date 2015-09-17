package com.github.pomona.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class FatorMetabolico extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -528597959816250678L;

	@Embedded
	private FatorMetabolicoId fatorMetabolicoId;
	@Min(0)
	private Integer idadeMinima;
	@Min(0)
	private Integer idadeMaxima;
	@NotNull
	@DecimalMin(value = "0.01")
	@Column(nullable = false, precision = 10, scale = 2)
	private float fatorMasculino;
	@NotNull
	@Column(nullable = false)
	private int diferencialMasculino;
	@NotNull
	@DecimalMin(value = "0.01")
	@Column(nullable = false, precision = 10, scale = 2)
	private float fatorFeminino;
	@NotNull
	@Column(nullable = false)
	private int diferencialFeminino;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
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
