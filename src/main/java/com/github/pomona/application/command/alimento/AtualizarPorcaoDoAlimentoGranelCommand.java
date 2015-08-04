package com.github.pomona.application.command.alimento;

public class AtualizarPorcaoDoAlimentoGranelCommand {
	private String idAlimentoGranel;
	private float porcao;
	
	public AtualizarPorcaoDoAlimentoGranelCommand(String idAlimentoGranel, float porcao) {
		super();
		this.idAlimentoGranel = idAlimentoGranel;
		this.porcao = porcao;
	}
	
	public String getIdAlimentoGranel() {
		return idAlimentoGranel;
	}
	
	public float getPorcao() {
		return porcao;
	}
	
}
