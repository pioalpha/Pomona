package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;

import com.github.pomona.domain.reference.TipoRefeicao;

public class LimiteEnergetico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2904227334042632218L;
	private float percentualEnergetico;
	private float tolerancia;
	private Date dataCadastro;
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

	@Override
	public String toString() {
		return "LimiteEnergetico [percentualEnergetico=" + percentualEnergetico + ", tolerancia=" + tolerancia
				+ ", dataCadastro=" + dataCadastro + ", tipoRefeicao=" + tipoRefeicao + "]";
	}

}
