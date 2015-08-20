package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class TipoPreparo extends ConcurrencySafeEntity {
	
	private static final long serialVersionUID = -2098051965600841764L;
	
	@Embedded
	private TipoPreparoId tipoPreparoId;
	@Column(nullable = false, length = 100)
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
