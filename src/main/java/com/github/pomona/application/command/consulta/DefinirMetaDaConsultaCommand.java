package com.github.pomona.application.command.consulta;

import java.util.Date;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoMeta;

public class DefinirMetaDaConsultaCommand implements Command {
	private String planoAlimentarId;
	private String consultaId;
	private TipoMeta tipoMeta;
	private float valorMeta;
	private Date dataInicioVigencia;
	private Date dataFimVigencia;
	private String divisaoRefeicaoId;
	
	public DefinirMetaDaConsultaCommand(String planoAlimentarId, String consultaId, TipoMeta tipoMeta, float valorMeta, Date dataInicioVigencia,
			Date dataFimVigencia, String divisaoRefeicaoId) {
		super();
		
		this.planoAlimentarId = planoAlimentarId;
		this.consultaId = consultaId;
		this.tipoMeta = tipoMeta;
		this.valorMeta = valorMeta;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataFimVigencia = dataFimVigencia;
		this.divisaoRefeicaoId = divisaoRefeicaoId;
	}
	
	public String getPlanoAlimentarId() {
		return planoAlimentarId;
	}

	public String getConsultaId() {
		return consultaId;
	}
	
	public TipoMeta getTipoMeta() {
		return tipoMeta;
	}
	
	public float getValorMeta() {
		return valorMeta;
	}
	
	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	
	public Date getDataFimVigencia() {
		return dataFimVigencia;
	}

	public String getDivisaoRefeicaoId() {
		return divisaoRefeicaoId;
	}
	
}
