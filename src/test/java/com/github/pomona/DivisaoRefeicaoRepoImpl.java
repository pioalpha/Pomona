package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.DivisaoRefeicaoId;
import com.github.pomona.domain.model.DivisaoRefeicaoRepo;

public class DivisaoRefeicaoRepoImpl implements DivisaoRefeicaoRepo {
	private Map<DivisaoRefeicaoId, DivisaoRefeicao> repo = new HashMap<DivisaoRefeicaoId, DivisaoRefeicao>();

	@Override
	public void adicionar(DivisaoRefeicao umObjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<DivisaoRefeicao> todosObjetos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(DivisaoRefeicao umObjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DivisaoRefeicao divisaoRefeicaoPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DivisaoRefeicao objetoDeId(AbstractId umaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DivisaoRefeicaoId proximaIdentidade() {
		// TODO Auto-generated method stub
		return null;
	}


}
