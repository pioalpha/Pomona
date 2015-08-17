package com.github.pomona.domain.model;

import com.github.pomona.domain.reference.TipoCircunferencia;

public class CircunferenciaCorporal {
	private TipoCircunferencia tipoCircunferencia;
	private float valor;

	public TipoCircunferencia getTipoCircunferencia() {
		return tipoCircunferencia;
	}

	public void setTipoCircunferencia(TipoCircunferencia tipoCircunferencia) {
		this.tipoCircunferencia = tipoCircunferencia;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
