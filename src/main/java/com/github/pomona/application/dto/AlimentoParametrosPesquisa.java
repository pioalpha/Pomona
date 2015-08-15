package com.github.pomona.application.dto;

import com.github.common.service.query.ParametrosPesquisa;

public class AlimentoParametrosPesquisa extends ParametrosPesquisa {
	private String nome;
	private String unidade;
	private Float porcao;
	private Float energiaAlimento;
	private String categoria;
	
	// Criterios de pesquisa?
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Float getPorcao() {
		return porcao;
	}

	public void setPorcao(Float porcao) {
		this.porcao = porcao;
	}

	public Float getEnergiaAlimento() {
		return energiaAlimento;
	}

	public void setEnergiaAlimento(Float energiaAlimento) {
		this.energiaAlimento = energiaAlimento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
