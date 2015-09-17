package com.github.pomona.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;
import com.github.pomona.domain.reference.TipoNorma;

@Entity
public class NormaAlimentar extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 5353779158237702326L;

	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private DiretrizAlimentar diretrizAlimentar;
	@DecimalMin(value = "0.01")
	@Column(precision = 10, scale = 2)
	private Float normaMinima;
	@DecimalMin(value = "0.01")
	@Column(precision = 10, scale = 2)
	private Float normaMaxima;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataCriacao;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private TipoNorma tipoNorma;
	@NotNull
	@OneToOne
	@JoinColumn(nullable = false)
	private Substancia substancia;

	public Float getNormaMinima() {
		return normaMinima;
	}

	public void setNormaMinima(Float normaMinima) {
		this.normaMinima = normaMinima;
	}

	public Float getNormaMaxima() {
		return normaMaxima;
	}

	public void setNormaMaxima(Float normaMaxima) {
		this.normaMaxima = normaMaxima;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public TipoNorma getTipoNorma() {
		return tipoNorma;
	}

	public void setTipoNorma(TipoNorma tipoNorma) {
		this.tipoNorma = tipoNorma;
	}

	public Substancia getSubstancia() {
		return substancia;
	}

	public void setSubstancia(Substancia substancia) {
		this.substancia = substancia;
	}

	public DiretrizAlimentar getDiretrizAlimentar() {
		return diretrizAlimentar;
	}

	public void setDiretrizAlimentar(DiretrizAlimentar diretrizAlimentar) {
		this.diretrizAlimentar = diretrizAlimentar;
	}

	@Override
	public String toString() {
		return "NormaAlimentar [normaMinima=" + normaMinima + ", normaMaxima=" + normaMaxima + ", dataCriacao=" + dataCriacao
				+ ", tipoNorma=" + tipoNorma + ", substancia=" + substancia + "]";
	}

}
