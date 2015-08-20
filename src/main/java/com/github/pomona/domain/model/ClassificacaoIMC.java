package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class ClassificacaoIMC extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 9117880699050007679L;
	
	@Embedded
	private ClassificacaoIMCId classificacaoIMCId;
	@Column(precision = 10, scale = 2)
	private Float imcMinimo;
	@Column(precision = 10, scale = 2)
	private Float imcMaximo;
	@Column(nullable = false, length = 100)
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

	@Override
	public String toString() {
		return "ClassificacaoIMC [classificacaoIMCId=" + classificacaoIMCId + ", imcMinimo=" + imcMinimo
				+ ", imcMaximo=" + imcMaximo + ", situacao=" + situacao + "]";
	}
	
}
