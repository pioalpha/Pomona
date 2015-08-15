package com.github.pomona.domain.service;

import java.util.HashMap;
import java.util.Map;

import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.ComponenteAlimentar;
import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.ItemCardapio;
import com.github.pomona.domain.model.LimiteEnergetico;
import com.github.pomona.domain.model.PerfilAlimentarPaciente;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.model.RefeicaoCardapio;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.reference.TipoRefeicao;

public class RelatorioPlanoReeducacaoAlimentar {
	PlanoAlimentar planoAlimentar;
	
	public RelatorioPlanoReeducacaoAlimentar(PlanoAlimentar planoAlimentar){
		this.planoAlimentar = planoAlimentar;
	}
	
	public StringBuilder convertePlano(){
		StringBuilder sb = new StringBuilder()
			.append(">PACIENTE\n")
			.append(this.planoAlimentar.getPaciente().toString())
			.append("\n>PERFIL ALIMENTAR\n");
		for (PerfilAlimentarPaciente perfil : this.planoAlimentar.getPerfilAlimentarPaciente()){
			sb.append("Alimento: "+ perfil.getAlimento().getNome())
				.append(" (" + perfil.getPreferenciaConsumo())
				.append(", " + perfil.getDataCadastro() + ")");
		}

		sb.append("\n>CONSULTAS\n");
		for (Consulta consulta : this.planoAlimentar.getConsultas()){
			sb.append("Consulta Dia: "+ consulta.getDataConsulta())
				.append(" (Peso: " + consulta.getPesoConsulta() + " kg, ")
				.append("IMC: " + consulta.getImcConsulta() + ", ")
				.append(consulta.getDiretrizAlimentar().getNome() + ", ")
				.append("Tipo Meta: " + consulta.getTipoMeta() + ", ")
				.append("Valor Meta: " + consulta.getValorMeta() + ", ")
				.append("Caloria Alvo: " + consulta.getCaloriasAlvo() + ")\n")
				.append(">>CARDAPIOS\n");
			for (Cardapio cardapio : consulta.getCardapios()){
				sb.append(new Relatorio().comCardapio(cardapio, consulta.getCaloriasAlvo(), consulta.getDiretrizAlimentar())).append("\n");
			}
		}
		return sb;
	}
	
	public StringBuilder imprimeParcial(StringBuilder sb, Map<Substancia, Float> parcial, Cardapio cardapio, TipoRefeicao ultimaRefeicao){
		sb.append("Parcial");
		for (float qtd : parcial.values()){
			sb.append(" " + qtd);
		}
		for (LimiteEnergetico limiteEnergetico : cardapio.getDivisaoRefeicao().getLimitesEnergeticos()){
			if (limiteEnergetico.getTipoRefeicao().equals(ultimaRefeicao)){
				sb.append("/" + limiteEnergetico.getPercentualEnergetico() + "%\n");
			}
		}
		return sb;
	}
	
	public StringBuilder convertePerfil(PerfilAlimentarPaciente perfil){
		return new StringBuilder()
			.append("Alimento: "+ perfil.getAlimento().getNome())
			.append(" (" + perfil.getPreferenciaConsumo())
			.append(", " + perfil.getDataCadastro() + ")");
	}
	
	public StringBuilder converteConsulta(Consulta consulta){
		StringBuilder sb = new StringBuilder()
			.append("Consulta Dia: "+ consulta.getDataConsulta())
			.append(" (Peso: " + consulta.getPesoConsulta() + " kg, ")
			.append("IMC: " + consulta.getImcConsulta() + ", ")
			.append(consulta.getDiretrizAlimentar().getNome() + ", ")
			.append("Tipo Meta: " + consulta.getTipoMeta() + ", ")
			.append("Valor Meta: " + consulta.getValorMeta() + ", ")
			.append("Caloria Alvo: " + consulta.getCaloriasAlvo() + ")\n")
			.append(">>CARDAPIOS\n");
		for (Cardapio cardapio : consulta.getCardapios()){
			sb.append(converteCardapio(cardapio, consulta.getCaloriasAlvo()));
		}
		return sb;
	}
	
	public StringBuilder converteCardapio(Cardapio cardapio, float caloriasAlvo){
		// Cardapio Dia: dd/MM/yyyy (4 Refeições)
		// Qtd Alimento Proteinas(g) Lipidios(g)  Carboidratos(g) Fibras(g) Energia(Kcal) Refeicao PercEnergia
		// 2   Abacate  3.8          37.4         10.4            2.8       393.4         DESEJUM  21%
		// Parcial      3.8(7.3%)    37.4(72.4%)  10.4(20.1%)     2.8       393.4         DESEJUM  21%/20%(+/-40K)
		// Total        3.8(7.3%)    37.4(72.4%)  10.4(20.1%)     2.8       393.4         -------  21%/100%
		// Diretriz     10-25%       20-35%       45-65%
		// Existe diretriz por refeição só para lipídio
		
		StringBuilder sbTitulo = new StringBuilder();

		/*sbTitulo.append("Qtd Alimento ");
		for (Substancia substancia : Substancias){
			sbTitulo.append(" " + substancia.getNome()
					+ "(" + substancia.getUnidadeSubstancia() + ")");
		}
		sbTitulo.append(" Energia(Kcal) Refeicao PercCalorias\n");*/
		
		StringBuilder sbItens = new StringBuilder();
		
		// Precisa de um acumulador parcial por refeicao e um acumulador total
		Map<Substancia, Float> parcial = new HashMap<Substancia, Float>();
		Map<Substancia, Float> total = new HashMap<Substancia, Float>();
		
		TipoRefeicao ultimaRefeicao = null;
		
		sbTitulo.append("Qtd Alimento");
		for (RefeicaoCardapio refeicaoCardapio : cardapio.getRefeicaoCardapio()){
			for (ItemCardapio itemCardapio : refeicaoCardapio.getItensCardapio()){
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
					.append(" " + refeicaoCardapio.getTipoRefeicao())
					.append(" " + ((itemCardapio.getQuantidade() * itemCardapio.getEnergiaAlimento().getEnergia()) / caloriasAlvo) * 100 + "%\n" );
				
				if (ultimaRefeicao == null) {
					ultimaRefeicao = refeicaoCardapio.getTipoRefeicao();
				}
				if (!refeicaoCardapio.getTipoRefeicao().equals(ultimaRefeicao)){
					ultimaRefeicao = refeicaoCardapio.getTipoRefeicao();
					sbItens.append("Parcial");
					for (float qtd : parcial.values()){
						sbItens.append(" " + qtd);
					}
					sbItens.append("\n");
					parcial.clear();
				}
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
				.append("Cardapio Dia: " + cardapio.getDia())
				.append(" (" + cardapio.getDivisaoRefeicao().getNome() + ")\n")
				.append(sbTitulo)
				.append(sbItens);
	}
	
	@Override
	public String toString() {
		return convertePlano().toString();
	}
}
