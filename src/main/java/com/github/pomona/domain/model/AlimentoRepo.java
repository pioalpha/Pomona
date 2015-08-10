package com.github.pomona.domain.model;

import java.util.Collection;

public interface AlimentoRepo {
    public void add(AlimentoUnitario alimento);

    public Collection<AlimentoUnitario> todosAlimentos();

    public void remove(AlimentoUnitario alimento);

    public AlimentoUnitario alimentoPeloNome(String nome);
    
    public AlimentoId proximaIdentidade();
}
