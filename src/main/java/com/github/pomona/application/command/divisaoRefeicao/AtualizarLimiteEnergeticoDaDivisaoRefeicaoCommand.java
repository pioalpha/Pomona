package com.github.pomona.application.command.divisaoRefeicao;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoRefeicao;

public class AtualizarLimiteEnergeticoDaDivisaoRefeicaoCommand implements Command {
	private String idLimiteEnergetico;
	private TipoRefeicao tipoRefeicao;
	private float percentualEnergetico;
	private float tolerancia;
	
	public AtualizarLimiteEnergeticoDaDivisaoRefeicaoCommand(String idLimiteEnergetico, TipoRefeicao tipoRefeicao,
			float percentualEnergetico, float tolerancia) {
		super();
		this.idLimiteEnergetico = idLimiteEnergetico;
		this.tipoRefeicao = tipoRefeicao;
		this.percentualEnergetico = percentualEnergetico;
		this.tolerancia = tolerancia;
	}
	
	public String getIdLimiteEnergetico() {
		return idLimiteEnergetico;
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
