package com.github.common.domain.model;

import java.util.Collection;

public interface GenericoRepo<T, K extends AbstractId> {
    public void adicionar(T umObjeto);

    public Collection<T> todosObjetos();
    
    public T objetoDeId(AbstractId umaId);

    public void remover(T umObjeto);
    
	public K proximaIdentidade();
    
}
