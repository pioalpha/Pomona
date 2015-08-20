package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.model.PlanoAlimentarId;
import com.github.pomona.domain.model.PlanoAlimentarRepo;

@Singleton
public class PlanoAlimentarRepoImpl implements PlanoAlimentarRepo {
	private static final long serialVersionUID = 1L;

	private Map<PlanoAlimentarId, PlanoAlimentar> repo = new HashMap<PlanoAlimentarId, PlanoAlimentar>();

	@Override
	public PlanoAlimentar adicionar(PlanoAlimentar umObjeto) {
		repo.put(umObjeto.planoAlimentarId(), umObjeto);
		return null;
	}

	@Override
	public Collection<PlanoAlimentar> todos() {
		return repo.values();
	}

	@Override
	public void remover(PlanoAlimentar umObjeto) {
		repo.remove(umObjeto.planoAlimentarId());
	}

	@Override
	public PlanoAlimentar planoAlimentarPeloNomePaciente(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanoAlimentar porId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public PlanoAlimentarId proximaIdentidade() {
		PlanoAlimentarId planoAlimentarId = null;
		do{
			planoAlimentarId = new PlanoAlimentarId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(planoAlimentarId));
		return planoAlimentarId;
	}

}
