package com.github.pomona.application.command.divisaoRefeicao;

public class ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand {
	private String idLimiteEnergetico;

	public ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand(String idLimiteEnergetico) {
		super();
		this.idLimiteEnergetico = idLimiteEnergetico;
	}

	public String getIdLimiteEnergetico() {
		return idLimiteEnergetico;
	}
	
}
