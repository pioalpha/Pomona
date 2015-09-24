package com.github.pomona.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class ApresentacaoMedidaAlimento extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 7604199331346021449L;

	@Embedded
	private ApresentacaoMedidaAlimentoId apresentacaoMedidaAlimentoId;
	@NotNull
	@OneToOne
	@JoinColumn(nullable = false)
	private AlimentoGranel alimentoGranel;
	@NotNull
	@OneToOne
	@JoinColumn(nullable = false)
	private TipoApresentacao tipoApresentacao;
	@NotNull
	@OneToOne
	@JoinColumn(nullable = false)
	private TipoMedida tipoMedida;
	@DecimalMin(value = "0.01")
	@Column(nullable = true, precision = 10, scale = 2)
	private Float quantidade;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "ApresentacaoMedidaAlimento [apresentacaoMedidaAlimentoId=" + apresentacaoMedidaAlimentoId + ", alimentoGranel="
				+ alimentoGranel + ", tipoApresentacao=" + tipoApresentacao + ", tipoMedida=" + tipoMedida + ", quantidade="
				+ quantidade + "]";
	}

}
