package com.github.pomona.domain.model;

public class CategoriaAlimento {
	private CategoriaAlimentoId categoriaAlimentoId;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
