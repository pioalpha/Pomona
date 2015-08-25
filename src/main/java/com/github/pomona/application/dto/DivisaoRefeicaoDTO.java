package com.github.pomona.application.dto;

import java.util.Collection;
import java.util.Date;

import com.github.common.service.dto.DTO;

public class DivisaoRefeicaoDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private Date dataConsultada;
	private String uuid;
	private String nome;
	private Collection<LimiteEnergeticoDTO> limitesEnergeticos;

	public DivisaoRefeicaoDTO(Date dataConsultada, String uuid, String nome,
			Collection<LimiteEnergeticoDTO> limitesEnergeticos) {
		super();

		this.dataConsultada = dataConsultada;
		this.uuid = uuid;
		this.nome = nome;
		this.limitesEnergeticos = limitesEnergeticos;
	}

	public Date getDataConsultada() {
		return dataConsultada;
	}

	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public Collection<LimiteEnergeticoDTO> getLimitesEnergeticos() {
		return limitesEnergeticos;
	}

}
