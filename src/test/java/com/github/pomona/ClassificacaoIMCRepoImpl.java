package com.github.pomona;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.ClassificacaoIMC;
import com.github.pomona.domain.model.ClassificacaoIMCId;
import com.github.pomona.domain.model.ClassificacaoIMCRepo;

public class ClassificacaoIMCRepoImpl implements ClassificacaoIMCRepo {
	private Map<ClassificacaoIMCId, ClassificacaoIMC> repo = new HashMap<ClassificacaoIMCId, ClassificacaoIMC>();

	@Override
	public void adicionar(ClassificacaoIMC umObjeto) {
		repo.put(umObjeto.classificacaoIMCId(), umObjeto);
	}

	@Override
	public Collection<ClassificacaoIMC> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(ClassificacaoIMC umObjeto) {
		repo.remove(umObjeto.classificacaoIMCId());
	}

	@Override
	public ClassificacaoIMC classificacaoPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassificacaoIMC objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public ClassificacaoIMCId proximaIdentidade() {
		ClassificacaoIMCId classificacaoIMCId = null;
		do{
			classificacaoIMCId = new ClassificacaoIMCId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(classificacaoIMCId));
		return classificacaoIMCId;
	}

}
