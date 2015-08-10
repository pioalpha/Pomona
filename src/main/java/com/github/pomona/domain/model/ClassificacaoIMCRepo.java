package com.github.pomona.domain.model;

import java.util.Collection;

public interface ClassificacaoIMCRepo {
    public void add(ClassificacaoIMC classificacaoIMC);

    public Collection<ClassificacaoIMC> todasClassificacoes();

    public void remove(ClassificacaoIMC classificacaoIMC);

    public ClassificacaoIMC classificacaoPeloNome(String nome);

}
