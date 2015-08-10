package com.github.pomona.domain.model;

import java.util.Collection;

public interface PlanoAlimentarRepo {
    public void add(PlanoReeducacaoAlimentar planoAlimentar);

    public Collection<PlanoReeducacaoAlimentar> todosPlanosAlimentaes();

    public void remove(PlanoReeducacaoAlimentar planoAlimentar);

    public PlanoReeducacaoAlimentar planoAlimentarPeloNomePaciente(String nome);
}
