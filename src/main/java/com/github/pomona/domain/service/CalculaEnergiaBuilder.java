package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;

import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.EnergiaAlimento;
import com.github.pomona.domain.model.EnergiaSubstancia;
import com.github.pomona.domain.model.Substancia;

public class CalculaEnergiaBuilder {
	private CalculaEnergiaAlimento instancia;

	public CalculaEnergiaBuilder(){
		this.instancia = new CalculaEnergiaAlimento();
	}

	public CalculaEnergiaBuilder adicionarEnergiaSubstancia(Substancia substancia
			, float fatorEnergetico){
		EnergiaSubstancia energiaSubstancia = new EnergiaSubstancia();
		energiaSubstancia.setSubstancia(substancia);
		energiaSubstancia.setFatorEnergetico(fatorEnergetico);
		energiaSubstancia.setDataCadastro(new Date());
		
		if (this.instancia.getEnergiaSubstancia() == null){
			this.instancia.setEnergiaSubstancia(new ArrayList<EnergiaSubstancia>());
		}
		
		this.instancia.getEnergiaSubstancia().add(energiaSubstancia);
		
		return this;
	}	
	
	public CalculaEnergiaBuilder adicionarEnergiaAlimento(AlimentoUnitario alimento, float energia){
		EnergiaAlimento energiaAlimento = new EnergiaAlimento();
		energiaAlimento.setAlimento(alimento);
		energiaAlimento.setEnergia(energia);
		energiaAlimento.setAutomatico(false);
		energiaAlimento.setDataCadastro(new Date());
		
		if (this.instancia.getEnergiaAlimento() == null){
			this.instancia.setEnergiaAlimento(new ArrayList<EnergiaAlimento>());
		}
		
		this.instancia.getEnergiaAlimento().add(energiaAlimento);
		
		return this;
	}	

	public CalculaEnergiaBuilder adicionarEnergiaAlimento(AlimentoUnitario alimento){
		this.instancia.adicionarEnergiaAlimento(alimento);
		
		return this;
	}
	
	public CalculaEnergiaAlimento construir(){
		return this.instancia;
	}
}
