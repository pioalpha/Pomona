package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;

import com.github.pomona.domain.reference.TipoNorma;

public class NormaAlimentar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5353779158237702326L;
	private Float normaMinima;
	private Float normaMaxima;
	private Date data;
	private TipoNorma tipoNorma;
	private Substancia substancia;

	public Float getNormaMinima() {
		return normaMinima;
	}

	public void setNormaMinima(Float normaMinima) {
		this.normaMinima = normaMinima;
	}

	public Float getNormaMaxima() {
		return normaMaxima;
	}

	public void setNormaMaxima(Float normaMaxima) {
		this.normaMaxima = normaMaxima;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoNorma getTipoNorma() {
		return tipoNorma;
	}

	public void setTipoNorma(TipoNorma tipoNorma) {
		this.tipoNorma = tipoNorma;
	}

	public Substancia getSubstancia() {
		return substancia;
	}

	public void setSubstancia(Substancia substancia) {
		this.substancia = substancia;
	}

	@Override
	public String toString() {
		return "NormaAlimentar [normaMinima=" + normaMinima + ", normaMaxima=" + normaMaxima + ", data=" + data
				+ ", tipoNorma=" + tipoNorma + ", substancia=" + substancia + "]";
	}

}
