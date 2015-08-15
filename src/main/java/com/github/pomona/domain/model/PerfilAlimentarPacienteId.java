package com.github.pomona.domain.model;

import com.github.common.domain.model.AbstractId;

public class PerfilAlimentarPacienteId extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7247496344833969902L;

	public PerfilAlimentarPacienteId() {
		super();
	}

	public PerfilAlimentarPacienteId(String umId) {
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
