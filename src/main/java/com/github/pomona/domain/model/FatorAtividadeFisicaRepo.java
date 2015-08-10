package com.github.pomona.domain.model;

import java.util.Collection;

public interface FatorAtividadeFisicaRepo {
    public void add(FatorAtividadeFisica fatorAtividadeFisica);

    public Collection<FatorAtividadeFisica> todosFatoresAtividadeFisica();

    public void remove(FatorAtividadeFisica fatorAtividadeFisica);

    public FatorAtividadeFisica fatorAtividadeFisicaPeloNome(String nome);
}
