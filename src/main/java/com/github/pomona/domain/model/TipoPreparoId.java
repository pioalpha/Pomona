package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class TipoPreparoId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4195477722408140327L;

	public TipoPreparoId() {
		super();
	}

	public TipoPreparoId(String umId) {
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
