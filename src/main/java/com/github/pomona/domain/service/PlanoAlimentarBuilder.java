package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;

import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.model.PerfilAlimentarPaciente;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.reference.PreferenciaConsumo;
import com.github.pomona.domain.reference.TipoSexo;

public class PlanoAlimentarBuilder {
	private PlanoAlimentar instancia;
	
	public PlanoAlimentarBuilder(String nome, Date dataNascimento,
			TipoSexo tipoSexo){
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setDataNascimento(dataNascimento);
		paciente.setTipoSexo(tipoSexo);

		this.instancia = new PlanoAlimentar();
		this.instancia.setPaciente(paciente);
	}
	
	public PlanoAlimentarBuilder comPerfilAlimentar(AlimentoUnitario alimento,
			PreferenciaConsumo preferenciaConsumo){
		PerfilAlimentarPaciente perfilAlimentarPaciente = new PerfilAlimentarPaciente();
		perfilAlimentarPaciente.setAlimento(alimento);
		perfilAlimentarPaciente.setPreferenciaConsumo(preferenciaConsumo);
		perfilAlimentarPaciente.setPaciente(this.instancia.getPaciente());
		perfilAlimentarPaciente.setDataCadastro(new Date());
		
		if (this.instancia.getPaciente().getPerfilAlimentarPaciente() == null){
			this.instancia.getPaciente().setPerfilAlimentarPaciente(new ArrayList<PerfilAlimentarPaciente>());
		}
		this.instancia.getPaciente().getPerfilAlimentarPaciente().add(perfilAlimentarPaciente);
		
		return this;
	}
	
	public PlanoAlimentar construir(){
		return this.instancia;
	}
}
