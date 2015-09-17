package com.github.pomona.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class FatorAtividadeFisica extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 1511121012847428282L;

	@Embedded
	private FatorAtividadeFisicaId fatorAtividadeFisicaId;
	@Size(min = 3, max = 100)
	@NotBlank
	@Column(nullable = false, length = 100, unique = true)
	private String atividade;
	@NotNull
	@DecimalMin(value = "0.01")
	@Column(nullable = false, precision = 10, scale = 2)
	private float fator;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataCadastro;
	@Temporal(TemporalType.DATE)
	private Date dataRevogacao;

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public float getFator() {
		return fator;
	}

	public void setFator(float fator) {
		this.fator = fator;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataRevogacao() {
		return dataRevogacao;
	}

	public void setDataRevogacao(Date dataRevogacao) {
		this.dataRevogacao = dataRevogacao;
	}

	public FatorAtividadeFisicaId fatorAtividadeFisicaId() {
		return fatorAtividadeFisicaId;
	}

	public void setFatorAtividadeFisicaId(FatorAtividadeFisicaId fatorAtividadeFisicaId) {
		this.fatorAtividadeFisicaId = fatorAtividadeFisicaId;
	}

	@Override
	public String toString() {
		return "FatorAtividadeFisica [fatorAtividadeFisicaId=" + fatorAtividadeFisicaId + ", atividade=" + atividade
				+ ", fator=" + fator + ", dataCadastro=" + dataCadastro + ", dataRevogacao=" + dataRevogacao + "]";
	}
	
}
