package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.PerfilAlimentarPacienteId;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.model.PlanoAlimentarId;
import com.github.pomona.domain.model.PlanoAlimentarRepo;

public class PlanoAlimentarRepoImpl implements PlanoAlimentarRepo {
	private Map<PlanoAlimentarId, PlanoAlimentar> repo = new HashMap<PlanoAlimentarId, PlanoAlimentar>();

	@Override
	public void adicionar(PlanoAlimentar umObjeto) {
		repo.put(umObjeto.planoAlimentarId(), umObjeto);
	}

	@Override
	public Collection<PlanoAlimentar> todosObjetos() {
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
	public PlanoAlimentar objetoDeId(AbstractId umaId) {
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
