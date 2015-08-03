package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.ComponenteAlimentar;
import com.github.pomona.domain.model.EnergiaAlimento;
import com.github.pomona.domain.model.EnergiaSubstancia;

public class CalculaEnergiaAlimento {
	private List<EnergiaAlimento> energiaAlimento;
	private List<EnergiaSubstancia> energiaSubstancia;
	
	public List<EnergiaAlimento> getEnergiaAlimento() {
		return energiaAlimento;
	}
	public void setEnergiaAlimento(List<EnergiaAlimento> energiaAlimento) {
		this.energiaAlimento = energiaAlimento;
	}
	public List<EnergiaSubstancia> getEnergiaSubstancia() {
		return energiaSubstancia;
	}
	public void setEnergiaSubstancia(List<EnergiaSubstancia> energiaSubstancia) {
		this.energiaSubstancia = energiaSubstancia;
	}
	
	// Se a energia cadastrada mais recente for manual, retorna ela sem fazer cálculo
	// Senão calcula a energia baseada nas substâncias componentes do alimento E
	// Retorna o último cadastro idêntico e se não acha, cadastra um novo
	// Itens já adicionados no cardápio não tem esse problema devido a associação direta
	// Precisa haver uma forma de ativar/desativar o último cadastro manual
	public EnergiaAlimento retornaEnergiaAlimento(AlimentoUnitario alimento){
		EnergiaAlimento resultado = null;
		
		if (this.energiaAlimento != null){
			for (EnergiaAlimento energiaAlimento : this.energiaAlimento){
				if (energiaAlimento.getAlimento().equals(alimento)){
					resultado = energiaAlimento;
					break;
				}
			}
		}
		if (resultado == null){
			// Cadastra energia alimento
			resultado = this.adicionarEnergiaAlimento(alimento);
		}
		
		return resultado;
	}
	
	public EnergiaAlimento adicionarEnergiaAlimento(AlimentoUnitario alimento){
		EnergiaAlimento energiaAlimento = new EnergiaAlimento();
		energiaAlimento.setAlimento(alimento);
		// isolar cada energia substância e multiplicar pelo fator do alimento
		float energia = 0;
		for (EnergiaSubstancia energiaSubstancia : energiaSubstancia){
			for (ComponenteAlimentar componenteAlimentar : alimento.getComposicaoAlimentar()){
				if (energiaSubstancia.getSubstancia().equals(componenteAlimentar.getSubstancia())){
					energia += componenteAlimentar.getQuantidade() * energiaSubstancia.getFatorEnergetico();
				}
			}
		}
		energiaAlimento.setEnergia(energia);
		energiaAlimento.setAutomatico(true);
		energiaAlimento.setDataCadastro(new Date());
		
		if (this.energiaAlimento == null){
			this.energiaAlimento = new ArrayList<EnergiaAlimento>();
		}
		
		this.energiaAlimento.add(energiaAlimento);
		
		return energiaAlimento;
	}
	
}
