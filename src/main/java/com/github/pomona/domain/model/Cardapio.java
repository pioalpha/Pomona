package com.github.pomona.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.github.common.domain.model.ConcurrencySafeEntity;

@Entity
public class Cardapio extends ConcurrencySafeEntity {

	private static final long serialVersionUID = -1449053477398991611L;

	@Embedded
	private CardapioId cardapioId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dia;
	@OneToOne
	@JoinColumn(nullable = false)
	private DivisaoRefeicao divisaoRefeicao;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Consulta consulta;
	@OneToMany(mappedBy = "cardapio", cascade = CascadeType.ALL)
	private List<RefeicaoCardapio> refeicoesCardapio;

	public Cardapio() {
		super();
		
		this.refeicoesCardapio = new ArrayList<RefeicaoCardapio>();
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public DivisaoRefeicao getDivisaoRefeicao() {
		return divisaoRefeicao;
	}

	public void setDivisaoRefeicao(DivisaoRefeicao divisaoRefeicao) {
		this.divisaoRefeicao = divisaoRefeicao;
	}

	public List<RefeicaoCardapio> getRefeicoesCardapio() {
		return refeicoesCardapio;
	}

	public void setRefeicoesCardapio(List<RefeicaoCardapio> refeicoesCardapio) {
		this.refeicoesCardapio = refeicoesCardapio;
	}

	public CardapioId cardapioId() {
		return cardapioId;
	}

	public void setCardapioId(CardapioId cardapioId) {
		this.cardapioId = cardapioId;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	@Override
	public String toString() {
		return "Cardapio [cardapioId=" + cardapioId + ", dia=" + dia + ", divisaoRefeicao=" + divisaoRefeicao
				+ ", refeicoesCardapio=" + refeicoesCardapio + "]";
	}

	/*
	 * @Override public String toString() { // Cardapio Dia: dd/MM/yyyy (4
	 * Refeições) // Qtd Alimento Proteinas(g) Lipidios(g) Carboidratos(g)
	 * Fibras(g) Energia(Kcal) Refeicao PercEnergia // 2 Abacate 3.8 37.4 10.4
	 * 2.8 393.4 DESEJUM 21% // Parcial 3.8(7.3%) 37.4(72.4%) 10.4(20.1%) 2.8
	 * 393.4 DESEJUM 21%/20%(+/-40K) // Total 3.8(7.3%) 37.4(72.4%) 10.4(20.1%)
	 * 2.8 393.4 ------- 21%/100% // Diretriz 10-25% 20-35% 45-65% // Existe
	 * diretriz por refeição só para lipídio
	 * 
	 * StringBuilder sbTitulo = new StringBuilder();
	 * 
	 * //sbTitulo.append("Qtd Alimento "); //for (Substancia substancia :
	 * Substancias){ // sbTitulo.append(" " + substancia.getNome() // + "(" +
	 * substancia.getUnidadeSubstancia() + ")"); //} //sbTitulo.append(
	 * " Energia(Kcal) Refeicao PercCalorias\n");
	 * 
	 * StringBuilder sbItens = new StringBuilder();
	 * 
	 * // Precisa de um acumulador parcial por refeicao e um acumulador total
	 * Map<Substancia, Float> parcial = new HashMap<Substancia, Float>();
	 * Map<Substancia, Float> total = new HashMap<Substancia, Float>();
	 * 
	 * TipoRefeicao ultimaRefeicao = null;
	 * 
	 * sbTitulo.append("Qtd Alimento"); for (ItemCardapio itemCardapio :
	 * itensCardapio){ sbItens.append(itemCardapio.getQuantidade()) .append(" "
	 * + itemCardapio.getEnergiaAlimento().getAlimento().getNome()); for
	 * (ComponenteAlimentar componenteAlimentar :
	 * itemCardapio.getEnergiaAlimento().getAlimento().getComposicaoAlimentar())
	 * {
	 * 
	 * if (!sbTitulo.toString().contains(componenteAlimentar.getSubstancia().
	 * getNome())){ parcial.put(componenteAlimentar.getSubstancia(),
	 * itemCardapio.getQuantidade() * componenteAlimentar.getQuantidade());
	 * total.put(componenteAlimentar.getSubstancia(),
	 * itemCardapio.getQuantidade() * componenteAlimentar.getQuantidade());
	 * sbTitulo.append(" " + componenteAlimentar.getSubstancia().getNome() + "("
	 * + componenteAlimentar.getSubstancia().getUnidadeSubstancia() + ")"); }
	 * else { parcial.put(componenteAlimentar.getSubstancia(),
	 * parcial.get(componenteAlimentar.getSubstancia()) +
	 * itemCardapio.getQuantidade() * componenteAlimentar.getQuantidade());
	 * total.put(componenteAlimentar.getSubstancia(),
	 * parcial.get(componenteAlimentar.getSubstancia()) +
	 * itemCardapio.getQuantidade() * componenteAlimentar.getQuantidade()); }
	 * sbItens.append(" " + itemCardapio.getQuantidade() *
	 * componenteAlimentar.getQuantidade());
	 * 
	 * }
	 * 
	 * sbItens.append(" " + itemCardapio.getQuantidade() *
	 * itemCardapio.getEnergiaAlimento().getEnergia()) .append(" " +
	 * itemCardapio.getTipoRefeicao()) .append(" " +
	 * ((itemCardapio.getQuantidade() *
	 * itemCardapio.getEnergiaAlimento().getEnergia()) / 1862.6672) * 100 +
	 * "%\n" );
	 * 
	 * if (ultimaRefeicao == null) { ultimaRefeicao =
	 * itemCardapio.getTipoRefeicao(); } if
	 * (!itemCardapio.getTipoRefeicao().equals(ultimaRefeicao)){ ultimaRefeicao
	 * = itemCardapio.getTipoRefeicao(); sbItens.append("Parcial"); for (float
	 * qtd : parcial.values()){ sbItens.append(" " + qtd); }
	 * sbItens.append("\n"); parcial.clear(); } } sbTitulo.append(
	 * " Energia(Kcal) Refeicao PercCalorias\n");
	 * 
	 * sbItens.append("Parcial"); for (float qtd : parcial.values()){
	 * sbItens.append(" " + qtd); } sbItens.append("\n");
	 * 
	 * sbItens.append("Total"); for (float qtd : total.values()){
	 * sbItens.append(" " + qtd); } sbItens.append("\n");
	 * 
	 * return new StringBuilder() .append("Cardapio Dia: " + dia) .append(" (" +
	 * divisaoRefeicao.getNome() + ")\n") .append(sbTitulo) .append(sbItens)
	 * .toString(); }
	 */
}
