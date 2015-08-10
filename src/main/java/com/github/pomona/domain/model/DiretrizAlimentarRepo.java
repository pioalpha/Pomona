package com.github.pomona.domain.model;

import java.util.Collection;

public interface DiretrizAlimentarRepo {
    public void add(DiretrizAlimentar diretrizAlimentar);

    public Collection<DiretrizAlimentar> todasDiretrizesAlimentares();

    public void remove(DiretrizAlimentar diretrizAlimentar);

    public DiretrizAlimentar diretrizAlimentarPeloNome(String nome);
}
