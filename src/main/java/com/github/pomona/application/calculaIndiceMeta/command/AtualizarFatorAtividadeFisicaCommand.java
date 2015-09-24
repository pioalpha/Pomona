package com.github.pomona.application.calculaIndiceMeta.command;

import com.github.common.application.command.Command;

public class AtualizarFatorAtividadeFisicaCommand implements Command {
	private String fatorAtividadeFisicaId;
	private String atividade;
	private float fator;

	public AtualizarFatorAtividadeFisicaCommand(String fatorAtividadeFisicaId, String atividade, float fator) {
		super();
		this.fatorAtividadeFisicaId = fatorAtividadeFisicaId;
		this.atividade = atividade;
		this.fator = fator;
	}

	public String getFatorAtividadeFisicaId() {
		return fatorAtividadeFisicaId;
	}

	public String getAtividade() {
		return atividade;
	}

	public float getFator() {
		return fator;
	}

}
