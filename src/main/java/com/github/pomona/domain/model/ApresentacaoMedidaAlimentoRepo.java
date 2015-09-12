package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface ApresentacaoMedidaAlimentoRepo extends GenericoRepo<ApresentacaoMedidaAlimento, ApresentacaoMedidaAlimentoId> {
	public ApresentacaoMedidaAlimento apresentacaoMedidaAlimentoPeloAlimento(AlimentoGranel alimento);
}
