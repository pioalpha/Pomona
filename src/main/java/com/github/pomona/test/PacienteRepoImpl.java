package com.github.pomona.test;

import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.model.PacienteId;
import com.github.pomona.domain.model.PacienteRepo;

public class PacienteRepoImpl implements PacienteRepo{
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public Paciente adicionar(Paciente umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<Paciente> todos() {
		return manager.createQuery("from Paciente", Paciente.class).getResultList();
	}

	@Override
	public Paciente porId(AbstractId umaId) {
		try {
			return manager.createQuery("from Paciente where uuid = :uuid", Paciente.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void remover(Paciente umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public PacienteId proximaIdentidade() {
		PacienteId pacienteId = null;
		do{
			pacienteId = new PacienteId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(pacienteId) != null);
		return pacienteId;
	}
	

}
