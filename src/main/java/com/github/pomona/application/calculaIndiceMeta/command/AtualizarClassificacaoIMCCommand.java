package com.github.pomona.application.calculaIndiceMeta.command;

import com.github.common.application.command.Command;

public class AtualizarClassificacaoIMCCommand implements Command {
	private String classificacaoIMCId;
	private String situacao;
	private Float imcMinimo;
	private Float imcMaximo;

	public AtualizarClassificacaoIMCCommand(String classificacaoIMCId, String situacao, Float imcMinimo,
			Float imcMaximo) {
		super();
		this.classificacaoIMCId = classificacaoIMCId;
		this.situacao = situacao;
		this.imcMinimo = imcMinimo;
		this.imcMaximo = imcMaximo;
	}

	public String getClassificacaoIMCId() {
		return classificacaoIMCId;
	}

	public String getSituacao() {
		return situacao;
	}

	public Float getImcMinimo() {
		return imcMinimo;
	}

	public Float getImcMaximo() {
		return imcMaximo;
	}

}
