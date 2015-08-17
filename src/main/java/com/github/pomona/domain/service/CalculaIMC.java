package com.github.pomona.domain.service;

import java.util.List;

import com.github.pomona.domain.model.ClassificacaoIMC;
import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.Paciente;

public class CalculaIMC implements CalculaMeta {
	private static List<ClassificacaoIMC> classificacoesIMC;

	public static List<ClassificacaoIMC> getClassificacoesIMC() {
		return classificacoesIMC;
	}

	public static void setClassificacoesIMC(
			List<ClassificacaoIMC> classificacoesIMC) {
		CalculaIMC.classificacoesIMC = classificacoesIMC;
	}

	public static float calculaIMC(float peso, float altura) {
		return (float) (peso / Math.pow(altura, 2));
	}

	public static float calculaIMCReverso(float imcAlvo, float altura) {
		float resultado = (float) (imcAlvo * Math.pow(altura, 2));
		System.out.println(resultado);
		return resultado;
	}

	@Override
	public float processaCalculo(Paciente paciente, Consulta consulta,
			float valorMeta) {
		return new CalculaTMB().processaCalculo(paciente, consulta,
				CalculaIMC.calculaIMCReverso(valorMeta, consulta.getExameAntropometrico().getAltura()));
	}
}
