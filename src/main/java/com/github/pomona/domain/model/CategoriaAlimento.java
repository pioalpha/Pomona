package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class CategoriaAlimento extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 8813916095127014131L;

	@Embedded
	private CategoriaAlimentoId categoriaAlimentoId;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(precision = 10, scale = 2)
	private Float caloriasPorPorcao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getCaloriasPorPorcao() {
		return caloriasPorPorcao;
	}

	public void setCaloriasPorPorcao(Float caloriasPorPorcao) {
		this.caloriasPorPorcao = caloriasPorPorcao;
	}

	public CategoriaAlimentoId categoriaAlimentoId() {
		return categoriaAlimentoId;
	}

	public void setCategoriaAlimentoId(CategoriaAlimentoId categoriaAlimentoId) {
		this.categoriaAlimentoId = categoriaAlimentoId;
	}

	@Override
	public String toString() {
		return "CategoriaAlimento [categoriaAlimentoId=" + categoriaAlimentoId + ", nome=" + nome + "]";
	}
	
}
