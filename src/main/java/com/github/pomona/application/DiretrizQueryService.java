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
import com.github.pomona.application.dto.DiretrizAlimentarDTO;
import com.github.pomona.application.dto.DiretrizParametrosPesquisa;
import com.github.pomona.application.dto.NormaAlimentarDTO;
import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.NormaAlimentar;
import com.github.pomona.domain.model.SubstanciaId;

public class DiretrizQueryService implements Query<DiretrizParametrosPesquisa, DiretrizAlimentarDTO> {

	@Inject
	private EntityManager manager;

	@Override
	public List<DiretrizAlimentarDTO> Executar(DiretrizParametrosPesquisa parametros) {
		List<DiretrizAlimentarDTO> resultado = new ArrayList<>();

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<DiretrizAlimentar> cq = cb.createQuery(DiretrizAlimentar.class);
		Root<DiretrizAlimentar> fromAlimento = cq.from(DiretrizAlimentar.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (parametros.getNome() != null) {
			predicates.add(cb.like(fromAlimento.<String> get("nome"), "%" + parametros.getNome() + "%"));
		}
		if (!parametros.incluirDesativados()) {
			predicates.add(cb.isNull(fromAlimento.get("dataRevogacao")));
		}

		cq.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<DiretrizAlimentar> tq = manager.createQuery(cq);

		if (parametros.getNumeroResultadosPorPagina() != null) {
			tq.setFirstResult(parametros.getNumeroDaPagina() - 1);
			tq.setMaxResults(parametros.getNumeroResultadosPorPagina());
		}

		for (DiretrizAlimentar da : tq.getResultList()) {
			Map<SubstanciaId, NormaAlimentarDTO> normas = new HashMap<SubstanciaId, NormaAlimentarDTO>();
			for (NormaAlimentar na : da.getNormasAlimentares()) {
				// Se tem data de consulta definida, pega a data, senão, pega a
				// data atual
				if (ComparaDatas.comparaApenasDatas(na.getDataCriacao(), parametros.getDataConsulta()) <= 0) {
					// se não tem a substancia cadastrada ou Se a substância já
					// cadastrada tem data inferior a nova, então cadastra
					if (!normas.containsKey(na.getSubstancia().substanciaId())
							|| normas.get(na.getSubstancia().substanciaId()).getDataCriacao()
									.compareTo(na.getDataCriacao()) <= 0) {
						normas.put(na.getSubstancia().substanciaId(),
								new NormaAlimentarDTO(na.getDataCriacao(), na.getNormaMinima(), na.getNormaMaxima(),
										na.getTipoNorma(), na.getSubstancia().substanciaId().uuid(),
										na.getSubstancia().getNome(), na.getSubstancia().getUnidadeSubstancia()));
					}
				}
			}
			DiretrizAlimentarDTO d = new DiretrizAlimentarDTO(parametros.getDataConsulta(),	da.diretrizAlimentarId().uuid(), da.getNome(), da.getDataRevogacao(), normas.values());
			resultado.add(d);
		}

		return resultado;
	}

}
