package com.github.pomona.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class AlimentoUnitario extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -3596504330554150407L;
	
	@Embedded
	private AlimentoId alimentoId;
	@Column(nullable = false, length = 100)
	private String nome;
	@OneToMany(mappedBy = "alimentoUnitario", cascade = CascadeType.ALL)
	protected List<ComponenteAlimentar> composicaoAlimentar;
	@ManyToOne
	protected CategoriaAlimento categoriaAlimento;

	public AlimentoUnitario() {
		super();
		
		this.composicaoAlimentar = new ArrayList<ComponenteAlimentar>();
	}

	public List<ComponenteAlimentar> getComposicaoAlimentar() {
		return composicaoAlimentar;
	}

	public void setComposicaoAlimentar(List<ComponenteAlimentar> composicaoAlimentar) {
		this.composicaoAlimentar = composicaoAlimentar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float fatorProporcao(float qtd) {
		return qtd;
	}

	@Override
	public String toString() {
		return "AlimentoUnitario [alimentoId=" + alimentoId + ", nome=" + nome + ", composicaoAlimentar="
				+ composicaoAlimentar + "]";
	}

	public String getDetalhe() {
		return this.getNome();
	}

	public AlimentoId alimentoId() {
		return alimentoId;
	}

	public void setAlimentoId(AlimentoId umAlimentoId) {
		this.assertArgumentNotNull(umAlimentoId, "The alimentoId must be provided.");

		this.alimentoId = umAlimentoId;
	}

	public CategoriaAlimento getCategoriaAlimento() {
		return categoriaAlimento;
	}

	public void setCategoriaAlimento(CategoriaAlimento categoriaAlimento) {
		this.categoriaAlimento = categoriaAlimento;
	}
}
