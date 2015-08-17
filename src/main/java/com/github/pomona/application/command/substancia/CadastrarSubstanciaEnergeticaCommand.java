package com.github.pomona.application.command.substancia;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class CadastrarSubstanciaEnergeticaCommand implements Command {
	private String substanciaId;
	private String nome;
	private UnidadeSubstancia unidadeSubstancia;
	private float fatorEnergetico;
	
	public CadastrarSubstanciaEnergeticaCommand(String substanciaId, String nome, UnidadeSubstancia unidadeSubstancia,
			float fatorEnergetico) {
		super();
		this.substanciaId = substanciaId;
		this.nome = nome;
		this.unidadeSubstancia = unidadeSubstancia;
		this.fatorEnergetico = fatorEnergetico;
	}
	
	public String getSubstanciaId() {
		return substanciaId;
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
