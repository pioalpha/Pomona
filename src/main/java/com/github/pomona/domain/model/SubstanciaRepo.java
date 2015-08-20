package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface SubstanciaRepo extends GenericoRepo<Substancia, SubstanciaId> {
    public Substancia substanciaPeloNome(String nome);
    
    public Long proximaOrdem();
}
