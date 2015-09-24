package com.github.pomona.application.calculaIndiceMeta.command;

import com.github.common.application.command.Command;

public class CadastrarFatorMetabolicoCommand implements Command {
	private Integer idadeMinima;
	private Integer idadeMaxima;
	private float fatorFeminino;
	private int diferencialFeminino;
	private float fatorMasculino;
	private int diferencialMasculino;

	public CadastrarFatorMetabolicoCommand(Integer idadeMinima, Integer idadeMaxima, float fatorFeminino,
			int diferencialFeminino, float fatorMasculino, int diferencialMasculino) {
		super();
		this.idadeMinima = idadeMinima;
		this.idadeMaxima = idadeMaxima;
		this.fatorFeminino = fatorFeminino;
		this.diferencialFeminino = diferencialFeminino;
		this.fatorMasculino = fatorMasculino;
		this.diferencialMasculino = diferencialMasculino;
	}

	public Integer getIdadeMinima() {
		return idadeMinima;
	}

	public Integer getIdadeMaxima() {
		return idadeMaxima;
	}

	public float getFatorFeminino() {
		return fatorFeminino;
	}

	public int getDiferencialFeminino() {
		return diferencialFeminino;
	}

	public float getFatorMasculino() {
		return fatorMasculino;
	}

	public int getDiferencialMasculino() {
		return diferencialMasculino;
	}

}
