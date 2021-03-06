package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.ComponenteAlimentar;
import com.github.pomona.domain.model.EnergiaAlimento;
import com.github.pomona.domain.model.EnergiaSubstancia;

public class CalculaEnergiaAlimento {
	private static List<EnergiaAlimento> energiaAlimento = new ArrayList<EnergiaAlimento>();
	private static List<EnergiaSubstancia> energiaSubstancia = new ArrayList<EnergiaSubstancia>();
	
	public static List<EnergiaAlimento> getEnergiaAlimento() {
		return energiaAlimento;
	}
	public static void setEnergiaAlimento(List<EnergiaAlimento> energiaAlimento) {
		CalculaEnergiaAlimento.energiaAlimento = energiaAlimento;
	}
	public static List<EnergiaSubstancia> getEnergiaSubstancia() {
		return energiaSubstancia;
	}
	public static void setEnergiaSubstancia(List<EnergiaSubstancia> energiaSubstancia) {
		CalculaEnergiaAlimento.energiaSubstancia = energiaSubstancia;
	}
	
	// Se a energia cadastrada mais recente for manual, retorna ela sem fazer cálculo
	// Senão calcula a energia baseada nas substâncias componentes do alimento E
	// Retorna o último cadastro idêntico e se não acha, cadastra um novo
	// Itens já adicionados no cardápio não tem esse problema devido a associação direta
	// Precisa haver uma forma de ativar/desativar o último cadastro manual
	public static EnergiaAlimento retornaEnergiaAlimento(AlimentoUnitario alimento){
		EnergiaAlimento resultado = null;
		
		if (CalculaEnergiaAlimento.energiaAlimento != null){
			for (EnergiaAlimento energiaAlimento : CalculaEnergiaAlimento.energiaAlimento){
				if (energiaAlimento.getAlimento().equals(alimento)){
					resultado = energiaAlimento;
					break;
				}
			}
		}
		if (resultado == null){
			// Cadastra energia alimento
			resultado = CalculaEnergiaAlimento.adicionarEnergiaAlimento(alimento);
		}
		
		return resultado;
	}
	
	public static EnergiaAlimento adicionarEnergiaAlimento(AlimentoUnitario alimento){
		EnergiaAlimento energiaAlimento = new EnergiaAlimento();
		energiaAlimento.setAlimento(alimento);
		// isolar cada energia substância e multiplicar pelo fator do alimento
		float energia = 0;
		for (EnergiaSubstancia energiaSubstancia : CalculaEnergiaAlimento.energiaSubstancia){
			for (ComponenteAlimentar componenteAlimentar : alimento.getComposicaoAlimentar()){
				if (energiaSubstancia.getSubstancia().equals(componenteAlimentar.getSubstancia())){
					energia += componenteAlimentar.getQuantidade() * energiaSubstancia.getFatorEnergetico();
				}
			}
		}
		energiaAlimento.setEnergia(energia);
		energiaAlimento.setAutomatico(true);
		energiaAlimento.setDataCadastro(new Date());
		
		if (CalculaEnergiaAlimento.energiaAlimento == null){
			CalculaEnergiaAlimento.energiaAlimento = new ArrayList<EnergiaAlimento>();
		}
		
		CalculaEnergiaAlimento.energiaAlimento.add(energiaAlimento);
		
		return energiaAlimento;
	}
	
}
