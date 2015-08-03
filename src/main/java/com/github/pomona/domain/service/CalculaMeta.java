package com.github.pomona.domain.service;

import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.Paciente;

public interface CalculaMeta {
	public float processaCalculo(Paciente paciente, Consulta consulta, float valorMeta);
}
