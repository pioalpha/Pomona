package com.github.pomona.test;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.CardapioId;
import com.github.pomona.domain.model.CardapioRepo;
import com.github.pomona.domain.model.Consulta;

@Singleton
public class CardapioRepoImpl implements CardapioRepo {
	private static final long serialVersionUID = 1L;

	private Map<CardapioId, Cardapio> repo = new HashMap<CardapioId, Cardapio>();

	@Override
	public Cardapio adicionar(Cardapio umObjeto) {
		repo.put(umObjeto.cardapioId(), umObjeto);
		return null;
	}

	@Override
	public Collection<Cardapio> todos() {
		return repo.values();
	}

	@Override
	public void remover(Cardapio umObjeto) {
		repo.remove(umObjeto.cardapioId());
	}

	@Override
	public Collection<Cardapio> todosCardapios(Consulta consulta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cardapio cardapioPelaData(Date dia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cardapio porId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public CardapioId proximaIdentidade() {
		CardapioId cardapioId = null;
		do{
			cardapioId = new CardapioId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(cardapioId));
		return cardapioId;
	}

}
