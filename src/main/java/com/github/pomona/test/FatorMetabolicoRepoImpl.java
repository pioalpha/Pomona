package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.FatorMetabolico;
import com.github.pomona.domain.model.FatorMetabolicoId;
import com.github.pomona.domain.model.FatorMetabolicoRepo;

@Singleton
public class FatorMetabolicoRepoImpl implements FatorMetabolicoRepo {
	private static final long serialVersionUID = 1L;

	private Map<FatorMetabolicoId, FatorMetabolico> repo = new HashMap<FatorMetabolicoId, FatorMetabolico>();

	@Override
	public FatorMetabolico adicionar(FatorMetabolico umObjeto) {
		repo.put(umObjeto.fatorMetabolicoId(), umObjeto);
		return null;
	}

	@Override
	public Collection<FatorMetabolico> todos() {
		return repo.values();
	}

	@Override
	public void remover(FatorMetabolico umObjeto) {
		repo.remove(umObjeto.fatorMetabolicoId());
	}

	@Override
	public FatorMetabolico fatorMetabolicoPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FatorMetabolico porId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public FatorMetabolicoId proximaIdentidade() {
		FatorMetabolicoId fatorMetabolicoId = null;
		do{
			fatorMetabolicoId = new FatorMetabolicoId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(fatorMetabolicoId));
		return fatorMetabolicoId;
	}

}
