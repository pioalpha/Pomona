package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.PreferenciaConsumo;

public class AtualizarPerfilAlimentarDoPacienteCommand implements Command {

	private String idPerfilAlimentarPaciente;
	private PreferenciaConsumo preferenciaConsumo;

	public AtualizarPerfilAlimentarDoPacienteCommand(String idPerfilAlimentarPaciente, PreferenciaConsumo preferenciaConsumo) {
		super();
		this.idPerfilAlimentarPaciente = idPerfilAlimentarPaciente;
		this.preferenciaConsumo = preferenciaConsumo;
	}

	public String getIdPerfilAlimentar() {
		return idPerfilAlimentarPaciente;
	}
	public PreferenciaConsumo getPreferenciaConsumo() {
		return preferenciaConsumo;
	}
}
