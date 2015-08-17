package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.model.PerfilAlimentarPaciente;
import com.github.pomona.domain.model.PerfilAlimentarPacienteId;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;

public class PerfilAlimentarPacienteRepoImpl implements PerfilAlimentarPacienteRepo {
	private Map<PerfilAlimentarPacienteId, PerfilAlimentarPaciente> repo = new HashMap<PerfilAlimentarPacienteId, PerfilAlimentarPaciente>();

	@Override
	public void adicionar(PerfilAlimentarPaciente umObjeto) {
		repo.put(umObjeto.perfilAlimentarPacienteId(), umObjeto);
	}

	@Override
	public Collection<PerfilAlimentarPaciente> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(PerfilAlimentarPaciente umObjeto) {
		repo.remove(umObjeto.perfilAlimentarPacienteId());
	}

	@Override
	public PerfilAlimentarPaciente perfilAlimentarPacientePeloPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PerfilAlimentarPaciente objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public PerfilAlimentarPacienteId proximaIdentidade() {
		PerfilAlimentarPacienteId perfilAlimentarPacienteId = null;
		do{
			perfilAlimentarPacienteId = new PerfilAlimentarPacienteId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(perfilAlimentarPacienteId));
		return perfilAlimentarPacienteId;
	}
}
