package com.github.pomona.domain.model;

import java.io.Serializable;

import com.github.pomona.domain.reference.UnidadeGranel;

public class AlimentoGranel extends AlimentoUnitario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8186382855534022253L;
	private float porcao;
	private UnidadeGranel unidadeGranel;

	public AlimentoGranel() {
		super();
	}

	public float getPorcao() {
		return this.porcao;
	}
	public void setPorcao(float porcao) {
		this.porcao = porcao;
	}
	public UnidadeGranel getUnidadeGranel() {
		return unidadeGranel;
	}
	public void setUnidadeGranel(UnidadeGranel unidadeGranel) {
		this.unidadeGranel = unidadeGranel;
	}
	@Override
	public float fatorProporcao(float qtd){
		return porcao / qtd;
	}

	@Override
	public String getDetalhe() {
		return this.getNome() + " (" + this.unidadeGranel + ")";
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getNome() + " (" + this.unidadeGranel + ")");
		for (ComponenteAlimentar ca : this.composicaoAlimentar){
			sb.append(ca.toString());
		}
		
		return sb.toString();
		//return this.getNome() + " (" + this.unidadeGranel + ")";
	}
}
