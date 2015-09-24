package com.github.pomona.application.paciente.command;

import com.github.common.application.command.Command;
import com.github.pomona.domain.reference.PreferenciaConsumo;

public class AdicionarPerfilCategoriaAlimentarAoPacienteCommand implements Command {
	private String planoAlimentarId;
	private String categoriaAlimentoId;
	private PreferenciaConsumo preferenciaConsumo;

	public AdicionarPerfilCategoriaAlimentarAoPacienteCommand(String planoAlimentarId, String categoriaAlimentoId,
			PreferenciaConsumo preferenciaConsumo) {
		super();
		this.planoAlimentarId = planoAlimentarId;
		this.categoriaAlimentoId = categoriaAlimentoId;
		this.preferenciaConsumo = preferenciaConsumo;
	}

	public String getPlanoAlimentarId() {
		return planoAlimentarId;
	}

	public String getCategoriaAlimentoId() {
		return categoriaAlimentoId;
	}

	public PreferenciaConsumo getPreferenciaConsumo() {
		return preferenciaConsumo;
	}

}
