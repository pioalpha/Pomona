package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.model.PacienteId;
import com.github.pomona.domain.model.PacienteRepo;

public class PacienteRepoImpl implements PacienteRepo{
	private static final long serialVersionUID = 1L;

	private Map<PacienteId, Paciente> repo = new HashMap<PacienteId, Paciente>();

	@Override
	public Paciente adicionar(Paciente umObjeto) {
		repo.put(umObjeto.pacienteId(), umObjeto);
		return null;
	}

	@Override
	public Collection<Paciente> todos() {
		return repo.values();
	}

	@Override
	public Paciente porId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public void remover(Paciente umObjeto) {
		repo.remove(umObjeto.pacienteId());
	}

	@Override
	public PacienteId proximaIdentidade() {
		PacienteId pacienteId = null;
		do{
			pacienteId = new PacienteId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(pacienteId));
		return pacienteId;
	}
	

}
