package com.github.pomona.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class ExameAntropometrico {
	
	@Column(precision = 10, scale = 2)
	private Float peso;
	@Column(precision = 10, scale = 2)
	private Float altura;
	@Transient
	private List<DobraCutanea> dobrasCutaneas;
	@Transient
	private List<CircunferenciaCorporal> circunferenciasCorporais;
	
	public ExameAntropometrico() {
		super();
		
		this.dobrasCutaneas = new ArrayList<DobraCutanea>();
		this.circunferenciasCorporais = new ArrayList<CircunferenciaCorporal>();
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public List<DobraCutanea> getDobrasCutaneas() {
		return dobrasCutaneas;
	}

	public void setDobrasCutaneas(List<DobraCutanea> dobrasCutaneas) {
		this.dobrasCutaneas = dobrasCutaneas;
	}

	public List<CircunferenciaCorporal> getCircunferenciasCorporais() {
		return circunferenciasCorporais;
	}

	public void setCircunferenciasCorporais(List<CircunferenciaCorporal> circunferenciasCorporais) {
		this.circunferenciasCorporais = circunferenciasCorporais;
	}

}
