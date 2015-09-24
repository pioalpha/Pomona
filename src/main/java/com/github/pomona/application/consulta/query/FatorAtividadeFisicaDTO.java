package com.github.pomona.application.consulta.query;

import java.util.Date;

import com.github.common.application.query.DTO;

public class FatorAtividadeFisicaDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private Date dataConsultada;
	private String uuid;
	private String nome;
	private float fator;
	private Date dataRevogacao;
	private boolean editado;

	public FatorAtividadeFisicaDTO(Date dataConsultada, String uuid, String nome, float fator, Date dataRevogacao) {
		super();
		
		this.dataConsultada = dataConsultada;
		this.uuid = uuid;
		this.nome = nome;
		this.fator = fator;
		this.dataRevogacao = dataRevogacao;
		this.editado = false;
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

	public boolean isEditado() {
		return editado;
	}

	public void setNome(String nome) {
		this.editado = true;
		this.nome = nome;
	}

	public void setFator(float fator) {
		this.editado = true;
		this.fator = fator;
	}

}
