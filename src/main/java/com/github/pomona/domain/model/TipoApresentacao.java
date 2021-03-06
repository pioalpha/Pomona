package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class TipoApresentacao extends ConcurrencySafeEntity {
	
	private static final long serialVersionUID = -2098051965600841764L;
	
	@Embedded
	private TipoApresentacaoId tipoApresentacaoId;
	@NotBlank
	@Size(min = 3, max = 100)
	@Column(nullable = false, length = 100, unique = true)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoApresentacaoId tipoApresentacaoId() {
		return tipoApresentacaoId;
	}

	public void setTipoApresentacaoId(TipoApresentacaoId tipoApresentacaoId) {
		this.tipoApresentacaoId = tipoApresentacaoId;
	}

	@Override
	public String toString() {
		return "TipoApresentacao [tipoApresentacaoId=" + tipoApresentacaoId + ", nome=" + nome + "]";
	}
	
}
