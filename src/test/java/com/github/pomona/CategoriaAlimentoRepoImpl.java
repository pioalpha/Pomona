package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.CategoriaAlimento;
import com.github.pomona.domain.model.CategoriaAlimentoId;
import com.github.pomona.domain.model.CategoriaAlimentoRepo;

public class CategoriaAlimentoRepoImpl implements CategoriaAlimentoRepo {
	private Map<CategoriaAlimentoId, CategoriaAlimento> repo = new HashMap<CategoriaAlimentoId, CategoriaAlimento>();

	@Override
	public void adicionar(CategoriaAlimento umObjeto) {
		repo.put(umObjeto.categoriaAlimentoId(), umObjeto);
	}

	@Override
	public Collection<CategoriaAlimento> todosObjetos() {
		return repo.values();
	}

	@Override
	public CategoriaAlimento objetoDeId(AbstractId umaId) {
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
