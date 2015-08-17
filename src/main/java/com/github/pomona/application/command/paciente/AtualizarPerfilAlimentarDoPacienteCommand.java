package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.PreferenciaConsumo;

public class AtualizarPerfilAlimentarDoPacienteCommand implements Command {

	private String perfilAlimentarPacienteId;
	private PreferenciaConsumo preferenciaConsumo;

	public AtualizarPerfilAlimentarDoPacienteCommand(String perfilAlimentarPacienteId, PreferenciaConsumo preferenciaConsumo) {
		super();
		this.perfilAlimentarPacienteId = perfilAlimentarPacienteId;
		this.preferenciaConsumo = preferenciaConsumo;
	}

	public String getPerfilAlimentarId() {
		return perfilAlimentarPacienteId;
	}
	public PreferenciaConsumo getPreferenciaConsumo() {
		return preferenciaConsumo;
	}
}
