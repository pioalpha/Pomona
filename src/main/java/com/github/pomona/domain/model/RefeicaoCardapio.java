package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pomona.domain.reference.TipoRefeicao;
import com.github.pomona.domain.reference.UnidadeGranel;

public class RefeicaoCardapio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6141970855499751780L;
	private List<ItemCardapio> itensCardapio;
	private TipoRefeicao tipoRefeicao;

	public RefeicaoCardapio() {
		super();

		this.itensCardapio = new ArrayList<ItemCardapio>();
	}

	public List<ItemCardapio> getItensCardapio() {
		return itensCardapio;
	}

	public void setItensCardapio(List<ItemCardapio> itensCardapio) {
		this.itensCardapio = itensCardapio;
	}

	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}

	public float getQtdGrama() {
		float resultado = 0;
		for (ItemCardapio itemCardapio : this.itensCardapio) {
			if ((itemCardapio.getEnergiaAlimento().getAlimento().getClass().equals(AlimentoGranel.class))
					&& (((AlimentoGranel) itemCardapio.getEnergiaAlimento().getAlimento()).getUnidadeGranel()
							.equals(UnidadeGranel.g))) {
				resultado += itemCardapio.getQuantidade();
			}
		}
		return resultado;
	}

	public float getQtdLitro() {
		float resultado = 0;
		for (ItemCardapio itemCardapio : this.itensCardapio) {
			if ((itemCardapio.getEnergiaAlimento().getAlimento().getClass().equals(AlimentoGranel.class))
					&& (((AlimentoGranel) itemCardapio.getEnergiaAlimento().getAlimento()).getUnidadeGranel()
							.equals(UnidadeGranel.ml))) {
				resultado += itemCardapio.getQuantidade();
			}
		}
		return resultado;
	}

	public float getEnergia() {
		float resultado = 0;
		for (ItemCardapio itemCardapio : this.itensCardapio) {
			resultado += itemCardapio.getEnergia();
		}
		return resultado;

	}

	public Map<Substancia, Float> getParcial() {
		Map<Substancia, Float> resultado = new HashMap<Substancia, Float>();
		for (ItemCardapio itemCardapio : this.itensCardapio) {
			for (Map.Entry<Substancia, Float> substancia : itemCardapio.getSubstancias().entrySet()) {
				if (resultado.containsKey(substancia.getKey())) {
					resultado.put(substancia.getKey(), resultado.get(substancia.getKey()) + substancia.getValue());
				} else {
					resultado.put(substancia.getKey(), substancia.getValue());
				}
			}
		}
		return resultado;
	}
}
