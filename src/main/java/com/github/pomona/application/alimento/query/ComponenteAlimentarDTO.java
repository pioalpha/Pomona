package com.github.pomona.application.alimento.query;

import java.util.Date;

import com.github.common.application.query.DTO;
import com.github.pomona.application.substancia.query.SubstanciaDTO;

public class ComponenteAlimentarDTO implements DTO {
	private static final long serialVersionUID = 1L;

	private String alimentoUuid;
	private SubstanciaDTO substancia;
	private Float quantidadeSubstancia;
	private Date dataCadastro;
	private boolean editado;

	public ComponenteAlimentarDTO(String alimentoUuid, SubstanciaDTO substancia, Float quantidadeSubstancia,
			Date dataCadastro) {
		super();
		
		this.alimentoUuid = alimentoUuid;
		this.substancia = substancia;
		this.quantidadeSubstancia = quantidadeSubstancia;
		this.dataCadastro = dataCadastro;
		this.editado = false;
	}

	public String getAlimentoUuid() {
		return alimentoUuid;
	}

	public SubstanciaDTO getSubstancia() {
		return substancia;
	}

	public Float getQuantidadeSubstancia() {
		return quantidadeSubstancia;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public boolean isEditado() {
		return editado;
	}

	public void setSubstancia(SubstanciaDTO substancia) {
		this.editado = true;
		this.substancia = substancia;
	}

	public void setQuantidadeSubstancia(Float quantidadeSubstancia) {
		this.editado = true;
		this.quantidadeSubstancia = quantidadeSubstancia;
	}

}
