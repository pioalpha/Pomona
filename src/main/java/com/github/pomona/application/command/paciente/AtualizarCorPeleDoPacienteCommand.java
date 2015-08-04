package com.github.pomona.application.command.paciente;

import com.github.pomona.domain.reference.TipoCorPele;

public class AtualizarCorPeleDoPacienteCommand {
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
