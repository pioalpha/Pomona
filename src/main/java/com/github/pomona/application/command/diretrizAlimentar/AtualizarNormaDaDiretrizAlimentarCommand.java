package com.github.pomona.application.command.diretrizAlimentar;

import com.github.pomona.domain.reference.TipoNorma;

public class AtualizarNormaDaDiretrizAlimentarCommand {
	private String idNorma;
	private TipoNorma tipoNorma;
	private Float normaMinima;
	private Float normaMaxima;
	
	public AtualizarNormaDaDiretrizAlimentarCommand(String idNorma, TipoNorma tipoNorma, Float normaMinima,
			Float normaMaxima) {
		super();
		this.idNorma = idNorma;
		this.tipoNorma = tipoNorma;
		this.normaMinima = normaMinima;
		this.normaMaxima = normaMaxima;
	}
	
	public String getIdNorma() {
		return idNorma;
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
