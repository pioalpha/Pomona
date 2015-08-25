package com.github.pomona.application.dto;

import java.util.Date;
import java.util.List;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.UnidadeGranel;

public class AlimentoDTO implements DTO {

	private static final long serialVersionUID = 1L;

	private Date dataConsultada;
	private String uuid;
	private String nome;
	private UnidadeGranel unidadeGranel;
	private Float porcao;
	private String categoriaUuid;
	private String categoria;
	private List<ComponenteAlimentarDTO> componentesAlimentares;

	public AlimentoDTO(Date dataConsultada, String uuid, String nome, UnidadeGranel unidadeGranel, Float porcao, String categoriaUuid, String categoria, List<ComponenteAlimentarDTO> componentesAlimentares) {
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

	public Float getPorcao() {
		return porcao;
	}

	public String getCategoria() {
		return categoria;
	}

	public List<ComponenteAlimentarDTO> getComponentesAlimentares() {
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
