package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.github.common.domain.model.ConcurrencySafeEntity;

public class AlimentoUnitario extends ConcurrencySafeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3596504330554150407L;
	private AlimentoId alimentoId;
	private String nome;
	protected List<ComponenteAlimentar> composicaoAlimentar;
	
	public AlimentoUnitario() {
		super();
		this.composicaoAlimentar = new ArrayList<ComponenteAlimentar>();
	}
	
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
		StringBuilder sb = new StringBuilder();
		sb.append(this.getNome());
		for (ComponenteAlimentar ca : this.composicaoAlimentar){
			sb.append(ca.toString());
		}
		
		return sb.toString();
		//return this.getNome();
	}
	public String getDetalhe() {
		return this.getNome();
	}

	public AlimentoId alimentoId() {
		return alimentoId;
	}

	public void setAlimentoId(AlimentoId umAlimentoId) {
        this.assertArgumentNotNull(umAlimentoId, "The alimentoId must be provided.");

        this.alimentoId = umAlimentoId;
	}
}
