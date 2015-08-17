package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.github.pomona.domain.reference.TipoCorPele;
import com.github.pomona.domain.reference.TipoSexo;

public class Paciente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8683824728292662068L;
	private PacienteId pacienteId;
	private TipoSexo tipoSexo;
	private TipoCorPele tipoCorPele;
	private String nome;
	private Date dataNascimento;

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

	public PacienteId pacienteId() {
		return pacienteId;
	}

	public void setPacienteId(PacienteId pacienteId) {
		this.pacienteId = pacienteId;
	}

	public TipoCorPele getTipoCorPele() {
		return tipoCorPele;
	}

	public void setTipoCorPele(TipoCorPele tipoCorPele) {
		this.tipoCorPele = tipoCorPele;
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
				+ ", nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
	}

	public String getDetalhes() {
		return new StringBuilder().append("Nome: " + nome + "\n").append("Nascimento: " + dataNascimento + "\n")
				.append("Idade: " + this.getIdade() + "\n").append("Sexo: " + tipoSexo).toString();
	}
}
