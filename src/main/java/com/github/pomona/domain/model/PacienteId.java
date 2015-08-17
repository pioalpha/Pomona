package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class PacienteId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4466610388029416930L;

	
	public PacienteId() {
		super();
	}

	public PacienteId(String umId) {
		super(umId);
	}

	@Override
	protected int hashValorImpar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int hashValorPrimo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
