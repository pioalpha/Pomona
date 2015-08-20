package com.github.pomona.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class ComponenteAlimentar extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -2722189674707674291L;

	@ManyToOne
	@JoinColumn(nullable = false)
	private AlimentoUnitario alimentoUnitario;
	@Column(nullable = false, precision = 10, scale = 3)
	private float quantidade;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataCadastro;
	@OneToOne
	@JoinColumn(nullable = false)
	private Substancia substancia;

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Substancia getSubstancia() {
		return substancia;
	}

	public void setSubstancia(Substancia substancia) {
		this.substancia = substancia;
	}

	@Override
	public String toString() {
		return "ComponenteAlimentar [quantidade=" + quantidade + ", dataCadastro=" + dataCadastro + ", substancia="
				+ substancia + "]";
	}

}
