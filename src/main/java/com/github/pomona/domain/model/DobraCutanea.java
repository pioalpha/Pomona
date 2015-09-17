package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;
import com.github.pomona.domain.reference.TipoDobra;

@Entity
public class DobraCutanea extends ConcurrencySafeEntity  {

	private static final long serialVersionUID = 3982082146689862537L;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private TipoDobra tipoDobra;
	@DecimalMin(value = "0.01")
	@NotNull
	@Column(nullable = false, precision = 10, scale = 2)
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
