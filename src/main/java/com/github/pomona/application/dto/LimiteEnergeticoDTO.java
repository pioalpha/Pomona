package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.TipoRefeicao;

public class LimiteEnergeticoDTO implements DTO {
	private Date dataCadastro;
	private TipoRefeicao tipoRefeicao;
	private float percentualEnergetico;
	private float tolerancia;

	public LimiteEnergeticoDTO(Date dataCadastro, TipoRefeicao tipoRefeicao, float percentualEnergetico,
			float tolerancia) {
		super();
		
		this.dataCadastro = dataCadastro;
		this.tipoRefeicao = tipoRefeicao;
		this.percentualEnergetico = percentualEnergetico;
		this.tolerancia = tolerancia;
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

}
