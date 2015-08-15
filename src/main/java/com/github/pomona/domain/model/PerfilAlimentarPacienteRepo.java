package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface PerfilAlimentarPacienteRepo extends GenericoRepo<PerfilAlimentarPaciente, PerfilAlimentarPacienteId> {
	public PerfilAlimentarPaciente perfilAlimentarPacientePeloPaciente(Paciente paciente);
}
