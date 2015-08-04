package com.github.pomona.domain.reference;

import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.service.CalculaIMC;
import com.github.pomona.domain.service.CalculaMassaMagra;
import com.github.pomona.domain.service.CalculaMeta;
import com.github.pomona.domain.service.CalculaTMB;

public enum TipoMeta {
	CALORIA (null),
	PESO (new CalculaTMB()),
	IMC (new CalculaIMC()),
	MASSA_MAGRA (new CalculaMassaMagra());
	
	private CalculaMeta calculaMeta;
	
	TipoMeta (CalculaMeta calculaMeta){
		this.calculaMeta = calculaMeta;
	}
	
	public float caloriaAlvo(Paciente paciente, Consulta consulta, float valorMeta){
		if (this.calculaMeta == null){
			return valorMeta;
		} else {
			return calculaMeta.processaCalculo(paciente, consulta, valorMeta);
		}
	}
}
