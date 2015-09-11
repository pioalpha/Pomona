package com.github.pomona.application.dto;

import com.github.common.service.dto.DTO;

public class CategoriaDTO implements DTO {

	private static final long serialVersionUID = 1L;

	private String uuid;
	private String nome;
	private Float caloriasPorPorcao;

	public CategoriaDTO(String uuid, String nome, Float caloriasPorPorcao) {
		super();
		this.uuid = uuid;
		this.nome = nome;
		this.caloriasPorPorcao = caloriasPorPorcao;
	}

	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public Float getCaloriasPorPorcao() {
		return caloriasPorPorcao;
	}

}
