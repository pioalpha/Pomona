package com.github.pomona.domain.model;

import java.util.Date;
import java.util.Collection;

public interface CardapioRepo {
    public void add(Cardapio cardapio);

    public Collection<Cardapio> todosCardapios(Consulta consulta);

    public void remove(Cardapio cardapio);

    public Cardapio cardapioPelaData(Date dia);

}
