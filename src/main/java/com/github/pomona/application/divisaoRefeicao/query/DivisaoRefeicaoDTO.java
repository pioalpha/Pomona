package com.github.pomona.application.divisaoRefeicao.query;

import java.util.Collection;
import java.util.Date;

import com.github.common.application.query.DTO;
import com.github.pomona.application.query.LimiteEnergeticoDTO;

public class DivisaoRefeicaoDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private Date dataConsultada;
	private String uuid;
	private String nome;
	private Collection<LimiteEnergeticoDTO> limitesEnergeticos;
	private boolean editado;

	public DivisaoRefeicaoDTO(Date dataConsultada, String uuid, String nome,
			Collection<LimiteEnergeticoDTO> limitesEnergeticos) {
		super();

		this.dataConsultada = dataConsultada;
		this.uuid = uuid;
		this.nome = nome;
		this.limitesEnergeticos = limitesEnergeticos;
		this.editado = false;
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

	public boolean isEditado() {
		return editado;
	}

	public void setNome(String nome) {
		this.editado = true;
		this.nome = nome;
	}

	public void setLimitesEnergeticos(Collection<LimiteEnergeticoDTO> limitesEnergeticos) {
		this.editado = true;
		this.limitesEnergeticos = limitesEnergeticos;
	}

}
