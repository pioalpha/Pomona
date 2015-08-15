package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class DivisaoRefeicaoId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6487997981818907488L;

	public DivisaoRefeicaoId() {
		super();
	}

	public DivisaoRefeicaoId(String umId) {
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
