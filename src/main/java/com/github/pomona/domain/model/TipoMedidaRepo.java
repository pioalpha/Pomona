package com.github.pomona.domain.model;

import java.util.Collection;

public interface TipoMedidaRepo {
    public void add(TipoMedida tipoMedida);

    public Collection<TipoMedida> todosTiposMedida();

    public void remove(TipoMedida tipoMedida);

    public TipoMedida tipoMedidaPeloNome(String nome);
}
