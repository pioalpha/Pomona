package com.github.pomona.domain.model;

import java.util.Collection;

public interface TipoPreparoRepo {
    public void add(TipoPreparo tipoPreparo);

    public Collection<TipoPreparo> todosTiposPreparo();

    public void remove(TipoPreparo tipoPreparo);

    public TipoPreparo tipoPreparoPeloNome(String nome);
}
