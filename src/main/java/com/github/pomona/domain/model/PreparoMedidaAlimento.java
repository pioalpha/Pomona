package com.github.pomona.domain.model;

public class PreparoMedidaAlimento {
	private PreparoMedidaAlimentoId preparoMedidaAlimentoId;
	private AlimentoGranel alimentoGranel;
	private TipoPreparo tipoPreparo;
	private TipoMedida tipoMedida;
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

}
