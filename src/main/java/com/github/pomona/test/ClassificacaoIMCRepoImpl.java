package com.github.pomona.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.ClassificacaoIMC;
import com.github.pomona.domain.model.ClassificacaoIMCId;
import com.github.pomona.domain.model.ClassificacaoIMCRepo;

@Singleton
public class ClassificacaoIMCRepoImpl implements ClassificacaoIMCRepo {
	private static final long serialVersionUID = 1L;

	private Map<ClassificacaoIMCId, ClassificacaoIMC> repo = new HashMap<ClassificacaoIMCId, ClassificacaoIMC>();

	@Override
	public ClassificacaoIMC adicionar(ClassificacaoIMC umObjeto) {
		repo.put(umObjeto.classificacaoIMCId(), umObjeto);
		return null;
	}

	@Override
	public Collection<ClassificacaoIMC> todos() {
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
	public ClassificacaoIMC porId(AbstractId umaId) {
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
