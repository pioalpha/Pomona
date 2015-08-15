package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.model.SubstanciaId;
import com.github.pomona.domain.model.SubstanciaRepo;

public class SubstanciaRepoImpl implements SubstanciaRepo {
	private Map<SubstanciaId, Substancia> repo = new HashMap<SubstanciaId, Substancia>();

	@Override
	public void adicionar(Substancia substancia) {
		repo.put(substancia.substanciaId(), substancia);
	}

	@Override
	public Collection<Substancia> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(Substancia substancia) {
		// TODO Remover Energia Substancia, Normas e Composicao Alimentar associada a substancia
		repo.remove(substancia.substanciaId());
	}

	@Override
	public Substancia substanciaPeloNome(String nome) {
		for (Substancia substancia : repo.values()){
			if (substancia.getNome().equals(nome)){
				return substancia;
			}
		}
		return null;
	}

	@Override
	public SubstanciaId proximaIdentidade() {
		SubstanciaId substanciaId = null;
		do{
			substanciaId = new SubstanciaId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(substanciaId));
		return substanciaId;
	}

	@Override
	public int proximaOrdem() {
		return repo.size();
	}

	@Override
	public Substancia objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

}
