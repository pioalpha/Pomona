package com.github.pomona.domain.model;

import com.github.pomona.domain.reference.TipoDobra;

public class DobraCutanea {
	private TipoDobra tipoDobra;
	private float valor;

	public TipoDobra getTipoDobra() {
		return tipoDobra;
	}

	public void setTipoDobra(TipoDobra tipoDobra) {
		this.tipoDobra = tipoDobra;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
