package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.UnidadeGranel;

public class AtualizarUnidadeDoAlimentoGranelCommand  implements Command{
	private String alimentoGranelId;
	private UnidadeGranel unidadeGranel;
	
	public AtualizarUnidadeDoAlimentoGranelCommand(String alimentoGranelId, UnidadeGranel unidadeGranel) {
		super();
		this.alimentoGranelId = alimentoGranelId;
		this.unidadeGranel = unidadeGranel;
	}
	
	public String getAlimentoGranelId() {
		return alimentoGranelId;
	}
	
	public UnidadeGranel getUnidadeGranel() {
		return unidadeGranel;
	}
	
}
