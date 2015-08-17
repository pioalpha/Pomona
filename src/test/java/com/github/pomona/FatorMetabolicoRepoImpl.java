package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.FatorMetabolico;
import com.github.pomona.domain.model.FatorMetabolicoId;
import com.github.pomona.domain.model.FatorMetabolicoRepo;

public class FatorMetabolicoRepoImpl implements FatorMetabolicoRepo {
	private Map<FatorMetabolicoId, FatorMetabolico> repo = new HashMap<FatorMetabolicoId, FatorMetabolico>();

	@Override
	public void adicionar(FatorMetabolico umObjeto) {
		repo.put(umObjeto.fatorMetabolicoId(), umObjeto);
	}

	@Override
	public Collection<FatorMetabolico> todosObjetos() {
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
	public FatorMetabolico objetoDeId(AbstractId umaId) {
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
