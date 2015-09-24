package com.github.pomona.application.alimento.query;

import java.util.Date;
import java.util.List;

import com.github.common.application.query.DTO;
import com.github.pomona.domain.reference.UnidadeGranel;

public class AlimentoDTO implements DTO {

	private static final long serialVersionUID = 1L;

	private Date dataConsultada;
	private String uuid;
	private String nome;
	private UnidadeGranel unidadeGranel;
	private Float porcao;
	private CategoriaDTO categoria;
	private List<ComponenteAlimentarDTO> componentesAlimentares;
	private Date dataExclusao;
	private boolean editado;

	public AlimentoDTO(Date dataConsultada, String uuid, String nome, UnidadeGranel unidadeGranel, Float porcao, CategoriaDTO categoria, List<ComponenteAlimentarDTO> componentesAlimentares, Date dataExclusao) {
		super();
		
		this.uuid = uuid;
		this.nome = nome;
		this.unidadeGranel = unidadeGranel;
		this.porcao = porcao;
		this.categoria = categoria;
		this.componentesAlimentares = componentesAlimentares;
		this.dataConsultada = dataConsultada;
		this.dataExclusao = dataExclusao; 
		this.editado = false;
	}

	public AlimentoDTO(Date dataConsultada, String uuid, String nome, UnidadeGranel unidadeGranel, Float porcao, CategoriaDTO categoria, Date dataExclusao) {
		super();
		
		this.uuid = uuid;
		this.nome = nome;
		this.unidadeGranel = unidadeGranel;
		this.porcao = porcao;
		this.categoria = categoria;
		this.componentesAlimentares = null;
		this.dataConsultada = dataConsultada;
		this.dataExclusao = dataExclusao; 
		this.editado = false;
	}

	public AlimentoDTO(Date dataConsultada, String uuid, String nome, UnidadeGranel unidadeGranel, Float porcao, List<ComponenteAlimentarDTO> componentesAlimentares, Date dataExclusao) {
		super();
		
		this.uuid = uuid;
		this.nome = nome;
		this.unidadeGranel = unidadeGranel;
		this.porcao = porcao;
		this.categoria = null;
		this.componentesAlimentares = componentesAlimentares;
		this.dataConsultada = dataConsultada;
		this.dataExclusao = dataExclusao; 
		this.editado = false;
	}
	
	public String getNome() {
		return nome;
	}

	public UnidadeGranel getUnidadeGranel() {
		return unidadeGranel;
	}

	public Float getPorcao() {
		return porcao;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public List<ComponenteAlimentarDTO> getComponentesAlimentares() {
		return componentesAlimentares;
	}

	public String getUuid() {
		return uuid;
	}

	public Date getDataConsultada() {
		return dataConsultada;
	}

	public boolean isEditado() {
		return editado;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}
	
	public void setNome(String nome) {
		this.editado = true;
		this.nome = nome;
	}

	public void setUnidadeGranel(UnidadeGranel unidadeGranel) {
		this.editado = true;
		this.unidadeGranel = unidadeGranel;
	}

	public void setPorcao(Float porcao) {
		this.editado = true;
		this.porcao = porcao;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.editado = true;
		this.categoria = categoria;
	}

	public void setComponentesAlimentares(List<ComponenteAlimentarDTO> componentesAlimentares) {
		this.editado = true;
		this.componentesAlimentares = componentesAlimentares;
	}

}
