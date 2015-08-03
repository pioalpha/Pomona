package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;

import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.LimiteEnergetico;
import com.github.pomona.domain.model.TipoRefeicao;

public class DivisaoRefeicaoBuilder {
	private DivisaoRefeicao instancia;
	
	public DivisaoRefeicaoBuilder(String nome){
		this.instancia = new DivisaoRefeicao();
		this.instancia.setNome(nome);
	}
	
	public DivisaoRefeicaoBuilder adicionarLimiteEnergetico(TipoRefeicao tipoRefeicao,
			float percentualEnergetico,	float tolerancia){
		LimiteEnergetico limiteEnergetico = new LimiteEnergetico();
		limiteEnergetico.setTipoRefeicao(tipoRefeicao);
		limiteEnergetico.setPercentualEnergetico(percentualEnergetico);
		limiteEnergetico.setTolerancia(tolerancia);
		limiteEnergetico.setDataCadastro(new Date());
		
		if (this.instancia.getLimitesEnergeticos() == null){
			this.instancia.setLimitesEnergeticos(new ArrayList<LimiteEnergetico>());
		}
		
		this.instancia.getLimitesEnergeticos().add(limiteEnergetico);
		
		return this;
	}
	
	public DivisaoRefeicao construir(){
		// Precisa somar o total de 100%
		return this.instancia;
	}
}
