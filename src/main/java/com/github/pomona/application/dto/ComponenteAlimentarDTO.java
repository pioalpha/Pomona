package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.dto.DTO;

public class ComponenteAlimentarDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private SubstanciaDTO substancia;
	private Float quantidadeSubstancia;
	private Date dataCadastro;

	public ComponenteAlimentarDTO(SubstanciaDTO substancia, Float quantidadeSubstancia,
			Date dataCadastro) {
		super();
		
		this.substancia = substancia;
		this.quantidadeSubstancia = quantidadeSubstancia;
		this.dataCadastro = dataCadastro;
	}

	public SubstanciaDTO getSubstancia() {
		return substancia;
	}

	public Float getQuantidadeSubstancia() {
		return quantidadeSubstancia;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

}
