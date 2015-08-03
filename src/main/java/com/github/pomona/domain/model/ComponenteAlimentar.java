package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;

public class ComponenteAlimentar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2722189674707674291L;
	private float quantidade;
	private Date dataCadastro;
	private Substancia substancia;
	
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
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
}
