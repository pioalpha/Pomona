package com.github.pomona.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;
import com.github.pomona.domain.reference.PreferenciaConsumo;

@Entity
public class PerfilAlimentarPaciente extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -9002796467378830586L;
	
	@Embedded
	private PerfilAlimentarPacienteId perfilAlimentarPacienteId;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private PreferenciaConsumo preferenciaConsumo;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataCadastro;
	@OneToOne
	private AlimentoUnitario alimento;
	@OneToOne
	private CategoriaAlimento categoriaAlimento;
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private Paciente paciente;

	public PreferenciaConsumo getPreferenciaConsumo() {
		return preferenciaConsumo;
	}

	public void setPreferenciaConsumo(PreferenciaConsumo preferenciaConsumo) {
		this.preferenciaConsumo = preferenciaConsumo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public AlimentoUnitario getAlimento() {
		return alimento;
	}

	public void setAlimento(AlimentoUnitario alimento) {
		this.alimento = alimento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public CategoriaAlimento getCategoriaAlimento() {
		return categoriaAlimento;
	}

	public void setCategoriaAlimento(CategoriaAlimento categoriaAlimento) {
		this.categoriaAlimento = categoriaAlimento;
	}

	@Override
	public String toString() {
		return "PerfilAlimentarPaciente [perfilAlimentarPacienteId=" + perfilAlimentarPacienteId
				+ ", preferenciaConsumo=" + preferenciaConsumo + ", dataCadastro=" + dataCadastro + ", alimento="
				+ alimento + ", categoriaAlimento=" + categoriaAlimento + ", paciente=" + paciente.getNome() + "]";
	}
	
	public PerfilAlimentarPacienteId perfilAlimentarPacienteId() {
		return perfilAlimentarPacienteId;
	}

	public void setPerfilAlimentarPacienteId(PerfilAlimentarPacienteId perfilAlimentarPacienteId) {
		this.perfilAlimentarPacienteId = perfilAlimentarPacienteId;
	}

}
