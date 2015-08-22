package com.github.pomona.test;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.ConsultaId;
import com.github.pomona.domain.model.ConsultaRepo;

public class ConsultaRepoImpl implements ConsultaRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public Consulta adicionar(Consulta umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<Consulta> todos() {
		return manager.createQuery("from Consulta", Consulta.class).getResultList();
	}

	@Override
	public void remover(Consulta umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public Consulta consultaPelaData(Date dataConsulta) {
		return manager.createQuery("from Consulta where dataConsulta = :dataConsulta", Consulta.class)
				.setParameter("dataConsulta", dataConsulta)
				.getSingleResult();
	}

	@Override
	public Consulta porId(AbstractId umaId) {
		try {
			return manager.createQuery("from Consulta where uuid = :uuid", Consulta.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public ConsultaId proximaIdentidade() {
		ConsultaId consultaId = null;
		do{
			consultaId = new ConsultaId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(consultaId) != null);
		return consultaId;
	}

}
