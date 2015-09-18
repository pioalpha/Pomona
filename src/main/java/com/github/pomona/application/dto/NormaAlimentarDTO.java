package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.TipoNorma;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class NormaAlimentarDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private Date dataCriacao;
	private Float normaMinima;
	private Float normaMaxima;
	private TipoNorma tipoNorma;
	private String uuidSubstancia;
	private String nomeSubstancia;
	private UnidadeSubstancia unidadeSubstancia;
	private boolean editado;

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
		this.editado = false;
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

	public boolean isEditado() {
		return editado;
	}

	public void setNormaMinima(Float normaMinima) {
		this.editado = true;
		this.normaMinima = normaMinima;
	}

	public void setNormaMaxima(Float normaMaxima) {
		this.editado = true;
		this.normaMaxima = normaMaxima;
	}

	public void setTipoNorma(TipoNorma tipoNorma) {
		this.editado = true;
		this.tipoNorma = tipoNorma;
	}

	public void setUuidSubstancia(String uuidSubstancia) {
		this.editado = true;
		this.uuidSubstancia = uuidSubstancia;
	}

	public void setNomeSubstancia(String nomeSubstancia) {
		this.editado = true;
		this.nomeSubstancia = nomeSubstancia;
	}

	public void setUnidadeSubstancia(UnidadeSubstancia unidadeSubstancia) {
		this.editado = true;
		this.unidadeSubstancia = unidadeSubstancia;
	}

}
