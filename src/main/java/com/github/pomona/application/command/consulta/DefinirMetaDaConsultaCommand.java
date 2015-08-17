package com.github.pomona.application.command.consulta;

import java.util.Date;

import com.github.common.service.command.Command;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.reference.TipoMeta;

public class DefinirMetaDaConsultaCommand implements Command {
	private String consultaId;
	private TipoMeta tipoMeta;
	private float valor;
	private Date dataInicioVigencia;
	private Date dataFimVigencia;
	private DivisaoRefeicao divisaoRefeicao;
	
	public DefinirMetaDaConsultaCommand(String consultaId, TipoMeta tipoMeta, float valor, Date dataInicioVigencia,
			Date dataFimVigencia, DivisaoRefeicao divisaoRefeicao) {
		super();
		this.consultaId = consultaId;
		this.tipoMeta = tipoMeta;
		this.valor = valor;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataFimVigencia = dataFimVigencia;
		this.divisaoRefeicao = divisaoRefeicao;
	}
	
	public String getConsultaId() {
		return consultaId;
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
