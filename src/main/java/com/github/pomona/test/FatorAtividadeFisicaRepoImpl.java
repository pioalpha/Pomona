package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.FatorAtividadeFisica;
import com.github.pomona.domain.model.FatorAtividadeFisicaId;
import com.github.pomona.domain.model.FatorAtividadeFisicaRepo;

@Singleton
public class FatorAtividadeFisicaRepoImpl implements FatorAtividadeFisicaRepo {
	private static final long serialVersionUID = 1L;

	private Map<FatorAtividadeFisicaId, FatorAtividadeFisica> repo = new HashMap<FatorAtividadeFisicaId, FatorAtividadeFisica>();

	@Override
	public FatorAtividadeFisica adicionar(FatorAtividadeFisica umObjeto) {
		repo.put(umObjeto.fatorAtividadeFisicaId(), umObjeto);
		return null;
	}

	@Override
	public Collection<FatorAtividadeFisica> todos() {
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
	public FatorAtividadeFisica porId(AbstractId umaId) {
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
