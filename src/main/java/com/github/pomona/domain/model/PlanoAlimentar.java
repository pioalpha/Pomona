package com.github.pomona.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
@Table(indexes = {@Index(name = "plano_alimentar_idx", columnList = "uuid", unique = true) })
public class PlanoAlimentar extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -3741333810586472811L;

	@Embedded
	private PlanoAlimentarId planoAlimentarId;
	@NotNull
	@OneToOne
	@JoinColumn(nullable = false, unique = true)
	private Paciente paciente;
	@OneToMany(mappedBy = "planoAlimentar", cascade = CascadeType.ALL)
	private List<Consulta> consultas;

	public PlanoAlimentar() {
		super();

		this.consultas = new ArrayList<Consulta>();
	}
	
	public PlanoAlimentarId planoAlimentarId() {
		return planoAlimentarId;
	}

	public void setPlanoAlimentarId(PlanoAlimentarId planoAlimentarId) {
		this.planoAlimentarId = planoAlimentarId;
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

	@Override
	public String toString() {
		return "PlanoAlimentar [planoAlimentarId=" + planoAlimentarId + ", paciente=" + paciente + ", consultas="
				+ consultas + "]";
	}

}
