package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class ConsultaId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3473482320402269473L;

	public ConsultaId() {
		super();
	}

	public ConsultaId(String umId) {
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
