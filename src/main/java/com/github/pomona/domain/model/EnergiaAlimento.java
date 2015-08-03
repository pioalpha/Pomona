package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;

public class EnergiaAlimento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3413544630925233361L;
	private float energia;
	private Date dataCadastro;
	private boolean automatico;
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
	public float getEnergiaProporcional(float qtd){
		return energia / alimento.fatorProporcao(qtd);
		
	}
}
