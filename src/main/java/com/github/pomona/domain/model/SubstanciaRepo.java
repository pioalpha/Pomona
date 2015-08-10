package com.github.pomona.domain.model;

import java.util.Collection;

public interface SubstanciaRepo {
    public void add(Substancia substancia);

    public Collection<Substancia> todasSubstancias();

    public void remove(Substancia substancia);

    public Substancia substanciaPeloNome(String nome);
    
    public SubstanciaId proximaIdentidade();
    
    public int proximaOrdem();
}
