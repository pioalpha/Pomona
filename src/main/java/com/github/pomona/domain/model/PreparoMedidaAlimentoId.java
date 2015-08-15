package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class PreparoMedidaAlimentoId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1619715530404282879L;

	public PreparoMedidaAlimentoId() {
		super();
	}

	public PreparoMedidaAlimentoId(String umId) {
		super(umId);
	}

	@Override
	protected int hashValorImpar() {
		// TODO Auto-generated method stub
		return 57853;
	}

	@Override
	protected int hashValorPrimo() {
		// TODO Auto-generated method stub
		return 31;
	}
}
