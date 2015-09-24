package com.github.pomona.application;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.github.common.service.query.Query;
import com.github.pomona.application.dto.SubstanciaDTO;
import com.github.pomona.application.dto.SubstanciaParametrosPesquisa;

@RequestScoped
public class SubstanciaQueryService implements Query<SubstanciaParametrosPesquisa, SubstanciaDTO> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	public List<SubstanciaDTO> Executar(SubstanciaParametrosPesquisa parametros) {
		List<SubstanciaDTO> resultado = new ArrayList<>();

		/*CriteriaBuilder cb = manager.getCriteriaBuilder();
		
		 * CriteriaQuery<EnergiaSubstancia> cq =
		 * cb.createQuery(EnergiaSubstancia.class); Root<EnergiaSubstancia>
		 * fromEnergiaSubstancia = cq.from(EnergiaSubstancia.class);
		 * 
		 * Join<EnergiaSubstancia, Substancia> fromSubstancia =
		 * fromEnergiaSubstancia.join("substancia", JoinType.LEFT);
		 */

		/*
		 * CriteriaQuery<EnergiaSubstancia> cq =
		 * cb.createQuery(EnergiaSubstancia.class); Root<Substancia>
		 * fromSubstancia = cq.from(Substancia.class);
		 * 
		 * Join<EnergiaSubstancia, Substancia> fromEnergiaSubstancia =
		 * fromSubstancia.join("id", JoinType.LEFT);
		 */

		String where = "";
		if (parametros.getNome() != null) {
			where = where + " AND s.nome LIKE '" + parametros.getNome() + "'";
		}

		// TypedQuery<SubstanciaDTO> tq = manager.createQuery("SELECT NEW
		// com.github.pomona.application.dto.SubstanciaDTO(s.substanciaId.uuid,
		// s.nome, s.ordem, s.unidadeSubstancia, es.fatorEnergetico,
		// es.dataCadastro) FROM Substancia AS s LEFT JOIN
		// com.github.pomona.domain.model.EnergiaSubstancia AS es ON s.id =
		// es.substancia_id", SubstanciaDTO.class);
		// http://uniqueexperiments.blogspot.com.br/2014/05/this-is-my-account-of-programming.html
		// TypedQuery<SubstanciaDTO> tq = manager.createQuery("SELECT NEW
		// com.github.pomona.application.dto.SubstanciaDTO(s.substanciaId.uuid,
		// s.nome, s.ordem, s.unidadeSubstancia, es.fatorEnergetico,
		// es.dataCadastro) FROM EnergiaSubstancia AS es RIGHT JOIN
		// es.substancia AS s", SubstanciaDTO.class);
		TypedQuery<SubstanciaDTO> tq = manager.createQuery(
				"SELECT NEW com.github.pomona.application.dto.SubstanciaDTO("
				+ "s.substanciaId.uuid, s.nome, s.ordem, s.unidadeSubstancia,"
				+ " es.fatorEnergetico, es.dataCadastro)"
				+ " FROM EnergiaSubstancia AS es"
				+ " RIGHT JOIN es.substancia AS s"
				+ " WHERE (es.dataCadastro IS NULL OR es.dataCadastro ="
					+ " (SELECT MAX(es2.dataCadastro)"
					+ " FROM EnergiaSubstancia AS es2"
					+ " WHERE es2.dataCadastro <= :dataConsulta "
					+ " AND es2.substancia = es.substancia"
					+ " GROUP BY es2.substancia)"
				+ ")" + where,
				SubstanciaDTO.class);
		System.out.println("DataConsulta: " + parametros.getDataConsulta()  + " (" + parametros.getDataConsulta().getTime() + ")");
		tq.setParameter("dataConsulta", parametros.getDataConsulta(), TemporalType.TIMESTAMP);
		/*
		 * CriteriaQuery<SubstanciaDTO> cq =
		 * cb.createQuery(SubstanciaDTO.class); Root<Substancia> fromSubstancia
		 * = cq.from(Substancia.class); Root<EnergiaSubstancia>
		 * fromEnergiaSubstancia = cq.from(EnergiaSubstancia.class);
		 */

		// Join<Substancia, EnergiaSubstancia> fromEnergiaSubstancia =
		// fromSubstancia.join("id", JoinType.LEFT);

		/*
		 * cq.select(cb.construct(SubstanciaDTO.class,
		 * fromSubstancia.get("substanciaId").get("uuid"),
		 * fromSubstancia.get("nome"), fromSubstancia.get("ordem"),
		 * fromSubstancia.get("unidadeSubstancia"),
		 * fromEnergiaSubstancia.get("fatorEnergetico"),
		 * fromEnergiaSubstancia.get("dataCadastro") ));
		 */

		/*
		 * List<Predicate> predicates = new ArrayList<Predicate>(); if
		 * (parametros.getNome() != null) {
		 * predicates.add(cb.like(fromSubstancia.<String> get("nome"),
		 * parametros.getNome())); }
		 * 
		 * if (!predicates.isEmpty()){ cq.where(predicates.toArray(new
		 * Predicate[] {})); }
		 */
		// TypedQuery<EnergiaSubstancia> tq = manager.createQuery(cq);
		// TypedQuery<SubstanciaDTO> tq = manager.createQuery(cq);

		if (parametros.getNumeroResultadosPorPagina() != null) {
			tq.setFirstResult(parametros.getNumeroDaPagina() - 1);
			tq.setMaxResults(parametros.getNumeroResultadosPorPagina());
		}

		/*
		 * Map<SubstanciaId, SubstanciaDTO> energiasSubstancia = new
		 * HashMap<SubstanciaId, SubstanciaDTO>(); for (EnergiaSubstancia es :
		 * tq.getResultList()) { if
		 * (ComparaDatas.comparaApenasDatas(es.getDataCadastro(),
		 * parametros.getDataConsulta()) <= 0) { if
		 * (!energiasSubstancia.containsKey(es.getSubstancia().substanciaId())
		 * || energiasSubstancia.get(es.getSubstancia().substanciaId()).
		 * getDataCadastroFator() .compareTo(es.getDataCadastro()) <= 0) {
		 * energiasSubstancia.put(es.getSubstancia().substanciaId(), new
		 * SubstanciaDTO(es.getSubstancia().substanciaId().uuid(),
		 * es.getSubstancia().getNome(), es.getSubstancia().getOrdem(),
		 * es.getSubstancia().getUnidadeSubstancia(), es.getFatorEnergetico(),
		 * es.getDataCadastro())); } } }
		 * resultado.addAll(energiasSubstancia.values());
		 */
		resultado.addAll(tq.getResultList());

		return resultado;
	}

}
