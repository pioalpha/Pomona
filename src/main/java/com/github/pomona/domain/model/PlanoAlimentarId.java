package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class PlanoAlimentarId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4262617314389825151L;

	public PlanoAlimentarId() {
		super();
	}

	public PlanoAlimentarId(String umId) {
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
