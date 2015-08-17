package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoSexo;

public class AtualizarSexoDoPacienteCommand implements Command {
	private String planoAlimentarId;
	private TipoSexo tipoSexo;
	
	public AtualizarSexoDoPacienteCommand(String planoAlimentarId, TipoSexo tipoSexo) {
		super();
		this.planoAlimentarId = planoAlimentarId;
		this.tipoSexo = tipoSexo;
	}
	
	public String getPlanoAlimentarId() {
		return planoAlimentarId;
	}
	
	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}
	
}
