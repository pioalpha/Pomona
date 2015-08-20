package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class TipoMedida extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 1372430083946004837L;
	
	@Embedded
	private TipoMedidaId tipoMedidaId;
	@Column(nullable = false, length = 100)
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

	@Override
	public String toString() {
		return "TipoMedida [tipoMedidaId=" + tipoMedidaId + ", nome=" + nome + "]";
	}
	
}
