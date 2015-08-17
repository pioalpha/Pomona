package com.github.pomona.application.command.alimento;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.UnidadeGranel;

public class CadastrarAlimentoGranelCommand implements Command {
	private String nome;
	private UnidadeGranel unidadeGranel;
	private float porcao;
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
