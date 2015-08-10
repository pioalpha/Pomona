package com.github.pomona.domain.model;

import java.util.Collection;

public interface PreparoMedidaAlimentoRepo {
    public void add(PreparoMedidaAlimento preparoMedidaAlimento);

    public Collection<PreparoMedidaAlimento> todosPreparosMedidasAlimento();

    public void remove(PreparoMedidaAlimento preparoMedidaAlimento);

    public PreparoMedidaAlimento preparoMedidaAlimentoPeloAlimento(AlimentoGranel alimento);
}
