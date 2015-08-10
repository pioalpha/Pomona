package com.github.pomona.domain.model;

import java.io.Serializable;

import com.github.pomona.domain.reference.UnidadeSubstancia;

public class Substancia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1063366783131768256L;
	private SubstanciaId substanciaId;
	private String nome;
	private UnidadeSubstancia unidadeSubstancia;
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
