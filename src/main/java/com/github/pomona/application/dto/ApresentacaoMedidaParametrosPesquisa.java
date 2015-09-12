package com.github.pomona.application.dto;

import com.github.common.service.query.ParametrosPesquisa;

public class ApresentacaoMedidaParametrosPesquisa extends ParametrosPesquisa {
	private AlimentoDTO alimento;
	private ApresentacaoDTO apresentacao;
	private MedidaDTO medida;

	public ApresentacaoMedidaParametrosPesquisa() {
		super();
	}

	public ApresentacaoMedidaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);
	}

	public ApresentacaoMedidaParametrosPesquisa(AlimentoDTO alimento, ApresentacaoDTO apresentacao, MedidaDTO medida) {
		super();
		
		this.alimento = alimento;
		this.apresentacao = apresentacao;
		this.medida = medida;
	}

	public ApresentacaoMedidaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, AlimentoDTO alimento, ApresentacaoDTO apresentacao, MedidaDTO medida) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.alimento = alimento;
		this.apresentacao = apresentacao;
		this.medida = medida;
	}

	public AlimentoDTO getAlimento() {
		return alimento;
	}

	public ApresentacaoDTO getApresentacao() {
		return apresentacao;
	}

	public MedidaDTO getMedida() {
		return medida;
	}

}
