package com.github.pomona.application.command.cardapio;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoRefeicao;

public class CadastrarItemNoCardapioCommand implements Command {
	private String idCardapio;
	private String idAlimento;
	private String idTipoPreparo;
	private TipoRefeicao tipoRefeicao;
	private float quantidade;
	
	public CadastrarItemNoCardapioCommand(String idCardapio, String idAlimento, String idTipoPreparo,
			TipoRefeicao tipoRefeicao, float quantidade) {
		super();
		this.idCardapio = idCardapio;
		this.idAlimento = idAlimento;
		this.idTipoPreparo = idTipoPreparo;
		this.tipoRefeicao = tipoRefeicao;
		this.quantidade = quantidade;
	}
	
	public String getIdCardapio() {
		return idCardapio;
	}
	
	public String getIdAlimento() {
		return idAlimento;
	}
	
	public String getIdTipoPreparo() {
		return idTipoPreparo;
	}
	
	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
