package com.github.pomona.application.command.diretrizAlimentar;

import com.github.pomona.domain.reference.TipoNorma;

public class AdicionarNormaADiretrizAlimentarCommand {
	private String idDiretrizAlimentar;
	private String idSubstancia;
	private TipoNorma tipoNorma;
	private Float normaMinima;
	private Float normaMaxima;
	
	public AdicionarNormaADiretrizAlimentarCommand(String idDiretrizAlimentar, String idSubstancia, TipoNorma tipoNorma,
			Float normaMinima, Float normaMaxima) {
		super();
		this.idDiretrizAlimentar = idDiretrizAlimentar;
		this.idSubstancia = idSubstancia;
		this.tipoNorma = tipoNorma;
		this.normaMinima = normaMinima;
		this.normaMaxima = normaMaxima;
	}
	
	public String getIdDiretrizAlimentar() {
		return idDiretrizAlimentar;
	}
	
	public String getIdSubstancia() {
		return idSubstancia;
	}
	
	public TipoNorma getTipoNorma() {
		return tipoNorma;
	}
	
	public Float getNormaMinima() {
		return normaMinima;
	}
	
	public Float getNormaMaxima() {
		return normaMaxima;
	}
	
}
