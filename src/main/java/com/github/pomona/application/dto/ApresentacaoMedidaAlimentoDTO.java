package com.github.pomona.application.dto;

import com.github.common.service.dto.DTO;

public class ApresentacaoMedidaAlimentoDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private String uuid;
	private ApresentacaoDTO apresentacao;
	private MedidaDTO medida;
	private float quantidade;
	private boolean editado;

	public ApresentacaoMedidaAlimentoDTO(String uuid, ApresentacaoDTO apresentacao, MedidaDTO medida, float quantidade) {
		super();
		
		this.uuid = uuid;
		this.apresentacao = apresentacao;
		this.medida = medida;
		this.quantidade = quantidade;
		this.editado = false;
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

	public boolean isEditado() {
		return editado;
	}

	public void setApresentacao(ApresentacaoDTO apresentacao) {
		this.editado = true;
		this.apresentacao = apresentacao;
	}

	public void setMedida(MedidaDTO medida) {
		this.editado = true;
		this.medida = medida;
	}

	public void setQuantidade(float quantidade) {
		this.editado = true;
		this.quantidade = quantidade;
	}

}
