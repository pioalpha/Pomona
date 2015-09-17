package com.github.pomona.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.github.pomona.domain.reference.UnidadeGranel;

@Entity
public class AlimentoGranel extends AlimentoUnitario implements Serializable {

	private static final long serialVersionUID = -8186382855534022253L;

	@DecimalMin(value = "0.01")
	@Column(nullable = false, precision = 10, scale = 2)
	private float porcao;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 3)
	private UnidadeGranel unidadeGranel;

	public AlimentoGranel() {
		super();
	}

	public float getPorcao() {
		return this.porcao;
	}

	public void setPorcao(float porcao) {
		this.porcao = porcao;
	}

	public UnidadeGranel getUnidadeGranel() {
		return unidadeGranel;
	}

	public void setUnidadeGranel(UnidadeGranel unidadeGranel) {
		this.unidadeGranel = unidadeGranel;
	}

	@Override
	public float fatorProporcao(float qtd) {
		return porcao / qtd;
	}

	@Override
	public String getDetalhe() {
		return this.getNome() + " (" + this.unidadeGranel + ")";
	}

	@Override
	public String toString() {
		return "AlimentoGranel [porcao=" + porcao + ", unidadeGranel=" + unidadeGranel + ", composicaoAlimentar="
				+ composicaoAlimentar + ", categoriaAlimento=" + categoriaAlimento + "]";
	}

}
