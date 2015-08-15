package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class FatorMetabolicoId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5955215580876160686L;

	public FatorMetabolicoId() {
		super();
	}

	public FatorMetabolicoId(String umId) {
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
