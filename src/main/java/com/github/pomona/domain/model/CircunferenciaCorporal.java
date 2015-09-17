package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;
import com.github.pomona.domain.reference.TipoCircunferencia;

@Entity
public class CircunferenciaCorporal extends ConcurrencySafeEntity{
	
	private static final long serialVersionUID = -7600515331158246086L;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private TipoCircunferencia tipoCircunferencia;
	@DecimalMin(value = "0.01")
	@NotNull
	@Column(nullable = false, precision = 10, scale = 2)
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
