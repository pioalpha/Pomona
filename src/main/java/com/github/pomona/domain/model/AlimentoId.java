package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class AlimentoId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4991758194203171755L;

	public AlimentoId(String umId) {
		super(umId);
	}

	public AlimentoId() {
		super();
	}

	@Override
	protected int hashValorImpar() {
		return 57853;
	}

	@Override
	protected int hashValorPrimo() {
		return 31;
	}
}
