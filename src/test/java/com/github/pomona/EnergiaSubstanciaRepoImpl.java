package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.EnergiaSubstancia;
import com.github.pomona.domain.model.EnergiaSubstanciaId;
import com.github.pomona.domain.model.EnergiaSubstanciaRepo;
import com.github.pomona.domain.model.Substancia;

public class EnergiaSubstanciaRepoImpl implements EnergiaSubstanciaRepo {
	private Map<EnergiaSubstanciaId, EnergiaSubstancia> repo = new HashMap<EnergiaSubstanciaId, EnergiaSubstancia>();

	@Override
	public void adicionar(EnergiaSubstancia umObjeto) {
		repo.put(umObjeto.energiaSubstanciaId(), umObjeto);
	}

	@Override
	public Collection<EnergiaSubstancia> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(EnergiaSubstancia umObjeto) {
		repo.remove(umObjeto.energiaSubstanciaId());
	}

	@Override
	public EnergiaSubstancia energiaSubstanciaPelaSubstancia(Substancia substancia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnergiaSubstancia objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public EnergiaSubstanciaId proximaIdentidade() {
		EnergiaSubstanciaId energiaSubstanciaId = null;
		do{
			energiaSubstanciaId = new EnergiaSubstanciaId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(energiaSubstanciaId));
		return energiaSubstanciaId;
	}

}
