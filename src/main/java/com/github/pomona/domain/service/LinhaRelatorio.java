package com.github.pomona.domain.service;

import java.util.HashMap;
import java.util.Map;

import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.reference.TipoRefeicao;

public class LinhaRelatorio {
	private TipoLinha tipoLinha; // Alimento, Parcial, Total
	private Float quantidade;
	private AlimentoUnitario alimento;
	private Map<Substancia, Float> substancias;
	private TipoRefeicao tipoRefeicao;
	private float energia;
	private float totalDiretriz;

	public LinhaRelatorio(AlimentoUnitario alimento, float quantidade, TipoRefeicao tipoRefeicao) {
		this(tipoRefeicao);
		this.alimento = alimento;
		this.quantidade = quantidade;
		this.tipoLinha = TipoLinha.ALIMENTO;
	}

	public LinhaRelatorio(TipoRefeicao tipoRefeicao) {
		this();
		this.tipoRefeicao = tipoRefeicao;
		this.tipoLinha = TipoLinha.PARCIAL;
	}

	public LinhaRelatorio() {
		substancias = new HashMap<Substancia, Float>();
		this.energia = 0;
		this.tipoLinha = TipoLinha.TOTAL;
	}

	public LinhaRelatorio comSubstancia(Substancia substancia, float quantidade) {
		if (this.substancias.containsKey(substancia)) {
			this.substancias.put(substancia, this.substancias.get(substancia) + quantidade);
		} else {
			this.substancias.put(substancia, quantidade);
		}
		return this;
	}

	public LinhaRelatorio comEnergia(float energia) {
		this.energia = this.energia + energia;
		return this;
	}

	public TipoLinha getTipoLinha() {
		return tipoLinha;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public AlimentoUnitario getAlimento() {
		return alimento;
	}

	public Map<Substancia, Float> getSubstancias() {
		return substancias;
	}

	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}

	public float getEnergia() {
		return energia;
	}

	public float getTotalDiretriz() {
		return totalDiretriz;
	}

	@Override
	public String toString() {
		StringBuilder sbTitulo = new StringBuilder();
		StringBuilder sbLinha = new StringBuilder();

		if (this.tipoLinha.equals(TipoLinha.ALIMENTO)) {
			sbTitulo.append("Qtd Alimento");
			sbLinha.append(this.quantidade).append(" " + this.alimento.getNome());
		} else {
			sbTitulo.append("Totalização");
			sbLinha.append(this.tipoLinha);
		}
		for (Map.Entry<Substancia, Float> entrada : substancias.entrySet()) {
			sbTitulo.append(" " + entrada.getKey().getNome() + "(" + entrada.getKey().getUnidadeSubstancia() + ")");
			sbLinha.append(" " + entrada.getValue());
		}
		if (this.tipoLinha.equals(TipoLinha.ALIMENTO) || this.tipoLinha.equals(TipoLinha.PARCIAL)) {
			sbTitulo.append(" TipoRefeição");
			sbLinha.append(" " + this.tipoRefeicao);
		}

		sbTitulo.append(" Energia");
		sbLinha.append(" " + this.energia);

		sbTitulo.append("\n").append(sbLinha);

		return sbTitulo.toString();
	}
}
