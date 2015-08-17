package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.EnergiaAlimento;
import com.github.pomona.domain.model.EnergiaAlimentoId;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;

public class EnergiaAlimentoRepoImpl implements EnergiaAlimentoRepo {
	private Map<EnergiaAlimentoId, EnergiaAlimento> repo = new HashMap<EnergiaAlimentoId, EnergiaAlimento>();

	@Override
	public void adicionar(EnergiaAlimento umObjeto) {
		repo.put(umObjeto.energiaAlimentoId(), umObjeto);
	}

	@Override
	public Collection<EnergiaAlimento> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(EnergiaAlimento umObjeto) {
		repo.remove(umObjeto.energiaAlimentoId());
	}

	@Override
	public EnergiaAlimento energiaAlimentoPeloAlimento(AlimentoUnitario alimento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnergiaAlimento objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public EnergiaAlimentoId proximaIdentidade() {
		EnergiaAlimentoId energiaAlimentoId = null;
		do{
			energiaAlimentoId = new EnergiaAlimentoId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(energiaAlimentoId));
		return energiaAlimentoId;
	}

}
