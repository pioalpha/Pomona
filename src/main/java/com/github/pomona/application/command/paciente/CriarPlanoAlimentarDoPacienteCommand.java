package com.github.pomona.application.command.paciente;

import java.util.Date;

import com.github.pomona.domain.reference.TipoCorPele;
import com.github.pomona.domain.reference.TipoSexo;

public class CriarPlanoAlimentarDoPacienteCommand {
	private String nome;
	private Date dataNascimento;
	private float altura;
	private TipoSexo tipoSexo;
	private TipoCorPele tipoCorPele;
	
	public CriarPlanoAlimentarDoPacienteCommand(String nome, Date dataNascimento, float altura, TipoSexo tipoSexo,
			TipoCorPele tipoCorPele) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.altura = altura;
		this.tipoSexo = tipoSexo;
		this.tipoCorPele = tipoCorPele;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public float getAltura() {
		return altura;
	}
	
	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}
	
	public TipoCorPele getTipoCorPele() {
		return tipoCorPele;
	}
	
}
