package com.github.pomona.application.alimento.query;

import java.util.Date;

import com.github.common.application.query.ParametrosPesquisa;

public class ApresentacaoMedidaParametrosPesquisa extends ParametrosPesquisa {
	private AlimentoDTO alimento;
	private ApresentacaoDTO apresentacao;
	private MedidaDTO medida;
	private Date dataConsulta;

	public ApresentacaoMedidaParametrosPesquisa() {
		super();
		
		this.dataConsulta = new Date();
	}

	public ApresentacaoMedidaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.dataConsulta = new Date();
	}

	public ApresentacaoMedidaParametrosPesquisa(Date dataConsulta, AlimentoDTO alimento, ApresentacaoDTO apresentacao, MedidaDTO medida) {
		super();
		
		this.alimento = alimento;
		this.apresentacao = apresentacao;
		this.medida = medida;
		this.dataConsulta = dataConsulta;
	}

	public ApresentacaoMedidaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, Date dataConsulta, AlimentoDTO alimento, ApresentacaoDTO apresentacao, MedidaDTO medida) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.alimento = alimento;
		this.apresentacao = apresentacao;
		this.medida = medida;
		this.dataConsulta = dataConsulta;
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

	public Date getDataConsulta() {
		return dataConsulta;
	}

}
