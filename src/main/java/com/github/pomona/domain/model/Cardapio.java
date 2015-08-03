package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cardapio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1449053477398991611L;
	private Date dia;
	private DivisaoRefeicao divisaoRefeicao;
	private List<RefeicaoCardapio> refeicaoCardapio;
	
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
	public List<RefeicaoCardapio> getRefeicaoCardapio() {
		return refeicaoCardapio;
	}
	public void setRefeicaoCardapio(List<RefeicaoCardapio> refeicaoCardapio) {
		this.refeicaoCardapio = refeicaoCardapio;
	}

	
	
	/*@Override
	public String toString() {
		// Cardapio Dia: dd/MM/yyyy (4 Refeições)
		// Qtd Alimento Proteinas(g) Lipidios(g)  Carboidratos(g) Fibras(g) Energia(Kcal) Refeicao PercEnergia
		// 2   Abacate  3.8          37.4         10.4            2.8       393.4         DESEJUM  21%
		// Parcial      3.8(7.3%)    37.4(72.4%)  10.4(20.1%)     2.8       393.4         DESEJUM  21%/20%(+/-40K)
		// Total        3.8(7.3%)    37.4(72.4%)  10.4(20.1%)     2.8       393.4         -------  21%/100%
		// Diretriz     10-25%       20-35%       45-65%
		// Existe diretriz por refeição só para lipídio
		
		StringBuilder sbTitulo = new StringBuilder();

		//sbTitulo.append("Qtd Alimento ");
		//for (Substancia substancia : Substancias){
		//	sbTitulo.append(" " + substancia.getNome()
		//			+ "(" + substancia.getUnidadeSubstancia() + ")");
		//}
		//sbTitulo.append(" Energia(Kcal) Refeicao PercCalorias\n");
		
		StringBuilder sbItens = new StringBuilder();
		
		// Precisa de um acumulador parcial por refeicao e um acumulador total
		Map<Substancia, Float> parcial = new HashMap<Substancia, Float>();
		Map<Substancia, Float> total = new HashMap<Substancia, Float>();
		
		TipoRefeicao ultimaRefeicao = null;
		
		sbTitulo.append("Qtd Alimento");
		for (ItemCardapio itemCardapio : itensCardapio){
			sbItens.append(itemCardapio.getQuantidade())
				.append(" " + itemCardapio.getEnergiaAlimento().getAlimento().getNome());
			for (ComponenteAlimentar componenteAlimentar : itemCardapio.getEnergiaAlimento().getAlimento().getComposicaoAlimentar()) {
				
				if (!sbTitulo.toString().contains(componenteAlimentar.getSubstancia().getNome())){
					parcial.put(componenteAlimentar.getSubstancia(), itemCardapio.getQuantidade() * componenteAlimentar.getQuantidade());
					total.put(componenteAlimentar.getSubstancia(), itemCardapio.getQuantidade() * componenteAlimentar.getQuantidade());
					sbTitulo.append(" " + componenteAlimentar.getSubstancia().getNome()
							+ "(" + componenteAlimentar.getSubstancia().getUnidadeSubstancia() + ")");
				} else {
					parcial.put(componenteAlimentar.getSubstancia(), parcial.get(componenteAlimentar.getSubstancia()) + itemCardapio.getQuantidade() * componenteAlimentar.getQuantidade());
					total.put(componenteAlimentar.getSubstancia(), parcial.get(componenteAlimentar.getSubstancia()) + itemCardapio.getQuantidade() * componenteAlimentar.getQuantidade());
				}
				sbItens.append(" " + itemCardapio.getQuantidade() * componenteAlimentar.getQuantidade());
				
			}

			sbItens.append(" " + itemCardapio.getQuantidade() * itemCardapio.getEnergiaAlimento().getEnergia())
				.append(" " + itemCardapio.getTipoRefeicao())
				.append(" " + ((itemCardapio.getQuantidade() * itemCardapio.getEnergiaAlimento().getEnergia()) / 1862.6672) * 100 + "%\n" );
			
			if (ultimaRefeicao == null) {
				ultimaRefeicao = itemCardapio.getTipoRefeicao();
			}
			if (!itemCardapio.getTipoRefeicao().equals(ultimaRefeicao)){
				ultimaRefeicao = itemCardapio.getTipoRefeicao();
				sbItens.append("Parcial");
				for (float qtd : parcial.values()){
					sbItens.append(" " + qtd);
				}
				sbItens.append("\n");
				parcial.clear();
			}
		}
		sbTitulo.append(" Energia(Kcal) Refeicao PercCalorias\n");

		sbItens.append("Parcial");
		for (float qtd : parcial.values()){
			sbItens.append(" " + qtd);
		}
		sbItens.append("\n");
		
		sbItens.append("Total");
		for (float qtd : total.values()){
			sbItens.append(" " + qtd);
		}
		sbItens.append("\n");
		
		return new StringBuilder()
				.append("Cardapio Dia: " + dia)
				.append(" (" + divisaoRefeicao.getNome() + ")\n")
				.append(sbTitulo)
				.append(sbItens)
				.toString();
	}*/
}
