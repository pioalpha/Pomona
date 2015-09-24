package com.github.pomona.application.paciente.command;

import java.util.Date;

import com.github.common.application.command.Command;
import com.github.pomona.domain.reference.TipoCorPele;
import com.github.pomona.domain.reference.TipoSexo;

public class CriarPlanoAlimentarDoPacienteCommand implements Command {
	private String nome;
	private Date dataNascimento;
	private TipoSexo tipoSexo;
	private TipoCorPele tipoCorPele;
	
	public CriarPlanoAlimentarDoPacienteCommand(String nome, Date dataNascimento, TipoSexo tipoSexo,
			TipoCorPele tipoCorPele) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tipoSexo = tipoSexo;
		this.tipoCorPele = tipoCorPele;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}
	
	public TipoCorPele getTipoCorPele() {
		return tipoCorPele;
	}
	
}
