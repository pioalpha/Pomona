package com.github.pomona.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class ApresentacaoMedidaAlimento extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 7604199331346021449L;

	@Embedded
	private ApresentacaoMedidaAlimentoId apresentacaoMedidaAlimentoId;
	@OneToOne
	@JoinColumn(nullable = false)
	private AlimentoGranel alimentoGranel;
	@OneToOne
	@JoinColumn(nullable = false)
	private TipoApresentacao tipoApresentacao;
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

	public TipoApresentacao getTipoApresentacao() {
		return tipoApresentacao;
	}

	public void setTipoApresentacao(TipoApresentacao tipoApresentacao) {
		this.tipoApresentacao = tipoApresentacao;
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

	public ApresentacaoMedidaAlimentoId apresentacaoMedidaAlimentoId() {
		return apresentacaoMedidaAlimentoId;
	}

	public void setApresentacaoMedidaAlimentoId(ApresentacaoMedidaAlimentoId apresentacaoMedidaAlimentoId) {
		this.apresentacaoMedidaAlimentoId = apresentacaoMedidaAlimentoId;
	}

	@Override
	public String toString() {
		return "ApresentacaoMedidaAlimento [apresentacaoMedidaAlimentoId=" + apresentacaoMedidaAlimentoId + ", alimentoGranel="
				+ alimentoGranel + ", tipoApresentacao=" + tipoApresentacao + ", tipoMedida=" + tipoMedida + ", quantidade="
				+ quantidade + "]";
	}

}
