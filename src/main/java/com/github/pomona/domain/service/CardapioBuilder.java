package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;

import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.ItemCardapio;
import com.github.pomona.domain.model.RefeicaoCardapio;
import com.github.pomona.domain.reference.TipoRefeicao;

public class CardapioBuilder {
	private Cardapio instancia;
	private CalculaEnergiaAlimento calculaEnergia;
	
	public CardapioBuilder(Date dia, DivisaoRefeicao divisaoRefeicao, CalculaEnergiaAlimento calculaEnergia){
		this.calculaEnergia = calculaEnergia;
		this.instancia = new Cardapio();
		this.instancia.setDia(dia);
		this.instancia.setDivisaoRefeicao(divisaoRefeicao);
	}
	
	public CardapioBuilder adicionarAlimento(AlimentoUnitario alimento, float quantidade,
						TipoRefeicao tipoRefeicao){
		RefeicaoCardapio refeicaoCardapio = null;

		// Tento localizar a refeição no cardápio, se não houver, eu crio, se houver adiciono o item
		if (this.instancia.getRefeicoesCardapio() != null){
			for (RefeicaoCardapio item : this.instancia.getRefeicoesCardapio()){
				if (item.getTipoRefeicao().equals(tipoRefeicao)){
					refeicaoCardapio = item; 
					break;
				}
			}
		} else {
			this.instancia.setRefeicoesCardapio(new ArrayList<RefeicaoCardapio>());
		}
		
		if (refeicaoCardapio == null){
			refeicaoCardapio = new RefeicaoCardapio();
			refeicaoCardapio.setTipoRefeicao(tipoRefeicao);
			this.instancia.getRefeicoesCardapio().add(refeicaoCardapio);
		}
		
		ItemCardapio itemCardapio = new ItemCardapio();
		itemCardapio.setEnergiaAlimento(this.calculaEnergia.retornaEnergiaAlimento(alimento));
		itemCardapio.setQuantidade(quantidade);
		if (refeicaoCardapio.getItensCardapio() == null){
			refeicaoCardapio.setItensCardapio(new ArrayList<ItemCardapio>());
		}
		refeicaoCardapio.getItensCardapio().add(itemCardapio);
		
		return this;
	}
	
	public Cardapio construir(){
		return this.instancia;
	}

}
