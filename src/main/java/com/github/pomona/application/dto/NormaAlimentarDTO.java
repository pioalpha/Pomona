package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.TipoNorma;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class NormaAlimentarDTO implements DTO {
	private Date dataCriacao;
	private Float normaMinima;
	private Float normaMaxima;
	private TipoNorma tipoNorma;
	private String uuidSubstancia;
	private String nomeSubstancia;
	private UnidadeSubstancia unidadeSubstancia;

	public NormaAlimentarDTO(Date dataCriacao, Float normaMinima, Float normaMaxima, TipoNorma tipoNorma,
			String uuidSubstancia, String nomeSubstancia, UnidadeSubstancia unidadeSubstancia) {
		super();
		
		this.dataCriacao = dataCriacao;
		this.normaMinima = normaMinima;
		this.normaMaxima = normaMaxima;
		this.tipoNorma = tipoNorma;
		this.uuidSubstancia = uuidSubstancia;
		this.nomeSubstancia = nomeSubstancia;
		this.unidadeSubstancia = unidadeSubstancia;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Float getNormaMinima() {
		return normaMinima;
	}

	public Float getNormaMaxima() {
		return normaMaxima;
	}

	public TipoNorma getTipoNorma() {
		return tipoNorma;
	}

	public String getUuidSubstancia() {
		return uuidSubstancia;
	}

	public String getNomeSubstancia() {
		return nomeSubstancia;
	}

	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}

}
