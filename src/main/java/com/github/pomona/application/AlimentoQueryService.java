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
import com.github.pomona.application.dto.AlimentoDTO;
import com.github.pomona.application.dto.AlimentoParametrosPesquisa;
import com.github.pomona.application.dto.ComponenteAlimentarDTO;
import com.github.pomona.application.dto.MedidaDTO;
import com.github.pomona.application.dto.MedidaParametrosPesquisa;
import com.github.pomona.application.dto.PreparoDTO;
import com.github.pomona.application.dto.PreparoMedidaAlimentoDTO;
import com.github.pomona.application.dto.PreparoMedidaParametrosPesquisa;
import com.github.pomona.application.dto.PreparoParametrosPesquisa;
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.ComponenteAlimentar;
import com.github.pomona.domain.model.PreparoMedidaAlimento;
import com.github.pomona.domain.model.SubstanciaId;
import com.github.pomona.domain.model.TipoMedida;
import com.github.pomona.domain.model.TipoPreparo;

public class AlimentoQueryService // extends AbstractQueryService
		implements Query<AlimentoParametrosPesquisa, AlimentoDTO> {

	@Inject
	private EntityManager manager;

	// public AlimentoQueryService(DataSource aDataSource) {
	// super(aDataSource);
	// }

	@Override
	public Collection<AlimentoDTO> Executar(AlimentoParametrosPesquisa parametros) {
		// http://www.baeldung.com/jpa-pagination
		Collection<AlimentoDTO> resultado = new ArrayList<>();

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<AlimentoGranel> cq = cb.createQuery(AlimentoGranel.class);
		// cq.select(cq.from(AlimentoGranel.class));
		Root<AlimentoGranel> fromAlimento = cq.from(AlimentoGranel.class);
		// Root<ComponenteAlimentar> fromComponente =
		// cq.from(ComponenteAlimentar.class);
		// Metamodel m = manager.getMetamodel();
		// EntityType<AlimentoGranel> AlimentoGranel_ =
		// m.entity(AlimentoGranel.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		// Predicate predicate;// = cb.and();
		// Predicate predicate2 = cb.and();
		if (parametros.getNome() != null) {
			predicates.add(cb.like(fromAlimento.<String> get("nome"), "%" + parametros.getNome() + "%"));
			// cq.where(cb.and(predicate,
			// cb.like(fromAlimento.<String>get("nome"), "%" +
			// parametros.getNome() + "%")));
		}
		if (parametros.getCategoria() != null) {
			predicates.add(cb.like(fromAlimento.join("categoriaAlimento").<String> get("nome"),
					"%" + parametros.getCategoria() + "%"));
			// cq.where(cb.and(predicate,
			// cb.like(fromAlimento.join("categoriaAlimento").<String>get("nome"),
			// "%" + parametros.getCategoria() + "%")));
			// Join<AlimentoGranel, CategoriaAlimento> categoria =
			// fromAlimento.join("categoriaAlimento");
			// cq.where(cb.and(predicate, cb.like(categoria.<String>get("nome"),
			// "%" + parametros.getCategoria() + "%")));
		}
		// Root<PreparoMedidaAlimento> fromPreparo =
		// cq.from(PreparoMedidaAlimento.class);
		cq.where(predicates.toArray(new Predicate[] {}));
		// if (parametros.getDataConsulta() != null) {

		// Join<AlimentoGranel, ComponenteAlimentar> componente =
		// fromAlimento.join("composicaoAlimentar", JoinType.LEFT).fetch(arg0);
		// componente.on(fromAlimento.get("composicaoAlimentar") );
		// cq.where(cb.and(cb.lessThanOrEqualTo(fromComponente.<Date>get("dataCadastro"),
		// parametros.getDataConsulta())));
		// cq.where(cb.and(predicate,
		// cb.lessThanOrEqualTo(fromAlimento.join("composicaoAlimentar").<Date>get("dataCadastro"),
		// parametros.getDataConsulta())));
		// cq.where(cb.and(predicate2,
		// cb.lessThanOrEqualTo(componente.<Date>get("dataCadastro"),
		// parametros.getDataConsulta())));
		// cq.where(cb.and(cb.lessThanOrEqualTo(fromComponente.<Date>get("dataCadastro"),
		// parametros.getDataConsulta())));
		// cq.groupBy(fromAlimento.join("composicaoAlimentar").<Date>get("substancia_id"));
		// cq.having(cb.greatest(fromAlimento.join("composicaoAlimentar").<Date>get("dataCadastro")));
		// cq.multiselect(cb.max(fromComponente), fromComponente.get("id")));
		// cq.groupBy(componente.<Substancia>get("substancia"));
		// }
		TypedQuery<AlimentoGranel> tq = manager.createQuery(cq);

		/*
		 * select alimentogr0_.id as id2_0_, alimentogr0_.uuid as uuid3_0_,
		 * alimentogr0_.categoriaAlimento_id as categori7_0_, alimentogr0_.nome
		 * as nome4_0_, alimentogr0_.porcao as porcao5_0_,
		 * alimentogr0_.unidadeGranel as unidadeG6_0_ from AlimentoUnitario
		 * alimentogr0_ inner join ComponenteAlimentar composicao1_ on
		 * alimentogr0_.id=composicao1_.alimentoUnitario_id where
		 * alimentogr0_.DTYPE='AlimentoGranel' and composicao1_.dataCadastro<=?
		 * limit ?
		 */

		/*
		 * select categoriaa0_.id as id1_2_0_, categoriaa0_.uuid as uuid2_2_0_,
		 * categoriaa0_.nome as nome3_2_0_ from CategoriaAlimento categoriaa0_
		 * where categoriaa0_.id=?
		 */

		/*
		 * select composicao0_.alimentoUnitario_id as alimento4_0_0_,
		 * composicao0_.id as id1_5_0_, composicao0_.id as id1_5_1_,
		 * composicao0_.alimentoUnitario_id as alimento4_5_1_,
		 * composicao0_.dataCadastro as dataCada2_5_1_, composicao0_.quantidade
		 * as quantida3_5_1_, composicao0_.substancia_id as substanc5_5_1_,
		 * substancia1_.id as id1_22_2_, substancia1_.nome as nome2_22_2_,
		 * substancia1_.ordem as ordem3_22_2_, substancia1_.uuid as uuid4_22_2_,
		 * substancia1_.unidadeSubstancia as unidadeS5_22_2_ from
		 * ComponenteAlimentar composicao0_ inner join Substancia substancia1_
		 * on composicao0_.substancia_id=substancia1_.id where
		 * composicao0_.alimentoUnitario_id=?
		 */

		// TypedQuery<AlimentoGranel> tq = manager.createQuery("from
		// AlimentoUnitario au inner join au.composicaoAlimentar ca where
		// ca.dataCadastro <= :data GROUP BY ca.substancia HAVING
		// max(ca.dataCadastro) > 0", AlimentoGranel.class);
		// TypedQuery<AlimentoGranel> tq = manager.createQuery("from
		// AlimentoUnitario au join au.composicaoAlimentar ca where
		// ca.dataCadastro <= :data GROUP BY ca.substancia",
		// AlimentoGranel.class);
		// tq.setParameter("data", new Date());

		if (parametros.getNumeroResultadosPorPagina() != null) {
			tq.setFirstResult(parametros.getNumeroDaPagina() - 1);
			tq.setMaxResults(parametros.getNumeroResultadosPorPagina());
		}

		for (AlimentoGranel ag : tq.getResultList()) {
			Map<SubstanciaId, ComponenteAlimentarDTO> componentes = new HashMap<SubstanciaId, ComponenteAlimentarDTO>();
			for (ComponenteAlimentar ca : ag.getComposicaoAlimentar()) {
				// Se tem data de consulta definida, pega a data, senão, pega a
				// data atual
				if (ComparaDatas.comparaApenasDatas(ca.getDataCadastro(), parametros.getDataConsulta()) <= 0) {
					// se não tem a substancia cadastrada ou Se a substância já
					// cadastrada tem data inferior a nova, então cadastra
					if (!componentes.containsKey(ca.getSubstancia().substanciaId())
							|| componentes.get(ca.getSubstancia().substanciaId()).getDataCadastro()
									.compareTo(ca.getDataCadastro()) <= 0) {
						componentes.put(ca.getSubstancia().substanciaId(),
								new ComponenteAlimentarDTO(ca.getSubstancia().substanciaId().uuid(),
										ca.getSubstancia().getNome(), ca.getQuantidade(),
										ca.getSubstancia().getUnidadeSubstancia(), ca.getDataCadastro()));
					}
				}
			}
			AlimentoDTO a = new AlimentoDTO(parametros.getDataConsulta(), ag.alimentoId().uuid(), ag.getNome(),
					ag.getUnidadeGranel(), ag.getPorcao(), ag.getCategoriaAlimento().categoriaAlimentoId().uuid(),
					ag.getCategoriaAlimento().getNome(), componentes.values());
			resultado.add(a);
		}

		return resultado;
	}

	public Collection<PreparoDTO> Executar(PreparoParametrosPesquisa parametros) {
		Collection<PreparoDTO> resultado = new ArrayList<>();

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<TipoPreparo> cq = cb.createQuery(TipoPreparo.class);
		Root<TipoPreparo> fromPreparo = cq.from(TipoPreparo.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (parametros.getNome() != null) {
			predicates.add(cb.like(fromPreparo.<String> get("nome"), "%" + parametros.getNome() + "%"));
		}

		cq.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<TipoPreparo> tq = manager.createQuery(cq);

		if (parametros.getNumeroResultadosPorPagina() != null) {
			tq.setFirstResult(parametros.getNumeroDaPagina() - 1);
			tq.setMaxResults(parametros.getNumeroResultadosPorPagina());
		}

		for (TipoPreparo p : tq.getResultList()) {
			PreparoDTO pDTO = new PreparoDTO(p.tipoPreparoId().uuid(), p.getNome());
			resultado.add(pDTO);
		}

		return resultado;
	}

	public Collection<MedidaDTO> Executar(MedidaParametrosPesquisa parametros) {
		Collection<MedidaDTO> resultado = new ArrayList<>();

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<TipoMedida> cq = cb.createQuery(TipoMedida.class);
		Root<TipoMedida> fromMedida = cq.from(TipoMedida.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (parametros.getNome() != null) {
			predicates.add(cb.like(fromMedida.<String> get("nome"), "%" + parametros.getNome() + "%"));
		}

		cq.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<TipoMedida> tq = manager.createQuery(cq);

		if (parametros.getNumeroResultadosPorPagina() != null) {
			tq.setFirstResult(parametros.getNumeroDaPagina() - 1);
			tq.setMaxResults(parametros.getNumeroResultadosPorPagina());
		}

		for (TipoMedida m : tq.getResultList()) {
			MedidaDTO mDTO = new MedidaDTO(m.tipoMedidaId().uuid(), m.getNome());
			resultado.add(mDTO);
		}

		return resultado;
	}

	public Collection<PreparoMedidaAlimentoDTO> Executar(PreparoMedidaParametrosPesquisa parametros) {
		Collection<PreparoMedidaAlimentoDTO> resultado = new ArrayList<>();

		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<PreparoMedidaAlimento> cq = cb.createQuery(PreparoMedidaAlimento.class);
		Root<PreparoMedidaAlimento> fromPreparoMedida = cq.from(PreparoMedidaAlimento.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		if (parametros.getPreparo() != null) {
			if (parametros.getPreparo().getUuid() != null) { // Ser tiver uuid
																// definido,
																// pega pelo
																// uudi, senão,
																// pesquisa pelo
																// nome
				predicates.add(cb.equal(fromPreparoMedida.join("tipoPreparo").<String> get("tipoPreparoId"),
						parametros.getPreparo().getUuid()));
			} else if (parametros.getPreparo().getNome() != null) {
				predicates.add(cb.like(fromPreparoMedida.join("tipoPreparo").<String> get("nome"),
						"%" + parametros.getPreparo().getNome() + "%"));
			}
		}
		if (parametros.getMedida() != null) {
			if (parametros.getMedida().getUuid() != null) { // Ser tiver uuid
															// definido, pega
															// pelo uudi, senão,
															// pesquisa pelo
															// nome
				predicates.add(cb.equal(fromPreparoMedida.join("tipoPreparo").<String> get("tipoPreparoId"),
						parametros.getPreparo().getUuid()));
			} else if (parametros.getMedida().getNome() != null) {
				predicates.add(cb.equal(fromPreparoMedida.join("tipoMedida").<String> get("tipoMedidaId"),
						parametros.getMedida().getUuid()));

				predicates.add(cb.like(fromPreparoMedida.join("tipoMedida").<String> get("nome"),
						"%" + parametros.getMedida().getNome() + "%"));
			}
		}

		if (parametros.getAlimento() != null) {
			if (parametros.getAlimento().getUuid() != null) { // Ser tiver uuid
																// definido,
																// pega pelo
																// uudi, senão,
																// pesquisa pelo
																// nome
				predicates.add(cb.equal(fromPreparoMedida.join("tipoPreparo").<String> get("tipoPreparoId"),
						parametros.getPreparo().getUuid()));
			} else if (parametros.getAlimento().getNome() != null) {
				predicates.add(cb.equal(fromPreparoMedida.join("alimentoGranel").<String> get("alimentoGranelId"),
						parametros.getAlimento().getUuid()));

				predicates.add(cb.like(fromPreparoMedida.join("alimentoGranel").<String> get("nome"),
						"%" + parametros.getAlimento().getNome() + "%"));
			}
		}

		cq.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<PreparoMedidaAlimento> tq = manager.createQuery(cq);

		if (parametros.getNumeroResultadosPorPagina() != null) {
			tq.setFirstResult(parametros.getNumeroDaPagina() - 1);
			tq.setMaxResults(parametros.getNumeroResultadosPorPagina());
		}

		for (PreparoMedidaAlimento pm : tq.getResultList()) {
			PreparoMedidaAlimentoDTO pmDTO = new PreparoMedidaAlimentoDTO(pm.preparoMedidaAlimentoId().uuid(), new PreparoDTO(pm.getTipoPreparo().tipoPreparoId().uuid(), pm.getTipoPreparo().getNome()), new MedidaDTO(pm.getTipoMedida().tipoMedidaId().uuid(), pm.getTipoMedida().getNome()), pm.getQuantidade());
			resultado.add(pmDTO);
		}

		return resultado;
	}

}
