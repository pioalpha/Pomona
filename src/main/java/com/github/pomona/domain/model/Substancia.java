package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.github.common.domain.model.ConcurrencySafeEntity;
import com.github.pomona.domain.reference.UnidadeSubstancia;

@Entity
public class Substancia extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -1063366783131768256L;
	
	@Embedded
	private SubstanciaId substanciaId;
	@Size(min = 3, max = 100)
	@NotBlank
	@Column(nullable = false, length = 100, unique = true)
	private String nome;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 3)
	private UnidadeSubstancia unidadeSubstancia;
	@NotNull
	@Column(nullable = false)
	private int ordem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}

	public void setUnidadeSubstancia(UnidadeSubstancia unidadeSubstancia) {
		this.unidadeSubstancia = unidadeSubstancia;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public String getDetalhe() {
		return nome + " (" + unidadeSubstancia + ")";
	}

	public SubstanciaId substanciaId() {
		return substanciaId;
	}

	public void setSubstanciaId(SubstanciaId substanciaId) {
		this.substanciaId = substanciaId;
	}

	@Override
	public String toString() {
		return "Substancia [nome=" + nome + ", unidadeSubstancia=" + unidadeSubstancia + ", ordem=" + ordem + "]";
	}

}
