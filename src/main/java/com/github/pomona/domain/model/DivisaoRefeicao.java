package com.github.pomona.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class DivisaoRefeicao extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 7166712452461975870L;

	@Embedded
	private DivisaoRefeicaoId divisaoRefeicaoId;
	@Size(min = 3, max = 100)
	@NotBlank
	@Column(nullable = false, length = 100, unique = true)
	private String nome;
	@OneToMany(mappedBy = "divisaoRefeicao", cascade = CascadeType.ALL)
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
