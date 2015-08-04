package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;

import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.model.PerfilAlimentarPaciente;
import com.github.pomona.domain.model.PlanoReeducacaoAlimentar;
import com.github.pomona.domain.reference.PreferenciaConsumo;
import com.github.pomona.domain.reference.TipoSexo;

public class PlanoReeducacaoAlimentarBuilder {
	private PlanoReeducacaoAlimentar instancia;
	
	public PlanoReeducacaoAlimentarBuilder(String nome, Date dataNascimento,
			float altura, TipoSexo tipoSexo){
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setDataNascimento(dataNascimento);
		paciente.setAltura(altura);
		paciente.setTipoSexo(tipoSexo);

		this.instancia = new PlanoReeducacaoAlimentar();
		this.instancia.setPaciente(paciente);
	}
	
	public PlanoReeducacaoAlimentarBuilder comPerfilAlimentar(AlimentoUnitario alimento,
			PreferenciaConsumo preferenciaConsumo){
		PerfilAlimentarPaciente perfilAlimentarPaciente = new PerfilAlimentarPaciente();
		perfilAlimentarPaciente.setAlimento(alimento);
		perfilAlimentarPaciente.setPreferenciaConsumo(preferenciaConsumo);
		perfilAlimentarPaciente.setPlanoReeducacaoAlimentar(this.instancia);
		perfilAlimentarPaciente.setDataCadastro(new Date());
		
		if (this.instancia.getPerfilAlimentarPaciente() == null){
			this.instancia.setPerfilAlimentarPaciente(new ArrayList<PerfilAlimentarPaciente>());
		}
		this.instancia.getPerfilAlimentarPaciente().add(perfilAlimentarPaciente);
		
		return this;
	}
	
	public PlanoReeducacaoAlimentar construir(){
		return this.instancia;
	}
}
