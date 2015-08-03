package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.List;

public class DivisaoRefeicao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7166712452461975870L;
	private String nome;
	private List<LimiteEnergetico> limitesEnergeticos;

	public List<LimiteEnergetico> getLimitesEnergeticos() {
		return limitesEnergeticos;
	}

	public void setLimitesEnergeticos(List<LimiteEnergetico> limitesEnergeticos) {
		this.limitesEnergeticos = limitesEnergeticos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
