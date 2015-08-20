package com.github.common.domain.model;

import java.io.Serializable;
import java.util.Collection;

public interface GenericoRepo<T, K extends AbstractId> extends Serializable {
    public T adicionar(T umObjeto);

    public Collection<T> todos();
    
    public T porId(AbstractId umaId);

    public void remover(T umObjeto);
    
	public K proximaIdentidade();
    
}
