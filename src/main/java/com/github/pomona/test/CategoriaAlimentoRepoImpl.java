package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.CategoriaAlimento;
import com.github.pomona.domain.model.CategoriaAlimentoId;
import com.github.pomona.domain.model.CategoriaAlimentoRepo;

@Singleton
public class CategoriaAlimentoRepoImpl implements CategoriaAlimentoRepo {
	private static final long serialVersionUID = 1L;

	private Map<CategoriaAlimentoId, CategoriaAlimento> repo = new HashMap<CategoriaAlimentoId, CategoriaAlimento>();

	@Override
	public CategoriaAlimento adicionar(CategoriaAlimento umObjeto) {
		repo.put(umObjeto.categoriaAlimentoId(), umObjeto);
		return null;
	}

	@Override
	public Collection<CategoriaAlimento> todos() {
		return repo.values();
	}

	@Override
	public CategoriaAlimento porId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public void remover(CategoriaAlimento umObjeto) {
		repo.remove(umObjeto.categoriaAlimentoId());
	}

	@Override
	public CategoriaAlimentoId proximaIdentidade() {
		CategoriaAlimentoId categoriaAlimentoId = null;
		do{
			categoriaAlimentoId = new CategoriaAlimentoId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(categoriaAlimentoId));
		return categoriaAlimentoId;
	}

}
