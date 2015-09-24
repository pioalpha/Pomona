package com.github.pomona.application.diretrizAlimentar.command;

import com.github.common.application.command.Command;
import com.github.pomona.domain.reference.TipoNorma;

public class AdicionarNormaADiretrizAlimentarCommand implements Command {
	private String diretrizAlimentarId;
	private String substanciaId;
	private TipoNorma tipoNorma;
	private Float normaMinima;
	private Float normaMaxima;
	
	public AdicionarNormaADiretrizAlimentarCommand(String diretrizAlimentarId, String substanciaId, TipoNorma tipoNorma,
			Float normaMinima, Float normaMaxima) {
		super();
		this.diretrizAlimentarId = diretrizAlimentarId;
		this.substanciaId = substanciaId;
		this.tipoNorma = tipoNorma;
		this.normaMinima = normaMinima;
		this.normaMaxima = normaMaxima;
	}
	
	public String getDiretrizAlimentarId() {
		return diretrizAlimentarId;
	}
	
	public String getSubstanciaId() {
		return substanciaId;
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
