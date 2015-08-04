package com.github.pomona.application.command.alimento;

import com.github.pomona.domain.reference.UnidadeGranel;

public class CadastrarAlimentoGranelCommand {
	private String nome;
	private UnidadeGranel unidadeGranel;
	private float porcao;
	
	public CadastrarAlimentoGranelCommand(String nome, UnidadeGranel unidadeGranel, float porcao) {
		super();
		this.nome = nome;
		this.unidadeGranel = unidadeGranel;
		this.porcao = porcao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public UnidadeGranel getUnidadeGranel() {
		return unidadeGranel;
	}
	
	public float getPorcao() {
		return porcao;
	}
	
}
