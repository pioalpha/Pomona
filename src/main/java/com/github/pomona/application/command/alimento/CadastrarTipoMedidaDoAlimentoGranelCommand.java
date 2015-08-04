package com.github.pomona.application.command.alimento;

import org.primefaces.context.PrimePartialResponseWriter;

import com.github.pomona.domain.model.TipoPreparo;

public class CadastrarTipoMedidaDoAlimentoGranelCommand {
	public String nome;

	public CadastrarTipoMedidaDoAlimentoGranelCommand(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
