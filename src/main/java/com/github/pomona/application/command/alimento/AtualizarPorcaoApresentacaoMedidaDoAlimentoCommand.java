package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;

public class AtualizarPorcaoApresentacaoMedidaDoAlimentoCommand implements Command {
	private String apresentacaoMedidaId;
	private float porcao;
	
	public AtualizarPorcaoApresentacaoMedidaDoAlimentoCommand(String apresentacaoMedidaId, float porcao) {
		super();
		this.apresentacaoMedidaId = apresentacaoMedidaId;
		this.porcao = porcao;
	}
	
	public String getApresentacaoMedidaId() {
		return apresentacaoMedidaId;
	}
	
	public float getPorcao() {
		return porcao;
	}
	
}
