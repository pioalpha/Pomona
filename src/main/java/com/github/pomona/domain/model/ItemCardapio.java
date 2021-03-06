package com.github.pomona.domain.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class ItemCardapio extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -2525537354397729187L;

	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)	
	private RefeicaoCardapio refeicaoCardapio;
	@NotNull
	@OneToOne
	@JoinColumn(nullable = false)
	private EnergiaAlimento energiaAlimento;
	@NotNull
	@DecimalMin(value = "0.01")
	@Column(nullable = false, precision = 10, scale = 2)
	private float quantidade;
	@OneToOne
	private TipoApresentacao tipoApresentacao;

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

	
	public TipoApresentacao getTipoApresentacao() {
		return tipoApresentacao;
	}

	public void setTipoApresentacao(TipoApresentacao tipoApresentacao) {
		this.tipoApresentacao = tipoApresentacao;
	}

	public float getEnergia() {
		return this.getEnergiaAlimento().getEnergia()
				/ energiaAlimento.getAlimento().fatorProporcao(this.quantidade);
	}

	public RefeicaoCardapio getRefeicaoCardapio() {
		return refeicaoCardapio;
	}

	public void setRefeicaoCardapio(RefeicaoCardapio refeicaoCardapio) {
		this.refeicaoCardapio = refeicaoCardapio;
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
