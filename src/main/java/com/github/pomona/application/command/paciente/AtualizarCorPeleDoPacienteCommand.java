package com.github.pomona.application.command.paciente;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoCorPele;

public class AtualizarCorPeleDoPacienteCommand implements Command {
	private String idPlanoAlimentar;
	private TipoCorPele tipoCorPele;
	
	public AtualizarCorPeleDoPacienteCommand(String idPlanoAlimentar, TipoCorPele tipoCorPele) {
		super();
		this.idPlanoAlimentar = idPlanoAlimentar;
		this.tipoCorPele = tipoCorPele;
	}
	
	public String getIdPlanoAlimentar() {
		return idPlanoAlimentar;
	}
	
	public TipoCorPele getTipoCorPele() {
		return tipoCorPele;
	}
	
}
