package com.github.pomona.domain.model;

import java.util.Collection;

public interface DivisaoRefeicaoRepo {
    public void add(DivisaoRefeicao divisaoRefeicao);

    public Collection<DivisaoRefeicao> todasDivisoesRefeicao();

    public void remove(DivisaoRefeicao divisaoRefeicao);

    public DivisaoRefeicao divisaoRefeicaoPeloNome(String nome);
}
