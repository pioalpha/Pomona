package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.DivisaoRefeicaoId;
import com.github.pomona.domain.model.DivisaoRefeicaoRepo;

public class DivisaoRefeicaoRepoImpl implements DivisaoRefeicaoRepo {
	private Map<DivisaoRefeicaoId, DivisaoRefeicao> repo = new HashMap<DivisaoRefeicaoId, DivisaoRefeicao>();

	@Override
	public void adicionar(DivisaoRefeicao umObjeto) {
		repo.put(umObjeto.divisaoRefeicaoId(), umObjeto);
	}

	@Override
	public Collection<DivisaoRefeicao> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(DivisaoRefeicao umObjeto) {
		repo.remove(umObjeto.divisaoRefeicaoId());
	}

	@Override
	public DivisaoRefeicao divisaoRefeicaoPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DivisaoRefeicao objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public DivisaoRefeicaoId proximaIdentidade() {
		DivisaoRefeicaoId divisaoRefeicaoId = null;
		do{
			divisaoRefeicaoId = new DivisaoRefeicaoId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(divisaoRefeicaoId));
		return divisaoRefeicaoId;
	}


}
