package com.github.pomona.domain.service;

import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.model.UnidadeSubstancia;

public class SubstanciaBuilder {
	private Substancia instancia;
	
	public SubstanciaBuilder (String nome, UnidadeSubstancia unidadeSubstancia, int ordem){
		this.instancia = new Substancia();
		this.instancia.setNome(nome);
		this.instancia.setUnidadeSubstancia(unidadeSubstancia);
		this.instancia.setOrdem(ordem);
	}
	
	public Substancia construir(){
		return this.instancia;
	}

}
