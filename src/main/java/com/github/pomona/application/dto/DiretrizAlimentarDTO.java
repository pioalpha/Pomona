package com.github.pomona.application.dto;

import java.util.Collection;
import java.util.Date;

import com.github.common.service.dto.DTO;

public class DiretrizAlimentarDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private Date dataConsultada;
	private String uuid;
	private String nome;
	private Date dataRevogacao;
	private Collection<NormaAlimentarDTO> normasAlimentares;

	public DiretrizAlimentarDTO(Date dataConsultada, String uuid, String nome, Date dataRevogacao,
			Collection<NormaAlimentarDTO> normasAlimentares) {
		super();
		
		this.dataConsultada = dataConsultada;
		this.uuid = uuid;
		this.nome = nome;
		this.dataRevogacao = dataRevogacao;
		this.normasAlimentares = normasAlimentares;
	}

	public Date getDataConsultada() {
		return dataConsultada;
	}

	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataRevogacao() {
		return dataRevogacao;
	}

	public Collection<NormaAlimentarDTO> getNormasAlimentares() {
		return normasAlimentares;
	}

}
