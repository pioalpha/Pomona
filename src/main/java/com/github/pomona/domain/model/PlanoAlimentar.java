package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlanoAlimentar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3741333810586472811L;
	private PlanoAlimentarId planoAlimentarId;
	private Paciente paciente;
	private List<Consulta> consultas;
	private List<PerfilAlimentarPaciente> perfilAlimentarPaciente;

	public PlanoAlimentar() {
		super();

		this.consultas = new ArrayList<Consulta>();
		this.perfilAlimentarPaciente = new ArrayList<PerfilAlimentarPaciente>();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<PerfilAlimentarPaciente> getPerfilAlimentarPaciente() {
		return perfilAlimentarPaciente;
	}

	public void setPerfilAlimentarPaciente(List<PerfilAlimentarPaciente> perfilAlimentarPaciente) {
		this.perfilAlimentarPaciente = perfilAlimentarPaciente;
	}

	public PlanoAlimentarId planoAlimentarId() {
		return planoAlimentarId;
	}

	public void setPlanoAlimentarId(PlanoAlimentarId planoAlimentarId) {
		this.planoAlimentarId = planoAlimentarId;
	}

	@Override
	public String toString() {
		return "PlanoAlimentar [planoAlimentarId=" + planoAlimentarId + ", paciente=" + paciente + ", consultas="
				+ consultas + ", perfilAlimentarPaciente=" + perfilAlimentarPaciente + "]";
	}

}
