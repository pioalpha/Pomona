package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;

public class EnergiaSubstancia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 387515656354733193L;
	private EnergiaSubstanciaId energiaSubstanciaId;
	private float fatorEnergetico;
	private Date dataCadastro;
	private Substancia substancia;

	public float getFatorEnergetico() {
		return fatorEnergetico;
	}

	public void setFatorEnergetico(float fatorEnergetico) {
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
