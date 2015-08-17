package com.github.pomona.application.command.cardapio;

import com.github.common.service.command.Command;
import com.github.pomona.domain.reference.TipoRefeicao;

public class CadastrarItemNoCardapioCommand implements Command {
	private String cardapioId;
	private String alimentoId;
	private String tipoPreparoId;
	private TipoRefeicao tipoRefeicao;
	private float quantidade;
	
	public CadastrarItemNoCardapioCommand(String cardapioId, String alimentoId, String tipoPreparoId,
			TipoRefeicao tipoRefeicao, float quantidade) {
		super();
		this.cardapioId = cardapioId;
		this.alimentoId = alimentoId;
		this.tipoPreparoId = tipoPreparoId;
		this.tipoRefeicao = tipoRefeicao;
		this.quantidade = quantidade;
	}
	
	public String getCardapioId() {
		return cardapioId;
	}
	
	public String getAlimentoId() {
		return alimentoId;
	}
	
	public String getTipoPreparoId() {
		return tipoPreparoId;
	}
	
	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
}
