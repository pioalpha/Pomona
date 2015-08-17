package com.github.pomona;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.CardapioId;
import com.github.pomona.domain.model.CardapioRepo;
import com.github.pomona.domain.model.Consulta;

public class CardapioRepoImpl implements CardapioRepo {
	private Map<CardapioId, Cardapio> repo = new HashMap<CardapioId, Cardapio>();

	@Override
	public void adicionar(Cardapio umObjeto) {
		repo.put(umObjeto.cardapioId(), umObjeto);
	}

	@Override
	public Collection<Cardapio> todosObjetos() {
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
	public Cardapio objetoDeId(AbstractId umaId) {
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
