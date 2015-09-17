package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class CadastrarSubstanciaEnergeticaCommand implements Command {
	private String nome;
	private UnidadeSubstancia unidadeSubstancia;
	private float fatorEnergetico;
	
	public CadastrarSubstanciaEnergeticaCommand(String nome, UnidadeSubstancia unidadeSubstancia,
			float fatorEnergetico) {
		super();
		
		this.nome = nome;
		this.unidadeSubstancia = unidadeSubstancia;
		this.fatorEnergetico = fatorEnergetico;
	}
	
	public String getNome() {
		return nome;
	}
	
	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}
	
	public float getFatorEnergetico() {
		return fatorEnergetico;
	}
	
}
