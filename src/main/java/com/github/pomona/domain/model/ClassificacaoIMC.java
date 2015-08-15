package com.github.pomona.domain.model;

import java.io.Serializable;

public class ClassificacaoIMC implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9117880699050007679L;
	private ClassificacaoIMCId classificacaoIMCId;
	private Float imcMinimo;
	private Float imcMaximo;
	private String situacao;

	public Float getImcMinimo() {
		return imcMinimo;
	}

	public void setImcMinimo(Float imcMinimo) {
		this.imcMinimo = imcMinimo;
	}

	public Float getImcMaximo() {
		return imcMaximo;
	}

	public void setImcMaximo(Float imcMaximo) {
		this.imcMaximo = imcMaximo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public ClassificacaoIMCId classificacaoIMCId() {
		return classificacaoIMCId;
	}

	public void setClassificacaoIMCId(ClassificacaoIMCId classificacaoIMCId) {
		this.classificacaoIMCId = classificacaoIMCId;
	}
}
