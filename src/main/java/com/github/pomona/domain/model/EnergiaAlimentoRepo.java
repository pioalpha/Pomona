package com.github.pomona.domain.model;

import java.util.Collection;

public interface EnergiaAlimentoRepo {
    public void add(EnergiaAlimento energiaAlimento);

    public Collection<EnergiaAlimento> todasEnergiasAlimento();

    public void remove(EnergiaAlimento energiaAlimento);

    public EnergiaAlimento energiaAlimentoPeloAlimento(AlimentoUnitario alimento);
}
