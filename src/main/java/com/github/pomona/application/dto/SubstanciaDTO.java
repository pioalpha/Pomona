package com.github.pomona.application.dto;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class SubstanciaDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private String uuid;
	private String nome;
	private Integer ordem;
	private UnidadeSubstancia unidadeSubstancia;

	public SubstanciaDTO(String uuid, String nome, Integer ordem, UnidadeSubstancia unidadeSubstancia) {
		super();
		this.uuid = uuid;
		this.nome = nome;
		this.ordem = ordem;
		this.unidadeSubstancia = unidadeSubstancia;
	}

	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}

}
