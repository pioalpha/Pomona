package com.github.pomona.application.command.diretrizAlimentar;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoNorma;

public class AtualizarNormaDaDiretrizAlimentarCommand implements Command {
	private String normaId;
	private TipoNorma tipoNorma;
	private Float normaMinima;
	private Float normaMaxima;
	
	public AtualizarNormaDaDiretrizAlimentarCommand(String normaId, TipoNorma tipoNorma, Float normaMinima,
			Float normaMaxima) {
		super();
		this.normaId = normaId;
		this.tipoNorma = tipoNorma;
		this.normaMinima = normaMinima;
		this.normaMaxima = normaMaxima;
	}
	
	public String getNormaId() {
		return normaId;
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
