package com.github.pomona.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.github.common.service.query.Query;
import com.github.common.util.ComparaDatas;
import com.github.pomona.application.dto.DivisaoParametrosPesquisa;
import com.github.pomona.application.dto.DivisaoRefeicaoDTO;
import com.github.pomona.application.dto.LimiteEnergeticoDTO;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.LimiteEnergetico;
import com.github.pomona.domain.reference.TipoRefeicao;

public class DivisaoQueryService implements Query<DivisaoParametrosPesquisa, DivisaoRefeicaoDTO> {

	@Inject
	private EntityManager manager;

	@Override
	public Collection<DivisaoRefeicaoDTO> Executar(DivisaoParametrosPesquisa parametros) {
		Collection<DivisaoRefeicaoDTO> resultado = new ArrayList<>();

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<DivisaoRefeicao> cq = cb.createQuery(DivisaoRefeicao.class);
		Root<DivisaoRefeicao> fromAlimento = cq.from(DivisaoRefeicao.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (parametros.getNome() != null) {
			predicates.add(cb.like(fromAlimento.<String> get("nome"), "%" + parametros.getNome() + "%"));
		}

		cq.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<DivisaoRefeicao> tq = manager.createQuery(cq);

		if (parametros.getNumeroResultadosPorPagina() != null) {
			tq.setFirstResult(parametros.getNumeroDaPagina() - 1);
			tq.setMaxResults(parametros.getNumeroResultadosPorPagina());
		}

		for (DivisaoRefeicao dr : tq.getResultList()) {
			Map<TipoRefeicao, LimiteEnergeticoDTO> limites = new HashMap<TipoRefeicao, LimiteEnergeticoDTO>();
			for (LimiteEnergetico le : dr.getLimitesEnergeticos()) {
				// Se tem data de consulta definida, pega a data, senão, pega a
				// data atual
				if (ComparaDatas.comparaApenasDatas(le.getDataCadastro(), parametros.getDataConsulta()) <= 0) {
					// se não tem a substancia cadastrada ou Se a substância já
					// cadastrada tem data inferior a nova, então cadastra
					if (!limites.containsKey(le.getTipoRefeicao()) || limites.get(le.getTipoRefeicao())
							.getDataCadastro().compareTo(le.getDataCadastro()) <= 0) {
						limites.put(le.getTipoRefeicao(), new LimiteEnergeticoDTO(le.getDataCadastro(),
								le.getTipoRefeicao(), le.getPercentualEnergetico(), le.getTolerancia()));
					}
				}
			}
			DivisaoRefeicaoDTO d = new DivisaoRefeicaoDTO(parametros.getDataConsulta(), dr.divisaoRefeicaoId().uuid(),
					dr.getNome(), limites.values());
			resultado.add(d);
		}

		return resultado;
	}

}
