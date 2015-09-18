package com.github.pomona.application.dto;

import java.util.Date;

import com.github.common.service.dto.DTO;
import com.github.pomona.domain.reference.UnidadeSubstancia;

public class SubstanciaDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private String uuid;
	private String nome;
	private Integer ordem;
	private UnidadeSubstancia unidadeSubstancia;
	private Float fatorEnergetico;
	private Date dataCadastroFator;
	private boolean editado;

	public SubstanciaDTO(String uuid, String nome, Integer ordem, UnidadeSubstancia unidadeSubstancia, Float fatorEnergetico, Date dataCadastroFator) {
		super();
		
		this.uuid = uuid;
		this.nome = nome;
		this.ordem = ordem;
		this.unidadeSubstancia = unidadeSubstancia;
		this.fatorEnergetico = fatorEnergetico;
		this.dataCadastroFator = dataCadastroFator;
		this.editado = false;
	}

	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}
	
	public String getSubstanciaDetalhada() {
		return nome + " (" + unidadeSubstancia + ")";
	}

	public Float getFatorEnergetico() {
		return fatorEnergetico;
	}

	public Date getDataCadastroFator() {
		return dataCadastroFator;
	}

	public boolean isEditado() {
		return editado;
	}

	public void setNome(String nome) {
		this.editado = true;
		this.nome = nome;
	}

	public void setOrdem(Integer ordem) {
		this.editado = true;
		this.ordem = ordem;
	}

	public void setUnidadeSubstancia(UnidadeSubstancia unidadeSubstancia) {
		this.editado = true;
		this.unidadeSubstancia = unidadeSubstancia;
	}

	public void setFatorEnergetico(Float fatorEnergetico) {
		this.editado = true;
		this.fatorEnergetico = fatorEnergetico;
	}

}
