package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class ComponenteAlimentarDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private String uuidSubstancia;
	private String nomeSubstancia;
	private Float quantidadeSubstancia;
	private UnidadeSubstancia unidadeSubstancia;
	private Integer ordem;
	private Date dataCadastro;

	public ComponenteAlimentarDTO(String uuidSubstancia, String nomeSubstancia, Float quantidadeSubstancia,
			UnidadeSubstancia unidadeSubstancia, Integer ordem, Date dataCadastro) {
		super();
		
		this.uuidSubstancia = uuidSubstancia;
		this.nomeSubstancia = nomeSubstancia;
		this.quantidadeSubstancia = quantidadeSubstancia;
		this.unidadeSubstancia = unidadeSubstancia;
		this.ordem = ordem;
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

	public Integer getOrdem() {
		return ordem;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

}
