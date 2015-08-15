package com.github.pomona.domain.model;

import java.util.Date;

import com.github.common.domain.model.GenericoRepo;

public interface ConsultaRepo extends GenericoRepo<Consulta, ConsultaId> {
	public Consulta consultaPelaData(Date dataConsulta);
}
