package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;

import com.github.pomona.domain.reference.PreferenciaConsumo;

public class PerfilAlimentarPaciente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9002796467378830586L;
	private PreferenciaConsumo preferenciaConsumo;
	private Date dataCadastro;
	private AlimentoUnitario alimento;
	private PlanoAlimentar planoAlimentar;
	
	public PreferenciaConsumo getPreferenciaConsumo() {
		return preferenciaConsumo;
	}
	public void setPreferenciaConsumo(PreferenciaConsumo preferenciaConsumo) {
		this.preferenciaConsumo = preferenciaConsumo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public AlimentoUnitario getAlimento() {
		return alimento;
	}
	public void setAlimento(AlimentoUnitario alimento) {
		this.alimento = alimento;
	}
	public PlanoAlimentar getPlanoReeducacaoAlimentar() {
		return planoAlimentar;
	}
	public void setPlanoReeducacaoAlimentar(
			PlanoAlimentar planoAlimentar) {
		this.planoAlimentar = planoAlimentar;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Alimento: "+ alimento.getNome())
				.append(" (" + preferenciaConsumo)
				.append(", " + dataCadastro + ")")
				.toString();
	}
}
