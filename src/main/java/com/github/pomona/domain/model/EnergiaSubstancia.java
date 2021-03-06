package com.github.pomona.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class EnergiaSubstancia extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 387515656354733193L;

	@Embedded
	private EnergiaSubstanciaId energiaSubstanciaId;
	@DecimalMin(value = "0.01")
	@Column(precision = 10, scale = 2)
	private Float fatorEnergetico;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataCadastro;
	@NotNull
	@OneToOne
	@JoinColumn(nullable = false)
	private Substancia substancia;

	public Float getFatorEnergetico() {
		return fatorEnergetico;
	}

	public void setFatorEnergetico(Float fatorEnergetico) {
		this.fatorEnergetico = fatorEnergetico;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Substancia getSubstancia() {
		return substancia;
	}

	public void setSubstancia(Substancia substancia) {
		this.substancia = substancia;
	}

	public EnergiaSubstanciaId energiaSubstanciaId() {
		return energiaSubstanciaId;
	}

	public void setEnergiaSubstanciaId(EnergiaSubstanciaId energiaSubstanciaId) {
		this.energiaSubstanciaId = energiaSubstanciaId;
	}

	@Override
	public String toString() {
		return "EnergiaSubstancia [energiaSubstanciaId=" + energiaSubstanciaId + ", fatorEnergetico=" + fatorEnergetico
				+ ", dataCadastro=" + dataCadastro + ", substancia=" + substancia + "]";
	}

}
