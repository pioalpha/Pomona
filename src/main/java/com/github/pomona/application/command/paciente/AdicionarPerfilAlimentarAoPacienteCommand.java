package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.PreferenciaConsumo;

public class AdicionarPerfilAlimentarAoPacienteCommand implements Command {

	private String planoAlimentarId;
	private String alimentoId;
	private PreferenciaConsumo preferenciaConsumo;
	
	public AdicionarPerfilAlimentarAoPacienteCommand(String planoAlimentarId, String alimentoId,
			PreferenciaConsumo preferenciaConsumo) {
		super();
		this.planoAlimentarId = planoAlimentarId;
		this.alimentoId = alimentoId;
		this.preferenciaConsumo = preferenciaConsumo;
	}
	
	public String getPlanoAlimentarId() {
		return planoAlimentarId;
	}

	public String getAlimentoId() {
		return alimentoId;
	}

	public PreferenciaConsumo getPreferenciaConsumo() {
		return preferenciaConsumo;
	}

}
