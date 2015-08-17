package com.github.pomona;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.common.domain.model.AbstractId;
import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.ConsultaId;
import com.github.pomona.domain.model.ConsultaRepo;

public class ConsultaRepoImpl implements ConsultaRepo {
	private Map<ConsultaId, Consulta> repo = new HashMap<ConsultaId, Consulta>();

	@Override
	public void adicionar(Consulta umObjeto) {
		repo.put(umObjeto.consultaId(), umObjeto);
	}

	@Override
	public Collection<Consulta> todosObjetos() {
		return repo.values();
	}

	@Override
	public void remover(Consulta umObjeto) {
		repo.remove(umObjeto.consultaId());
	}

	@Override
	public Consulta consultaPelaData(Date dataConsulta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulta objetoDeId(AbstractId umaId) {
		return repo.get(umaId);
	}

	@Override
	public ConsultaId proximaIdentidade() {
		ConsultaId consultaId = null;
		do{
			consultaId = new ConsultaId(UUID.randomUUID().toString().toUpperCase());
		}while(repo.containsKey(consultaId));
		return consultaId;
	}

}
