package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.FatorAtividadeFisica;
import com.github.pomona.domain.model.FatorAtividadeFisicaId;
import com.github.pomona.domain.model.FatorAtividadeFisicaRepo;

public class FatorAtividadeFisicaRepoImpl implements FatorAtividadeFisicaRepo {
	private Map<FatorAtividadeFisicaId, FatorAtividadeFisica> repo = new HashMap<FatorAtividadeFisicaId, FatorAtividadeFisica>();

	@Override
	public void adicionar(FatorAtividadeFisica umObjeto) {
		repo.put(umObjeto.fatorAtividadeFisicaId(), umObjeto);
	}

	@Override
	public Collection<FatorAtividadeFisica> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(FatorAtividadeFisica umObjeto) {
		repo.remove(umObjeto.fatorAtividadeFisicaId());
	}

	@Override
	public FatorAtividadeFisica fatorAtividadeFisicaPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FatorAtividadeFisica objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public FatorAtividadeFisicaId proximaIdentidade() {
		FatorAtividadeFisicaId fatorAtividadeFisicaId = null;
		do{
			fatorAtividadeFisicaId = new FatorAtividadeFisicaId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(fatorAtividadeFisicaId));
		return fatorAtividadeFisicaId;
	}

}
