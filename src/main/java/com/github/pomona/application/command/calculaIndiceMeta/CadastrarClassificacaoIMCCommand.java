package com.github.pomona.application.command.calculaIndiceMeta;

import com.github.common.service.command.Command;

public class CadastrarClassificacaoIMCCommand implements Command {
	private String situacao;
	private Float imcMinimo;
	private Float imcMaximo;
	
	public CadastrarClassificacaoIMCCommand(String situacao, Float imcMinimo, Float imcMaximo) {
		super();
		this.situacao = situacao;
		this.imcMinimo = imcMinimo;
		this.imcMaximo = imcMaximo;
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
