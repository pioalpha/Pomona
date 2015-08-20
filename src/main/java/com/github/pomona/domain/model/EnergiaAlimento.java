package com.github.pomona.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class EnergiaAlimento extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -3413544630925233361L;

	@Embedded
	private EnergiaAlimentoId energiaAlimentoId;
	@Column(nullable = false, precision = 10, scale = 2)
	private float energia;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataCadastro;
	private boolean automatico;
	@OneToOne
	@JoinColumn(nullable = false)
	private AlimentoUnitario alimento;

	public float getEnergia() {
		return energia;
	}

	public void setEnergia(float energia) {
		this.energia = energia;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	public AlimentoUnitario getAlimento() {
		return alimento;
	}

	public void setAlimento(AlimentoUnitario alimento) {
		this.alimento = alimento;
	}

	public float getEnergiaProporcional(float qtd) {
		return energia / alimento.fatorProporcao(qtd);

	}

	public EnergiaAlimentoId energiaAlimentoId() {
		return energiaAlimentoId;
	}

	public void setEnergiaAlimentoId(EnergiaAlimentoId energiaAlimentoId) {
		this.energiaAlimentoId = energiaAlimentoId;
	}

}
