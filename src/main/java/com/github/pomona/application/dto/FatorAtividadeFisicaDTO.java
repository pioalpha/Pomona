package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.dto.DTO;

public class FatorAtividadeFisicaDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private Date dataConsultada;
	private String uuid;
	private String nome;
	private float fator;
	private Date dataRevogacao;

	public FatorAtividadeFisicaDTO(Date dataConsultada, String uuid, String nome, float fator, Date dataRevogacao) {
		super();
		
		this.dataConsultada = dataConsultada;
		this.uuid = uuid;
		this.nome = nome;
		this.fator = fator;
		this.dataRevogacao = dataRevogacao;
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

	public float getFator() {
		return fator;
	}

	public Date getDataRevogacao() {
		return dataRevogacao;
	}

}
