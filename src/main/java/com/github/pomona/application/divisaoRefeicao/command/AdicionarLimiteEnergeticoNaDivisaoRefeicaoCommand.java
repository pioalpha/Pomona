package com.github.pomona.application.divisaoRefeicao.command;

import com.github.common.application.command.Command;
import com.github.pomona.domain.reference.TipoRefeicao;

public class AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand implements Command {
	private String divisaoRefeicaoId;
	private TipoRefeicao tipoRefeicao;
	private float percentualEnergetico;
	private float tolerancia;
	
	public AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand(String divisaoRefeicaoId, TipoRefeicao tipoRefeicao,
			float percentualEnergetico, float tolerancia) {
		super();
		this.divisaoRefeicaoId = divisaoRefeicaoId;
		this.tipoRefeicao = tipoRefeicao;
		this.percentualEnergetico = percentualEnergetico;
		this.tolerancia = tolerancia;
	}
	
	public String getDivisaoRefeicaoId() {
		return divisaoRefeicaoId;
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
