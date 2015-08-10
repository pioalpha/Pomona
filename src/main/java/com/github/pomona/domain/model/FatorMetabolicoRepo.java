package com.github.pomona.domain.model;

import java.util.Collection;

public interface FatorMetabolicoRepo {
    public void add(FatorMetabolico fatorMetabolico);

    public Collection<FatorMetabolico> todosFatoresMetabolicos();

    public void remove(FatorMetabolico fatorMetabolico);

    public FatorMetabolico fatorMetabolicoPeloNome(String nome);
}
