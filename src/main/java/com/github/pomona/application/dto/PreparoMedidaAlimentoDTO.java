package com.github.pomona.application.dto;

import com.github.common.service.dto.DTO;

public class PreparoMedidaAlimentoDTO implements DTO {
	private String uuid;
	private PreparoDTO preparo;
	private MedidaDTO medida;
	private float quantidade;

	public PreparoMedidaAlimentoDTO(String uuid, PreparoDTO preparo, MedidaDTO medida, float quantidade) {
		super();
		
		this.uuid = uuid;
		this.preparo = preparo;
		this.medida = medida;
		this.quantidade = quantidade;
	}

	public String getUuid() {
		return uuid;
	}

	public PreparoDTO getPreparo() {
		return preparo;
	}

	public MedidaDTO getMedida() {
		return medida;
	}

	public float getQuantidade() {
		return quantidade;
	}

}
