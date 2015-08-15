package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class CategoriaAlimentoId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8295444343185495060L;

	public CategoriaAlimentoId() {
		super();
	}

	public CategoriaAlimentoId(String umId) {
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
