package com.github.pomona.application.command.paciente;

import com.github.pomona.domain.reference.PreferenciaConsumo;

public class AdicionarPerfilAlimentarAoPacienteCommand {

	private String idPlanoAlimentar;
	private String idAlimento;
	private PreferenciaConsumo preferenciaConsumo;
	
	public AdicionarPerfilAlimentarAoPacienteCommand(String idPlanoAlimentar, String idAlimento,
			PreferenciaConsumo preferenciaConsumo) {
		super();
		this.idPlanoAlimentar = idPlanoAlimentar;
		this.idAlimento = idAlimento;
		this.preferenciaConsumo = preferenciaConsumo;
	}
	
	public String getIdPlanoAlimentar() {
		return idPlanoAlimentar;
	}

	public String getIdAlimento() {
		return idAlimento;
	}

	public PreferenciaConsumo getPreferenciaConsumo() {
		return preferenciaConsumo;
	}

}
