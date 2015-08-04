package com.github.pomona.application.command.consulta;

import java.util.Date;

import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.reference.TipoMeta;

public class DefinirMetaDaConsultaCommand {
	private String idConsulta;
	private TipoMeta tipoMeta;
	private float valor;
	private Date dataInicioVigencia;
	private Date dataFimVigencia;
	private DivisaoRefeicao divisaoRefeicao;
	
	public DefinirMetaDaConsultaCommand(String idConsulta, TipoMeta tipoMeta, float valor, Date dataInicioVigencia,
			Date dataFimVigencia, DivisaoRefeicao divisaoRefeicao) {
		super();
		this.idConsulta = idConsulta;
		this.tipoMeta = tipoMeta;
		this.valor = valor;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataFimVigencia = dataFimVigencia;
		this.divisaoRefeicao = divisaoRefeicao;
	}
	
	public String getIdConsulta() {
		return idConsulta;
	}
	
	public TipoMeta getTipoMeta() {
		return tipoMeta;
	}
	
	public float getValor() {
		return valor;
	}
	
	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	
	public Date getDataFimVigencia() {
		return dataFimVigencia;
	}

	public DivisaoRefeicao getDivisaoRefeicao() {
		return divisaoRefeicao;
	}
	
}
