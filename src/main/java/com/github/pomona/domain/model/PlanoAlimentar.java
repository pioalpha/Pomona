package com.github.pomona.domain.model;

import java.io.Serializable;
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

	@Override
	public String toString() {
		return new StringBuilder().append(">PACIENTE\n").append(paciente.toString()).append("\n>PERFIL ALIMENTAR\n")
				.append(perfilAlimentarPaciente.toString()).append("\n>CONSULTAS\n").append(consultas.toString())
				.toString();
	}

	public PlanoAlimentarId planoAlimentarId() {
		return planoAlimentarId;
	}

	public void setPlanoAlimentarId(PlanoAlimentarId planoAlimentarId) {
		this.planoAlimentarId = planoAlimentarId;
	}
}
