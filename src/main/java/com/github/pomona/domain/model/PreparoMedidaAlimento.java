package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class PreparoMedidaAlimento extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 7604199331346021449L;

	@Embedded
	private PreparoMedidaAlimentoId preparoMedidaAlimentoId;
	@OneToOne
	@JoinColumn(nullable = false)
	private AlimentoGranel alimentoGranel;
	@OneToOne
	@JoinColumn(nullable = false)
	private TipoPreparo tipoPreparo;
	@OneToOne
	@JoinColumn(nullable = false)
	private TipoMedida tipoMedida;
	@Column(nullable = false, precision = 10, scale = 2)
	private float quantidade;

	public AlimentoGranel getAlimentoGranel() {
		return alimentoGranel;
	}

	public void setAlimentoGranel(AlimentoGranel alimentoGranel) {
		this.alimentoGranel = alimentoGranel;
	}

	public TipoPreparo getTipoPreparo() {
		return tipoPreparo;
	}

	public void setTipoPreparo(TipoPreparo tipoPreparo) {
		this.tipoPreparo = tipoPreparo;
	}

	public TipoMedida getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(TipoMedida tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public PreparoMedidaAlimentoId preparoMedidaAlimentoId() {
		return preparoMedidaAlimentoId;
	}

	public void setPreparoMedidaAlimentoId(PreparoMedidaAlimentoId preparoMedidaAlimentoId) {
		this.preparoMedidaAlimentoId = preparoMedidaAlimentoId;
	}

	@Override
	public String toString() {
		return "PreparoMedidaAlimento [preparoMedidaAlimentoId=" + preparoMedidaAlimentoId + ", alimentoGranel="
				+ alimentoGranel + ", tipoPreparo=" + tipoPreparo + ", tipoMedida=" + tipoMedida + ", quantidade="
				+ quantidade + "]";
	}

}
