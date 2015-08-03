package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;

import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.NormaAlimentar;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.model.TipoNorma;

public class DiretrizAlimentarBuilder {
	private DiretrizAlimentar instancia;
	
	public DiretrizAlimentarBuilder(String nome){
		this.instancia = new DiretrizAlimentar();
		this.instancia.setNome(nome);
		this.instancia.setDataRevogacao(null);
	}
	
	public DiretrizAlimentarBuilder adicionarNormaAlimentar(Substancia substancia,
			TipoNorma tipoNorma, float normaMinima,	float normaMaxima){
		NormaAlimentar normaAlimentar = new NormaAlimentar();
		normaAlimentar.setData(new Date());
		normaAlimentar.setSubstancia(substancia);
		normaAlimentar.setTipoNorma(tipoNorma);
		normaAlimentar.setNormaMinima(normaMinima);
		normaAlimentar.setNormaMaxima(normaMaxima);
		
		if (this.instancia.getNormasAlimentares() == null){
			this.instancia.setNormasAlimentares(new ArrayList<NormaAlimentar>());
		}
		
		this.instancia.getNormasAlimentares().add(normaAlimentar);
		
		return this;
	}
	
	public DiretrizAlimentar construir(){
		// A soma dos percentuais máximos precisa ser superior a 100%
		return this.instancia;
	}
}
