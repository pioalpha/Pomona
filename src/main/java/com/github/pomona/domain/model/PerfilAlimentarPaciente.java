package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;

import com.github.pomona.domain.reference.PreferenciaConsumo;

public class PerfilAlimentarPaciente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9002796467378830586L;
	private PerfilAlimentarPacienteId perfilAlimentarPacienteId;
	private PreferenciaConsumo preferenciaConsumo;
	private Date dataCadastro;
	private AlimentoUnitario alimento;
	private CategoriaAlimento categoriaAlimento;
	private PlanoAlimentarId planoAlimentarId;

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

	public PlanoAlimentarId getPlanoAlimentarId() {
		return planoAlimentarId;
	}

	public void setPlanoAlimentarId(PlanoAlimentarId planoAlimentarId) {
		this.planoAlimentarId = planoAlimentarId;
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
				+ alimento + ", categoriaAlimento=" + categoriaAlimento + ", planoAlimentarId=" + planoAlimentarId + "]";
	}
	
	public PerfilAlimentarPacienteId perfilAlimentarPacienteId() {
		return perfilAlimentarPacienteId;
	}

	public void setPerfilAlimentarPacienteId(PerfilAlimentarPacienteId perfilAlimentarPacienteId) {
		this.perfilAlimentarPacienteId = perfilAlimentarPacienteId;
	}

}
