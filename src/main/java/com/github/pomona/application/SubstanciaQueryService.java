package com.github.pomona.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.github.common.service.query.Query;
import com.github.pomona.application.dto.SubstanciaDTO;
import com.github.pomona.application.dto.SubstanciaParametrosPesquisa;
import com.github.pomona.domain.model.Substancia;

public class SubstanciaQueryService implements Query<SubstanciaParametrosPesquisa, SubstanciaDTO> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public List<SubstanciaDTO> Executar(SubstanciaParametrosPesquisa parametros) {
		List<SubstanciaDTO> resultado = new ArrayList<>();

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Substancia> cq = cb.createQuery(Substancia.class);
		Root<Substancia> fromSubstancia = cq.from(Substancia.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (parametros.getNome() != null) {
			predicates.add(cb.like(fromSubstancia.<String> get("nome"), "%" + parametros.getNome() + "%"));
		}

		cq.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<Substancia> tq = manager.createQuery(cq);

		if (parametros.getNumeroResultadosPorPagina() != null) {
			tq.setFirstResult(parametros.getNumeroDaPagina() - 1);
			tq.setMaxResults(parametros.getNumeroResultadosPorPagina());
		}

		for (Substancia s : tq.getResultList()) {
			SubstanciaDTO sDTO = new SubstanciaDTO(s.substanciaId().uuid(), s.getNome(), s.getOrdem(),
					s.getUnidadeSubstancia());
			resultado.add(sDTO);
		}

		return resultado;
	}

}
