package com.github.pomona.application.dto;

import com.github.common.service.dto.DTO;

public class ApresentacaoMedidaAlimentoDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private String uuid;
	private ApresentacaoDTO apresentacao;
	private MedidaDTO medida;
	private float quantidade;

	public ApresentacaoMedidaAlimentoDTO(String uuid, ApresentacaoDTO apresentacao, MedidaDTO medida, float quantidade) {
		super();
		
		this.uuid = uuid;
		this.apresentacao = apresentacao;
		this.medida = medida;
		this.quantidade = quantidade;
	}

	public String getUuid() {
		return uuid;
	}

	public ApresentacaoDTO getApresentacao() {
		return apresentacao;
	}

	public MedidaDTO getMedida() {
		return medida;
	}

	public float getQuantidade() {
		return quantidade;
	}

}
