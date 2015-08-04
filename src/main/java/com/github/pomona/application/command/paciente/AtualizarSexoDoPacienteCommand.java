package com.github.pomona.application.command.paciente;

import com.github.pomona.domain.reference.TipoSexo;

public class AtualizarSexoDoPacienteCommand {
	private String idPlanoAlimentar;
	private TipoSexo tipoSexo;
	
	public AtualizarSexoDoPacienteCommand(String idPlanoAlimentar, TipoSexo tipoSexo) {
		super();
		this.idPlanoAlimentar = idPlanoAlimentar;
		this.tipoSexo = tipoSexo;
	}
	
	public String getIdPlanoAlimentar() {
		return idPlanoAlimentar;
	}
	
	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}
	
}
