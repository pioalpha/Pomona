package com.github.pomona.application.dto;

import java.util.Collection;

import com.github.common.service.dto.DTO;

public class AlimentoDTO implements DTO {
	private String nome;
	private String unidade;
	private Float porcao;
	private Float energiaAlimento;
	private String categoria;
	private Collection<String> substancia;
	private Collection<Float> qtdSubstancia;

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

	public Collection<String> getSubstancia() {
		return substancia;
	}

	public void setSubstancia(Collection<String> substancia) {
		this.substancia = substancia;
	}

	public Collection<Float> getQtdSubstancia() {
		return qtdSubstancia;
	}

	public void setQtdSubstancia(Collection<Float> qtdSubstancia) {
		this.qtdSubstancia = qtdSubstancia;
	}

}
