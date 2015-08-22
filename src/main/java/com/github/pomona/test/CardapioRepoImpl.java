package com.github.pomona.test;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.CardapioId;
import com.github.pomona.domain.model.CardapioRepo;
import com.github.pomona.domain.model.Consulta;

public class CardapioRepoImpl implements CardapioRepo {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public Cardapio adicionar(Cardapio umObjeto) {
		return manager.merge(umObjeto);
	}

	@Override
	public Collection<Cardapio> todos() {
		return manager.createQuery("from Cardapio", Cardapio.class).getResultList();
	}

	@Override
	public void remover(Cardapio umObjeto) {
		manager.remove(umObjeto);
	}

	@Override
	public Collection<Cardapio> todosCardapios(Consulta consulta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cardapio cardapioPelaData(Date dia) {
		return manager.createQuery("from Cardapio where dia = :dia", Cardapio.class)
				.setParameter("dia", dia)
				.getSingleResult();
	}

	@Override
	public Cardapio porId(AbstractId umaId) {
		try {
			return manager.createQuery("from Cardapio where uuid = :uuid", Cardapio.class)
					.setParameter("uuid", umaId.uuid())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public CardapioId proximaIdentidade() {
		CardapioId cardapioId = null;
		do{
			cardapioId = new CardapioId(UUID.randomUUID().toString().toUpperCase());
		}while(this.porId(cardapioId) != null);
		return cardapioId;
	}

}
