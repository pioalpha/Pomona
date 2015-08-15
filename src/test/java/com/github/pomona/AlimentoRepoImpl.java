package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.AlimentoUnitario;

public class AlimentoRepoImpl implements AlimentoRepo {
	private Map<AlimentoId, AlimentoUnitario> repo = new HashMap<AlimentoId, AlimentoUnitario>();
	
	@Override
	public void adicionar(AlimentoUnitario alimento) {
		repo.put(alimento.alimentoId(), alimento);
		//Armazenar/Atualiza Composicao Alimentar
		//for(ComponenteAlimentar c : alimento.getComposicaoAlimentar()){
			
		//}
	}

	@Override
	public Collection<AlimentoUnitario> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(AlimentoUnitario alimento) {
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

	@Override
	public AlimentoUnitario objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

}
