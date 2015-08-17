package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DivisaoRefeicao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7166712452461975870L;
	private DivisaoRefeicaoId divisaoRefeicaoId;
	private String nome;
	private List<LimiteEnergetico> limitesEnergeticos;

	public DivisaoRefeicao() {
		super();
		
		this.limitesEnergeticos = new ArrayList<LimiteEnergetico>();
	}

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

	public DivisaoRefeicaoId divisaoRefeicaoId() {
		return divisaoRefeicaoId;
	}

	public void setDivisaoRefeicaoId(DivisaoRefeicaoId divisaoRefeicaoId) {
		this.divisaoRefeicaoId = divisaoRefeicaoId;
	}

	@Override
	public String toString() {
		return "DivisaoRefeicao [divisaoRefeicaoId=" + divisaoRefeicaoId + ", nome=" + nome + ", limitesEnergeticos="
				+ limitesEnergeticos + "]";
	}
	
}
