package com.github.pomona.application;

import java.util.Collection;

import javax.sql.DataSource;

import com.github.common.port.adapter.persistence.AbstractQueryService;
import com.github.common.service.query.Query;
import com.github.pomona.application.dto.AlimentoDTO;
import com.github.pomona.application.dto.AlimentoParametrosPesquisa;

public class AlimentoQueryService extends AbstractQueryService
		implements Query<AlimentoParametrosPesquisa, AlimentoDTO> {

	public AlimentoQueryService(DataSource aDataSource) {
		super(aDataSource);
	}

	@Override
	public Collection<AlimentoDTO> Executar(AlimentoParametrosPesquisa parametros) {
		return this.queryObjects(AlimentoDTO.class, "select * from tbl_alimento", null, Object[].class);
	}

}
