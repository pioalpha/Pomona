package com.github.pomona.application.alimento.query;

import com.github.common.application.query.DTO;

public class CategoriaDTO implements DTO {

	private static final long serialVersionUID = 1L;

	private String uuid;
	private String nome;
	private Float caloriasPorPorcao;
	private boolean editado;

	public CategoriaDTO(String uuid, String nome, Float caloriasPorPorcao) {
		super();
		
		this.uuid = uuid;
		this.nome = nome;
		this.caloriasPorPorcao = caloriasPorPorcao;
		this.editado = false;
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

	public boolean isEditado() {
		return editado;
	}

	public void setNome(String nome) {
		this.editado = true;
		this.nome = nome;
	}

	public void setCaloriasPorPorcao(Float caloriasPorPorcao) {
		this.editado = true;
		this.caloriasPorPorcao = caloriasPorPorcao;
	}

}
