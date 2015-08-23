package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class ComponenteAlimentarDTO implements DTO {
	private String uuidSubstancia;
	private String nomeSubstancia;
	private float quantidadeSubstancia;
	private UnidadeSubstancia unidadeSubstancia;
	private Date dataCadastro;

	public ComponenteAlimentarDTO(String uuidSubstancia, String nomeSubstancia, float quantidadeSubstancia,
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

	public float getQuantidadeSubstancia() {
		return quantidadeSubstancia;
	}

	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

}
