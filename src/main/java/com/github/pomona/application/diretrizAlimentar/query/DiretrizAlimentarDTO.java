package com.github.pomona.application.diretrizAlimentar.query;

import java.util.Collection;
import java.util.Date;

import com.github.common.application.query.DTO;
import com.github.pomona.application.query.NormaAlimentarDTO;

public class DiretrizAlimentarDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private Date dataConsultada;
	private String uuid;
	private String nome;
	private Date dataRevogacao;
	private Collection<NormaAlimentarDTO> normasAlimentares;
	private boolean editado;

	public DiretrizAlimentarDTO(Date dataConsultada, String uuid, String nome, Date dataRevogacao,
			Collection<NormaAlimentarDTO> normasAlimentares) {
		super();
		
		this.dataConsultada = dataConsultada;
		this.uuid = uuid;
		this.nome = nome;
		this.dataRevogacao = dataRevogacao;
		this.normasAlimentares = normasAlimentares;
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

	public Date getDataRevogacao() {
		return dataRevogacao;
	}

	public Collection<NormaAlimentarDTO> getNormasAlimentares() {
		return normasAlimentares;
	}

	public boolean isEditado() {
		return editado;
	}

	public void setNome(String nome) {
		this.editado = true;
		this.nome = nome;
	}

	public void setNormasAlimentares(Collection<NormaAlimentarDTO> normasAlimentares) {
		this.editado = true;
		this.normasAlimentares = normasAlimentares;
	}

}
