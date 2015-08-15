package com.github.pomona.application;

import java.util.Collection;

import com.github.common.service.query.Query;
import com.github.pomona.application.dto.AlimentoDTO;
import com.github.pomona.application.dto.AlimentoParametrosPesquisa;

public class AlimentoQueryService extends AbstractQueryService implements Query<AlimentoParametrosPesquisa, AlimentoDTO> {

	
	
	@Override
	public Collection<AlimentoDTO> Executar(AlimentoParametrosPesquisa parametros) {
		// TODO Auto-generated method stub
		return null;
		
		
	}

}
