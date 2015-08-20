package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.AlimentoUnitario;

@Singleton
public class AlimentoRepoImpl implements AlimentoRepo {
	private static final long serialVersionUID = 1L;

	private Map<AlimentoId, AlimentoUnitario> repo = new HashMap<AlimentoId, AlimentoUnitario>();
	
	@Override
	public AlimentoUnitario adicionar(AlimentoUnitario umObjeto) {
		repo.put(umObjeto.alimentoId(), umObjeto);
		//Armazenar/Atualiza Composicao Alimentar
		//for(ComponenteAlimentar c : alimento.getComposicaoAlimentar()){
			
		//}
		return null;
	}

	@Override
	public Collection<AlimentoUnitario> todos() {
		return repo.values();
	}

	@Override
	public void remover(AlimentoUnitario umObjeto) {
		//excluir Composição Alimentar
		repo.remove(umObjeto.alimentoId());
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
	public AlimentoUnitario porId(AbstractId umaId) {
		return repo.get(umaId);
	}

}
