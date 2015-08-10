package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.AlimentoUnitario;

public class AlimentoRepoImpl implements AlimentoRepo {
	private Map<AlimentoId, AlimentoUnitario> repo = new HashMap<AlimentoId, AlimentoUnitario>();
	
	@Override
	public void add(AlimentoUnitario alimento) {
		repo.put(alimento.alimentoId(), alimento);
		//Armazenar Composicao Alimentar
	}

	@Override
	public Collection<AlimentoUnitario> todosAlimentos() {
		return repo.values();
	}

	@Override
	public void remove(AlimentoUnitario alimento) {
		//excluir Composição Alimentar
		repo.remove(alimento.alimentoId());
	}

	@Override
	public AlimentoUnitario alimentoPeloNome(String nome) {
		for (AlimentoUnitario alimento : repo.values()){
			if (alimento.getNome().equals(nome)){
				return alimento;
			}
		}
		return null;
	}

	@Override
	public AlimentoId proximaIdentidade() {
		AlimentoId alimentoId = null;
		do{
			alimentoId = new AlimentoId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(alimentoId));
		return alimentoId;
	}

}
