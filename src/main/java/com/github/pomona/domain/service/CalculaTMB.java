package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.List;

import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.FatorMetabolico;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.reference.TipoSexo;

public class CalculaTMB implements CalculaMeta {
	private static List<FatorMetabolico> fatoresMetabolicos = new ArrayList<FatorMetabolico>();

	public static List<FatorMetabolico> getFatoresMetabolicos() {
		return fatoresMetabolicos;
	}

	public static void setFatoresMetabolicos(List<FatorMetabolico> fatoresMetabolicos) {
		CalculaTMB.fatoresMetabolicos = fatoresMetabolicos;
	}

	public static Float calculaTMB(int idade, TipoSexo tipoSexo, float pesoAlvo) {
		Float resultado = null;

		for (FatorMetabolico fatorMetabolico : fatoresMetabolicos) {
			if ((fatorMetabolico.getIdadeMinima() == null || idade >= fatorMetabolico
					.getIdadeMinima())
					&& (fatorMetabolico.getIdadeMaxima() == null || idade < fatorMetabolico
							.getIdadeMaxima())) {
				if (tipoSexo.equals(TipoSexo.FEMININO)) {
					resultado = fatorMetabolico.getFatorFeminino() * pesoAlvo
							+ fatorMetabolico.getDiferencialFeminino();
				} else if (tipoSexo.equals(TipoSexo.MASCULINO)) {
					resultado = fatorMetabolico.getFatorMasculino() * pesoAlvo
							+ fatorMetabolico.getDiferencialMasculino();
				}

				break;
			}
		}

		return resultado;
	}

	@Override
	public float processaCalculo(Paciente paciente, Consulta consulta,
			float valorMeta) {
		
		//Se houver FatorAtividadeFisica setada, senão erro
		return CalculaREE.calculaREE(
				CalculaTMB.calculaTMB(paciente.getIdade(),
						paciente.getTipoSexo(), valorMeta),
				consulta.getFatorAtividadeFisica());
	}

}
