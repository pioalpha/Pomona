package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;
import com.github.pomona.domain.model.TipoPreparo;

public class CadastrarPreparoMedidaDoAlimentoGranelCommand implements Command {
	public String idAlimentoGranel;
	public String idTipoPreparo;
	public String idTipoMedida;
	public float quantidade;
	
	public CadastrarPreparoMedidaDoAlimentoGranelCommand(String idAlimentoGranel, String idTipoPreparo,
			String idTipoMedida, float quantidade) {
		super();
		this.idAlimentoGranel = idAlimentoGranel;
		this.idTipoPreparo = idTipoPreparo;
		this.idTipoMedida = idTipoMedida;
		this.quantidade = quantidade;
	}
	
	public String getIdAlimentoGranel() {
		return idAlimentoGranel;
	}
	
	public String getIdTipoPreparo() {
		return idTipoPreparo;
	}
	
	public String getIdTipoMedida() {
		return idTipoMedida;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
