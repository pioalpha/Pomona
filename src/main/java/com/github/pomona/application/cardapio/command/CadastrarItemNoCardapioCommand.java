package com.github.pomona.application.cardapio.command;

import com.github.common.application.command.Command;
import com.github.pomona.domain.reference.TipoRefeicao;

public class CadastrarItemNoCardapioCommand implements Command {
	private String cardapioId;
	private String alimentoId;
	private String tipoApresentacaoId;
	private TipoRefeicao tipoRefeicao;
	private float quantidade;
	
	public CadastrarItemNoCardapioCommand(String cardapioId, String alimentoId, String tipoApresentacaoId,
			TipoRefeicao tipoRefeicao, float quantidade) {
		super();
		this.cardapioId = cardapioId;
		this.alimentoId = alimentoId;
		this.tipoApresentacaoId = tipoApresentacaoId;
		this.tipoRefeicao = tipoRefeicao;
		this.quantidade = quantidade;
	}
	
	public String getCardapioId() {
		return cardapioId;
	}
	
	public String getAlimentoId() {
		return alimentoId;
	}
	
	public String getTipoApresentacaoId() {
		return tipoApresentacaoId;
	}
	
	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
