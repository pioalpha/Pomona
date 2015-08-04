package com.github.pomona.application.command.paciente;

public class AtualizarNomeDoPacienteCommand {
	private String idPlanoAlimentar;
	private String nome;

	public AtualizarNomeDoPacienteCommand(String idPlanoAlimentar, String nome) {
		super();
		this.idPlanoAlimentar = idPlanoAlimentar;
		this.nome = nome;
	}
	
	public String getIdPlanoAlimentar() {
		return idPlanoAlimentar;
	}
	
	public String getNome() {
		return nome;
	}
}
