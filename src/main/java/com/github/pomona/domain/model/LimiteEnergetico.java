package com.github.pomona.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;
import com.github.pomona.domain.reference.TipoRefeicao;

@Entity
public class LimiteEnergetico extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -2904227334042632218L;

	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private DivisaoRefeicao divisaoRefeicao;
	@NotNull
	@DecimalMin(value = "0.01")
	@Column(nullable = false, precision = 10, scale = 2)
	private float percentualEnergetico;
	@NotNull
	@DecimalMin(value = "0.01")
	@Column(nullable = false, precision = 10, scale = 2)
	private float tolerancia;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataCadastro;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 8)
	private TipoRefeicao tipoRefeicao;

	public float getPercentualEnergetico() {
		return percentualEnergetico;
	}

	public void setPercentualEnergetico(float percentualEnergetico) {
		this.percentualEnergetico = percentualEnergetico;
	}

	public float getTolerancia() {
		return tolerancia;
	}

	public void setTolerancia(float tolerancia) {
		this.tolerancia = tolerancia;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}

	public DivisaoRefeicao getDivisaoRefeicao() {
		return divisaoRefeicao;
	}

	public void setDivisaoRefeicao(DivisaoRefeicao divisaoRefeicao) {
		this.divisaoRefeicao = divisaoRefeicao;
	}

	@Override
	public String toString() {
		return "LimiteEnergetico [percentualEnergetico=" + percentualEnergetico + ", tolerancia=" + tolerancia
				+ ", dataCadastro=" + dataCadastro + ", tipoRefeicao=" + tipoRefeicao + "]";
	}

}
