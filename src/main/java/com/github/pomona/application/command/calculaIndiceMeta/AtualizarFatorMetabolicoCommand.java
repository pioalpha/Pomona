package com.github.pomona.application.command.calculaIndiceMeta;

import com.github.common.service.command.Command;

public class AtualizarFatorMetabolicoCommand implements Command {
	private String fatorMetabolicoId;
	private Integer idadeMinima;
	private Integer idadeMaxima;
	private float fatorFeminino;
	private int diferencialFeminino;
	private float fatorMasculino;
	private int diferencialMasculino;

	public AtualizarFatorMetabolicoCommand(String fatorMetabolicoId, Integer idadeMinima, Integer idadeMaxima,
			float fatorFeminino, int diferencialFeminino, float fatorMasculino, int diferencialMasculino) {
		super();
		this.fatorMetabolicoId = fatorMetabolicoId;
		this.idadeMinima = idadeMinima;
		this.idadeMaxima = idadeMaxima;
		this.fatorFeminino = fatorFeminino;
		this.diferencialFeminino = diferencialFeminino;
		this.fatorMasculino = fatorMasculino;
		this.diferencialMasculino = diferencialMasculino;
	}

	public String getFatorMetabolicoId() {
		return fatorMetabolicoId;
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
