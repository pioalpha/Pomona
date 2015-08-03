package com.github.pomona.domain.service;

import java.util.List;

import com.github.pomona.domain.model.FatorAtividadeFisica;

public class CalculaREE {
	private static List<FatorAtividadeFisica> fatoresAtividadeFisica;

	public static List<FatorAtividadeFisica> getFatoresAtividadeFisica() {
		return fatoresAtividadeFisica;
	}

	public static void setFatoresAtividadeFisica(
			List<FatorAtividadeFisica> fatoresAtividadeFisica) {
		CalculaREE.fatoresAtividadeFisica = fatoresAtividadeFisica;
	}
	
	public static Float calculaREE(float tmb, FatorAtividadeFisica fatorAtividadeFisica){
		Float resultado = null;
		
		if (fatorAtividadeFisica != null){
			resultado = tmb * fatorAtividadeFisica.getFator();
		}
			
		return resultado;
	}

}
