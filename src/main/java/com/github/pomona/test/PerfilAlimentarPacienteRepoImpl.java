package com.github.pomona.test;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.model.PerfilAlimentarPaciente;
import com.github.pomona.domain.model.PerfilAlimentarPacienteId;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;

public class PerfilAlimentarPacienteRepoImpl implements PerfilAlimentarPacienteRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public PerfilAlimentarPaciente adicionar(PerfilAlimentarPaciente umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<PerfilAlimentarPaciente> todos() {
		return manager.createQuery("from PerfilAlimentarPaciente", PerfilAlimentarPaciente.class).getResultList();
	}

	@Override
	public void remover(PerfilAlimentarPaciente umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public PerfilAlimentarPaciente perfilAlimentarPacientePeloPaciente(Paciente paciente) {
		return manager.createQuery("from PerfilAlimentarPaciente where paciente = :paciente", PerfilAlimentarPaciente.class)
				.setParameter("paciente", paciente)
				.getSingleResult();
	}

	@Override
	public PerfilAlimentarPaciente porId(AbstractId umaId) {
		try {
			return manager.createQuery("from PerfilAlimentarPaciente where uuid = :uuid", PerfilAlimentarPaciente.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public PerfilAlimentarPacienteId proximaIdentidade() {
		PerfilAlimentarPacienteId perfilAlimentarPacienteId = null;
		do{
			perfilAlimentarPacienteId = new PerfilAlimentarPacienteId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(perfilAlimentarPacienteId) != null);
		return perfilAlimentarPacienteId;
	}
}
