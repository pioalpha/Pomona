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

import com.github.common.domain.model.ConcurrencySafeEntity;
import com.github.pomona.domain.reference.TipoNorma;

@Entity
public class NormaAlimentar extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 5353779158237702326L;

	@ManyToOne
	@JoinColumn(nullable = false)
	private DiretrizAlimentar diretrizAlimentar;
	@Column(precision = 10, scale = 2)
	private Float normaMinima;
	@Column(precision = 10, scale = 2)
	private Float normaMaxima;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataCriacao;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private TipoNorma tipoNorma;
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
