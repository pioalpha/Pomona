package com.github.pomona.application.dto;

import java.util.Collection;
import java.util.Date;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.UnidadeGranel;

public class AlimentoDTO implements DTO {
	private Date dataConsultada;
	private String uuid;
	private String nome;
	private UnidadeGranel unidadeGranel;
	private float porcao;
	private String categoriaUuid;
	private String categoria;
	private Collection<ComponenteAlimentarDTO> componentesAlimentares;

	public AlimentoDTO(Date dataConsultada, String uuid, String nome, UnidadeGranel unidadeGranel, float porcao, String categoriaUuid, String categoria, Collection<ComponenteAlimentarDTO> componentesAlimentares) {
		super();
		
		this.uuid = uuid;
		this.nome = nome;
		this.unidadeGranel = unidadeGranel;
		this.porcao = porcao;
		this.categoriaUuid = categoriaUuid;
		this.categoria = categoria;
		this.componentesAlimentares = componentesAlimentares;
		this.dataConsultada = dataConsultada;
	}

	public String getNome() {
		return nome;
	}

	public UnidadeGranel getUnidadeGranel() {
		return unidadeGranel;
	}

	public float getPorcao() {
		return porcao;
	}

	public String getCategoria() {
		return categoria;
	}

	public Collection<ComponenteAlimentarDTO> getComponentesAlimentares() {
		return componentesAlimentares;
	}

	public String getUuid() {
		return uuid;
	}

	public String getCategoriaUuid() {
		return categoriaUuid;
	}

	public Date getDataConsultada() {
		return dataConsultada;
	}
	
}
