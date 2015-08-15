package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface ClassificacaoIMCRepo extends GenericoRepo<ClassificacaoIMC, ClassificacaoIMCId>{
    public ClassificacaoIMC classificacaoPeloNome(String nome);
}
