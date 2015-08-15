package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class EnergiaAlimentoId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = -61384760167786624L;

	public EnergiaAlimentoId() {
		super();
	}

	public EnergiaAlimentoId(String umId) {
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
