package com.github.pomona.domain.model;

public class TipoPreparo {
	private TipoPreparoId tipoPreparoId;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPreparoId tipoPreparoId() {
		return tipoPreparoId;
	}

	public void setTipoPreparoId(TipoPreparoId tipoPreparoId) {
		this.tipoPreparoId = tipoPreparoId;
	}

	@Override
	public String toString() {
		return "TipoPreparo [tipoPreparoId=" + tipoPreparoId + ", nome=" + nome + "]";
	}
	
}
