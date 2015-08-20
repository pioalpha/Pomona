package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.model.PerfilAlimentarPaciente;
import com.github.pomona.domain.model.PerfilAlimentarPacienteId;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;

@Singleton
public class PerfilAlimentarPacienteRepoImpl implements PerfilAlimentarPacienteRepo {
	private static final long serialVersionUID = 1L;

	private Map<PerfilAlimentarPacienteId, PerfilAlimentarPaciente> repo = new HashMap<PerfilAlimentarPacienteId, PerfilAlimentarPaciente>();

	@Override
	public PerfilAlimentarPaciente adicionar(PerfilAlimentarPaciente umObjeto) {
		repo.put(umObjeto.perfilAlimentarPacienteId(), umObjeto);
		return null;
	}

	@Override
	public Collection<PerfilAlimentarPaciente> todos() {
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
	public PerfilAlimentarPaciente porId(AbstractId umaId) {
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
