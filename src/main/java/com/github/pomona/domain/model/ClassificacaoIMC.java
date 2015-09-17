package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class ClassificacaoIMC extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 9117880699050007679L;
	
	@Embedded
	private ClassificacaoIMCId classificacaoIMCId;
	@DecimalMin(value = "0.01")
	@Column(precision = 10, scale = 2)
	private Float imcMinimo;
	@DecimalMin(value = "0.01")
	@Column(precision = 10, scale = 2)
	private Float imcMaximo;
	@Size(min = 3, max = 100)
	@NotBlank
	@Column(nullable = false, length = 100, unique = true)
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
