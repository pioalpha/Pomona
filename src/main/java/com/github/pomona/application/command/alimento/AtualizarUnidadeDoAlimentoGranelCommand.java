package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.UnidadeGranel;

public class AtualizarUnidadeDoAlimentoGranelCommand  implements Command{
	private String idAlimentoGranel;
	private UnidadeGranel unidadeGranel;
	
	public AtualizarUnidadeDoAlimentoGranelCommand(String idAlimentoGranel, UnidadeGranel unidadeGranel) {
		super();
		this.idAlimentoGranel = idAlimentoGranel;
		this.unidadeGranel = unidadeGranel;
	}
	
	public String getIdAlimentoGranel() {
		return idAlimentoGranel;
	}
	
	public UnidadeGranel getUnidadeGranel() {
		return unidadeGranel;
	}
	
}
