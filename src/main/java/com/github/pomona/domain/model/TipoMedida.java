package com.github.pomona.domain.model;

public class TipoMedida {
	private TipoMedidaId tipoMedidaId;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoMedidaId tipoMedidaId() {
		return tipoMedidaId;
	}

	public void setTipoMedidaId(TipoMedidaId tipoMedidaId) {
		this.tipoMedidaId = tipoMedidaId;
	}
	
}
