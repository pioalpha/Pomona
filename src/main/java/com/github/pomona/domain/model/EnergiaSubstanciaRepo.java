package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface EnergiaSubstanciaRepo extends GenericoRepo<EnergiaSubstancia, EnergiaSubstanciaId> {
	public EnergiaSubstancia energiaSubstanciaPelaSubstancia(Substancia substancia);
}
