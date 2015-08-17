package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.ConsultaId;
import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.DiretrizAlimentarId;
import com.github.pomona.domain.model.DiretrizAlimentarRepo;

public class DiretrizAlimentarRepoImpl implements DiretrizAlimentarRepo {
	private Map<DiretrizAlimentarId, DiretrizAlimentar> repo = new HashMap<DiretrizAlimentarId, DiretrizAlimentar>();

	@Override
	public void adicionar(DiretrizAlimentar umObjeto) {
		repo.put(umObjeto.diretrizAlimentarId(), umObjeto);
	}

	@Override
	public Collection<DiretrizAlimentar> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(DiretrizAlimentar umObjeto) {
		repo.remove(umObjeto.diretrizAlimentarId());
	}

	@Override
	public DiretrizAlimentar diretrizAlimentarPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiretrizAlimentar objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public DiretrizAlimentarId proximaIdentidade() {
		DiretrizAlimentarId diretrizAlimentarId = null;
		do{
			diretrizAlimentarId = new DiretrizAlimentarId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(diretrizAlimentarId));
		return diretrizAlimentarId;
	}


}
