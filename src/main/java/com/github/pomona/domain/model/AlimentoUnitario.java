package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.List;

public class AlimentoUnitario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3596504330554150407L;
	private String nome;
	private List<ComponenteAlimentar> composicaoAlimentar;
	
	public List<ComponenteAlimentar> getComposicaoAlimentar() {
		return composicaoAlimentar;
	}
	public void setComposicaoAlimentar(List<ComponenteAlimentar> composicaoAlimentar) {
		this.composicaoAlimentar = composicaoAlimentar;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float fatorProporcao(float qtd){
		return qtd;
	}

	
	@Override
	public String toString() {
		return this.getNome();
	}
	public String getDetalhe() {
		return this.getNome();
	}
}
