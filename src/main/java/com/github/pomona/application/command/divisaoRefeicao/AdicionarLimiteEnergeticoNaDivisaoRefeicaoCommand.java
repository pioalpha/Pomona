package com.github.pomona.application.command.divisaoRefeicao;

import com.github.pomona.domain.reference.TipoRefeicao;

public class AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand {
	private String idDivisaoRefeicao;
	private TipoRefeicao tipoRefeicao;
	private float percentualEnergetico;
	private float tolerancia;
	
	public AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(String idDivisaoRefeicao, TipoRefeicao tipoRefeicao,
			float percentualEnergetico, float tolerancia) {
		super();
		this.idDivisaoRefeicao = idDivisaoRefeicao;
		this.tipoRefeicao = tipoRefeicao;
		this.percentualEnergetico = percentualEnergetico;
		this.tolerancia = tolerancia;
	}
	
	public String getIdDivisaoRefeicao() {
		return idDivisaoRefeicao;
	}
	
	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}
	
	public float getPercentualEnergetico() {
		return percentualEnergetico;
	}
	
	public float getTolerancia() {
		return tolerancia;
	}
	
}
