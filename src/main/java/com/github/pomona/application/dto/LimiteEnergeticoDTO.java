package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.TipoRefeicao;

public class LimiteEnergeticoDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private Date dataCadastro;
	private TipoRefeicao tipoRefeicao;
	private float percentualEnergetico;
	private float tolerancia;
	private boolean editado;

	public LimiteEnergeticoDTO(Date dataCadastro, TipoRefeicao tipoRefeicao, float percentualEnergetico,
			float tolerancia) {
		super();
		
		this.dataCadastro = dataCadastro;
		this.tipoRefeicao = tipoRefeicao;
		this.percentualEnergetico = percentualEnergetico;
		this.tolerancia = tolerancia;
		this.editado = false;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}

	public float getPercentualEnergetico() {
		return percentualEnergetico;
	}

	public float getTolerancia() {
		return tolerancia;
	}

	public boolean isEditado() {
		return editado;
	}

	public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
		this.editado = true;
		this.tipoRefeicao = tipoRefeicao;
	}

	public void setPercentualEnergetico(float percentualEnergetico) {
		this.editado = true;
		this.percentualEnergetico = percentualEnergetico;
	}

	public void setTolerancia(float tolerancia) {
		this.editado = true;
		this.tolerancia = tolerancia;
	}

}
