package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.DiretrizAlimentarId;
import com.github.pomona.domain.model.DiretrizAlimentarRepo;

public class DiretrizAlimentarRepoImpl implements DiretrizAlimentarRepo {
	private Map<DiretrizAlimentarId, DiretrizAlimentar> repo = new HashMap<DiretrizAlimentarId, DiretrizAlimentar>();

	@Override
	public void adicionar(DiretrizAlimentar umObjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<DiretrizAlimentar> todosObjetos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(DiretrizAlimentar umObjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DiretrizAlimentar diretrizAlimentarPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiretrizAlimentar objetoDeId(AbstractId umaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiretrizAlimentarId proximaIdentidade() {
		// TODO Auto-generated method stub
		return null;
	}


}
