package com.github.pomona.application.paciente.command;

import com.github.common.application.command.Command;
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
