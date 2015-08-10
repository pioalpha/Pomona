package com.github.pomona.domain.model;

import java.util.Collection;
import java.util.Date;

public interface ConsultaRepo {
    public void add(Consulta consulta);

    public Collection<Consulta> todasConsultas();

    public void remove(Consulta consulta);

    public Consulta consultaPelaData(Date dataConsulta);
}
