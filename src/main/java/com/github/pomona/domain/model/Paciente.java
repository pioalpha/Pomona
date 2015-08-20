package com.github.pomona.domain.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.github.common.domain.model.ConcurrencySafeEntity;
import com.github.pomona.domain.reference.TipoCorPele;
import com.github.pomona.domain.reference.TipoSexo;

@Entity
public class Paciente extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 8683824728292662068L;
	
	@Embedded
	private PacienteId pacienteId;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private TipoSexo tipoSexo;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private TipoCorPele tipoCorPele;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@Transient
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<PerfilAlimentarPaciente> perfilAlimentarPaciente;

	public Paciente() {
		super();

		this.perfilAlimentarPaciente = new ArrayList<PerfilAlimentarPaciente>();
	}

	public PacienteId pacienteId() {
		return pacienteId;
	}

	@Override
	public long id() {
		return super.id();
	}

	public void setPacienteId(PacienteId pacienteId) {
		this.pacienteId = pacienteId;
	}

	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(TipoSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public TipoCorPele getTipoCorPele() {
		return tipoCorPele;
	}

	public void setTipoCorPele(TipoCorPele tipoCorPele) {
		this.tipoCorPele = tipoCorPele;
	}

	public List<PerfilAlimentarPaciente> getPerfilAlimentarPaciente() {
		return perfilAlimentarPaciente;
	}

	public void setPerfilAlimentarPaciente(List<PerfilAlimentarPaciente> perfilAlimentarPaciente) {
		this.perfilAlimentarPaciente = perfilAlimentarPaciente;
	}

	@Override
	public int hashCode() {
		final int prime = 193;
		int result = 2061;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pacienteId == null) ? 0 : pacienteId.hashCode());
		result = prime * result + ((tipoCorPele == null) ? 0 : tipoCorPele.hashCode());
		result = prime * result + ((tipoSexo == null) ? 0 : tipoSexo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pacienteId == null) {
			if (other.pacienteId != null)
				return false;
		} else if (!pacienteId.equals(other.pacienteId))
			return false;
		if (tipoCorPele != other.tipoCorPele)
			return false;
		if (tipoSexo != other.tipoSexo)
			return false;
		return true;
	}

	public int getIdade() {
		Calendar nascimento = new GregorianCalendar();
		nascimento.setTime(this.dataNascimento);
		Calendar hoje = Calendar.getInstance();
		int idade = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);

		nascimento.add(Calendar.YEAR, idade);

		if (hoje.before(nascimento)) {
			idade--;
		}

		return idade;
	}

	@Override
	public String toString() {
		return "Paciente [pacienteId=" + pacienteId + ", tipoSexo=" + tipoSexo + ", tipoCorPele=" + tipoCorPele
				+ ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", perfilAlimentarPaciente=" + perfilAlimentarPaciente + "]";
	}

	public String getDetalhes() {
		return new StringBuilder().append("Nome: " + nome + "\n").append("Nascimento: " + dataNascimento + "\n")
				.append("Idade: " + this.getIdade() + "\n").append("Sexo: " + tipoSexo).toString();
	}
}
