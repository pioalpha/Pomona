package com.github.pomona.domain.model;

import java.util.Collection;

public interface PerfilAlimentarPacienteRepo {
    public void add(PerfilAlimentarPaciente perfilAlimentarPaciente);

    public Collection<PerfilAlimentarPaciente> todosPerfisAlimentares();

    public void remove(PerfilAlimentarPaciente perfilAlimentarPaciente);

    public PerfilAlimentarPaciente perfilAlimentarPacientePeloPaciente(Paciente paciente);
}
