package com.github.pomona.application.alimento.command;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.github.common.application.command.Command;
import com.github.pomona.domain.reference.UnidadeGranel;

public class CadastrarAlimentoGranelCommand implements Command {
	@NotEmpty
	private String nome;
	@NotNull
	private UnidadeGranel unidadeGranel;
	@NotNull
	private float porcao;
	@NotEmpty
	private String categoriaAlimentoId;

	public CadastrarAlimentoGranelCommand(String nome, UnidadeGranel unidadeGranel, float porcao,
			String categoriaAlimentoId) {
		super();

		this.nome = nome;
		this.unidadeGranel = unidadeGranel;
		this.porcao = porcao;
		this.categoriaAlimentoId = categoriaAlimentoId;
	}

	public String getNome() {
		return nome;
	}

	public UnidadeGranel getUnidadeGranel() {
		return unidadeGranel;
	}

	public float getPorcao() {
		return porcao;
	}

	public String getCategoriaAlimentoId() {
		return categoriaAlimentoId;
	}

}
