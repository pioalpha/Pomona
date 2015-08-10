package com.github.pomona.domain.model;

import java.util.Collection;

public interface EnergiaSubstanciaRepo {
    public void add(EnergiaSubstancia energiaSubstancia);

    public Collection<EnergiaSubstancia> todasEnergiasSubstancia();

    public void remove(EnergiaSubstancia energiaSubstancia);

    public EnergiaSubstancia energiaSubstanciaPelaSubstancia(Substancia substancia);
}
