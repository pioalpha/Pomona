package com.github.pomona.application.dto;

import com.github.common.service.query.ParametrosPesquisa;

public class PreparoMedidaParametrosPesquisa extends ParametrosPesquisa {
	private AlimentoDTO alimento;
	private PreparoDTO preparo;
	private MedidaDTO medida;

	public PreparoMedidaParametrosPesquisa() {
		super();
	}

	public PreparoMedidaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina) {
		super(numeroResultadosPorPagina, numeroDaPagina);
	}

	public PreparoMedidaParametrosPesquisa(AlimentoDTO alimento, PreparoDTO preparo, MedidaDTO medida) {
		super();
		
		this.alimento = alimento;
		this.preparo = preparo;
		this.medida = medida;
	}

	public PreparoMedidaParametrosPesquisa(int numeroResultadosPorPagina, int numeroDaPagina, AlimentoDTO alimento, PreparoDTO preparo, MedidaDTO medida) {
		super(numeroResultadosPorPagina, numeroDaPagina);

		this.alimento = alimento;
		this.preparo = preparo;
		this.medida = medida;
	}

	public AlimentoDTO getAlimento() {
		return alimento;
	}

	public PreparoDTO getPreparo() {
		return preparo;
	}

	public MedidaDTO getMedida() {
		return medida;
	}

}
