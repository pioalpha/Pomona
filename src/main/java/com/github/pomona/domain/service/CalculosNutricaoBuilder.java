package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;

import com.github.pomona.domain.model.ClassificacaoIMC;
import com.github.pomona.domain.model.FatorAtividadeFisica;
import com.github.pomona.domain.model.FatorMetabolico;

public class CalculosNutricaoBuilder {
	
	public CalculosNutricaoBuilder adicionarFatorAtividadeFisica(String atividade,
			float fator){
		FatorAtividadeFisica fatorAtividadeFisica = new FatorAtividadeFisica();
		fatorAtividadeFisica.setAtividade(atividade);
		fatorAtividadeFisica.setFator(fator);
		fatorAtividadeFisica.setDataCadastro(new Date());
		fatorAtividadeFisica.setDataRevogacao(null);
		
		if (CalculaREE.getFatoresAtividadeFisica() == null){
			CalculaREE.setFatoresAtividadeFisica(new ArrayList<FatorAtividadeFisica>());
		}
		
		CalculaREE.getFatoresAtividadeFisica().add(fatorAtividadeFisica);
		
		return this;
	}
	
	public CalculosNutricaoBuilder adicionarClassificacaoIMC(String situacao,
			Float imcMinimo, Float imcMaximo){
		ClassificacaoIMC classificacaoIMC = new ClassificacaoIMC();
		classificacaoIMC.setSituacao(situacao);
		classificacaoIMC.setImcMinimo(imcMinimo);
		classificacaoIMC.setImcMaximo(imcMaximo);
		
		if (CalculaIMC.getClassificacoesIMC() == null){
			CalculaIMC.setClassificacoesIMC(new ArrayList<ClassificacaoIMC>());
		}
		
		CalculaIMC.getClassificacoesIMC().add(classificacaoIMC);
		
		return this;
	}

	public CalculosNutricaoBuilder adicionarFatorMetabolico(Integer idadeMinima,
			Integer idadeMaxima, float fatorMasculino, int diferencialMasculino,
			float fatorFeminino, int diferencialFeminino){
		FatorMetabolico fatorMetabolico = new FatorMetabolico();
		fatorMetabolico.setIdadeMinima(idadeMinima);
		fatorMetabolico.setIdadeMaxima(idadeMaxima);
		fatorMetabolico.setFatorMasculino(fatorMasculino);
		fatorMetabolico.setDiferencialMasculino(diferencialMasculino);
		fatorMetabolico.setFatorFeminino(fatorFeminino);
		fatorMetabolico.setDiferencialFeminino(diferencialFeminino);
		fatorMetabolico.setDataCriacao(new Date());
		
		if (CalculaTMB.getFatoresMetabolicos() == null){
			CalculaTMB.setFatoresMetabolicos(new ArrayList<FatorMetabolico>());
		}
		
		CalculaTMB.getFatoresMetabolicos().add(fatorMetabolico);
		
		return this;
	}
	
	public void construir(){
		//return this.instancia;
	}
}
