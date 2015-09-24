package com.github.pomona.application.alimento.query;

import com.github.common.application.query.DTO;

public class MedidaDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private String uuid;
	private String nome;
	private boolean editado;

	public MedidaDTO(String uuid, String nome) {
		super();
		
		this.uuid = uuid;
		this.nome = nome;
		this.editado = false;
	}

	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public boolean isEditado() {
		return editado;
	}

	public void setNome(String nome) {
		this.editado = true;
		this.nome = nome;
	}

}
