package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class ItemCardapio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2525537354397729187L;
	private EnergiaAlimento energiaAlimento;
	private float quantidade;
	private TipoPreparo tipoPreparo;

	// private Map<Substancia, Float> proporcoes;

	public EnergiaAlimento getEnergiaAlimento() {
		return energiaAlimento;
	}

	public void setEnergiaAlimento(EnergiaAlimento energiaAlimento) {
		this.energiaAlimento = energiaAlimento;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	
	public TipoPreparo getTipoPreparo() {
		return tipoPreparo;
	}

	public void setTipoPreparo(TipoPreparo tipoPreparo) {
		this.tipoPreparo = tipoPreparo;
	}

	public float getEnergia() {
		return this.getEnergiaAlimento().getEnergia()
				/ energiaAlimento.getAlimento().fatorProporcao(this.quantidade);
	}

	public Map<Substancia, Float> getSubstancias() {
		Map<Substancia, Float> resultado = new HashMap<Substancia, Float>();
		for (ComponenteAlimentar componenteAlimentar : energiaAlimento
				.getAlimento().getComposicaoAlimentar()) {
			resultado.put(
					componenteAlimentar.getSubstancia(),
					componenteAlimentar.getQuantidade()
							/ energiaAlimento.getAlimento().fatorProporcao(
									this.quantidade));
		}
		return resultado;
	}
}
