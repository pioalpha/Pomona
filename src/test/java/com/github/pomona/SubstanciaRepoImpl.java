package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.model.SubstanciaId;
import com.github.pomona.domain.model.SubstanciaRepo;

public class SubstanciaRepoImpl implements SubstanciaRepo {
	private Map<SubstanciaId, Substancia> repo = new HashMap<SubstanciaId, Substancia>();

	@Override
	public void add(Substancia substancia) {
		repo.put(substancia.substanciaId(), substancia);
		
	}

	@Override
	public Collection<Substancia> todasSubstancias() {
		return repo.values();
	}

	@Override
	public void remove(Substancia substancia) {
		// TODO Remver Energia Substancia, normas e composicao Alimentar atrelada a substancia
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

}
