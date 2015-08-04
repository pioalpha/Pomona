package com.github.pomona.application.command.substancia;

public class AtualizarNomeDaSubstanciaCommand {
	private String idSubstancia;
	private String nome;
	
	public AtualizarNomeDaSubstanciaCommand(String idSubstancia, String nome) {
		super();
		this.idSubstancia = idSubstancia;
		this.nome = nome;
	}
	
	public String getIdSubstancia() {
		return idSubstancia;
	}
	
	public String getNome() {
		return nome;
	}
	
}
