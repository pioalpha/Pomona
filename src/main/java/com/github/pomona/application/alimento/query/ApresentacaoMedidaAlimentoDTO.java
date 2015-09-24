package com.github.pomona.application.alimento.query;

import java.util.Date;

import com.github.common.application.query.DTO;

public class ApresentacaoMedidaAlimentoDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private Date dataConsulta;
	private String uuid;
	private ApresentacaoDTO apresentacao;
	private MedidaDTO medida;
	private Float quantidade;
	private Date dataCadastro;
	private boolean editado;

	public ApresentacaoMedidaAlimentoDTO(Date dataConsulta, String uuid, ApresentacaoDTO apresentacao, MedidaDTO medida, Float quantidade, Date dataCadastro) {
		super();
		
		this.dataConsulta = dataConsulta;
		this.uuid = uuid;
		this.apresentacao = apresentacao;
		this.medida = medida;
		this.quantidade = quantidade;
		this.editado = false;
		this.dataCadastro = dataCadastro;
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

	public Float getQuantidade() {
		return quantidade;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public Date getDataCadastro() {
		return dataCadastro;
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

	public void setQuantidade(Float quantidade) {
		this.editado = true;
		this.quantidade = quantidade;
	}

}
