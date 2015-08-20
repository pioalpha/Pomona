package com.github.pomona.domain.model;

import javax.persistence.Embeddable;

import com.github.common.domain.model.AbstractId;

@Embeddable
public class DiretrizAlimentarId extends AbstractId {

	private static final long serialVersionUID = 8964784758978092050L;

	public DiretrizAlimentarId() {
		super();
	}

	public DiretrizAlimentarId(String umId) {
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

	@Override
	public boolean equals(Object umObjeto) {
		return super.equals(umObjeto);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}
