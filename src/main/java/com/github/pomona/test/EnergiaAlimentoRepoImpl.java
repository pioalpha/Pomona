package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.EnergiaAlimento;
import com.github.pomona.domain.model.EnergiaAlimentoId;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;

@Singleton
public class EnergiaAlimentoRepoImpl implements EnergiaAlimentoRepo {
	private static final long serialVersionUID = 1L;

	private Map<EnergiaAlimentoId, EnergiaAlimento> repo = new HashMap<EnergiaAlimentoId, EnergiaAlimento>();

	@Override
	public EnergiaAlimento adicionar(EnergiaAlimento umObjeto) {
		repo.put(umObjeto.energiaAlimentoId(), umObjeto);
		return null;
	}

	@Override
	public Collection<EnergiaAlimento> todos() {
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
	public EnergiaAlimento porId(AbstractId umaId) {
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
