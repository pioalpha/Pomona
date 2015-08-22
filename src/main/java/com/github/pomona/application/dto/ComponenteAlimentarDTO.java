package com.github.pomona.application.dto;

import java.util.Date;

import com.github.pomona.domain.reference.UnidadeSubstancia;

public class ComponenteAlimentarDTO {
	private String uuidSubstancia;
	private String nomeSubstancia;
	private Float quantidadeSubstancia;
	private UnidadeSubstancia unidadeSubstancia;
	private Date dataCadastro;

	public ComponenteAlimentarDTO(String uuidSubstancia, String nomeSubstancia, Float quantidadeSubstancia,
			UnidadeSubstancia unidadeSubstancia, Date dataCadastro) {
		super();
		this.uuidSubstancia = uuidSubstancia;
		this.nomeSubstancia = nomeSubstancia;
		this.quantidadeSubstancia = quantidadeSubstancia;
		this.unidadeSubstancia = unidadeSubstancia;
		this.dataCadastro = dataCadastro;
	}

	public String getUuidSubstancia() {
		return uuidSubstancia;
	}

	public String getNomeSubstancia() {
		return nomeSubstancia;
	}

	public Float getQuantidadeSubstancia() {
		return quantidadeSubstancia;
	}

	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

}
