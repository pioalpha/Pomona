package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.ComponenteAlimentar;
import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.ItemCardapio;
import com.github.pomona.domain.model.LimiteEnergetico;
import com.github.pomona.domain.model.RefeicaoCardapio;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.reference.TipoRefeicao;

public class Relatorio {
	private static String QTD = "Qtd ";
	private static String ALIMENTO = "Alimento                      ";
	private static String ENERGIA = "Energia(Kcal)";
	private static String REFEICAO = "Refeição";
	private static String PERCENERGIA = "PercEnergia/PercLimite(Tolerância)";
	
	//Lista de títulos
	private List<Object> colunas;
	private List<LinhaRelatorio> linhas;
	private Map<TipoRefeicao, LinhaRelatorio> parciais;
	private LinhaRelatorio total;
	private float caloriaAlvo;
	private DivisaoRefeicao divisaoRefeicao;
	private DiretrizAlimentar diretrizAlimentar;

	public Relatorio(){
		this.colunas = new ArrayList<Object>();
		this.linhas = new ArrayList<LinhaRelatorio>();
		this.parciais = new HashMap<TipoRefeicao, LinhaRelatorio>();
		this.total = new LinhaRelatorio();
		this.caloriaAlvo = 0f;
	}
	
	private Relatorio comLinha(RefeicaoCardapio refeicaoCardapio){
		for (ItemCardapio itemCardapio : refeicaoCardapio.getItensCardapio()){
			this.comLinha(refeicaoCardapio.getTipoRefeicao(), itemCardapio);
		}
		return this;
	}

	private Relatorio comLinha(TipoRefeicao tipoRefeicao,ItemCardapio itemCardapio){
		LinhaRelatorio temp = new LinhaRelatorio(itemCardapio.getEnergiaAlimento().getAlimento(),
				itemCardapio.getQuantidade(),
				tipoRefeicao);
		temp.comEnergia(itemCardapio.getEnergiaAlimento().getEnergiaProporcional(itemCardapio.getQuantidade()));
		
		LinhaRelatorio parcial = null;
		if (this.parciais.containsKey(tipoRefeicao)){
			parcial = parciais.get(tipoRefeicao);
		} else {
			parcial = new LinhaRelatorio(tipoRefeicao);
			parciais.put(tipoRefeicao, parcial);
		}
		parcial.comEnergia(itemCardapio.getEnergiaAlimento().getEnergiaProporcional(itemCardapio.getQuantidade()));
		this.total.comEnergia(itemCardapio.getEnergiaAlimento().getEnergiaProporcional(itemCardapio.getQuantidade()));

		Substancia s = null;
		for (ComponenteAlimentar componenteAlimentar : itemCardapio.getEnergiaAlimento().getAlimento().getComposicaoAlimentar()){
			s = componenteAlimentar.getSubstancia();
			if (!colunas.contains(s)){
				colunas.add(s);
			}
			temp.comSubstancia(s, componenteAlimentar.getQuantidade() / itemCardapio.getEnergiaAlimento().getAlimento().fatorProporcao(itemCardapio.getQuantidade()));
			parcial.comSubstancia(s, componenteAlimentar.getQuantidade() / itemCardapio.getEnergiaAlimento().getAlimento().fatorProporcao(itemCardapio.getQuantidade()));
			this.total.comSubstancia(s, componenteAlimentar.getQuantidade() / itemCardapio.getEnergiaAlimento().getAlimento().fatorProporcao(itemCardapio.getQuantidade()));
		}
		linhas.add(temp);
		return this;
	}
	
	private Relatorio comCardapio(Cardapio cardapio){
		colunas.add(REFEICAO);
		colunas.add(QTD);
		colunas.add(ALIMENTO);
		for (RefeicaoCardapio refeicaoCardapio : cardapio.getRefeicaoCardapio()){
			this.comLinha(refeicaoCardapio);
		}
		colunas.add(ENERGIA);
		colunas.add(PERCENERGIA);
		return this;
	}
	
	public Relatorio comCardapio(Cardapio cardapio, float caloriaAlvo, DiretrizAlimentar diretrizAlimentar){
		this.caloriaAlvo = caloriaAlvo;
		this.diretrizAlimentar = diretrizAlimentar;
		this.divisaoRefeicao = cardapio.getDivisaoRefeicao();
		return this.comCardapio(cardapio);
	}
	
	@Override
	public String toString() {
		StringBuilder sbTitulo = new StringBuilder();
		StringBuilder sbLinha = new StringBuilder();
		StringBuilder sbLinhas = new StringBuilder();
		
		for (Object coluna : colunas){
			if (coluna.getClass().equals(Substancia.class)){
				sbTitulo.append(" " + ((Substancia)coluna).getDetalhe());
			} else {
				sbTitulo.append(" " + coluna);
			}
		}
		
		for (Map.Entry<TipoRefeicao, LinhaRelatorio> parcial : parciais.entrySet()){
			for (LinhaRelatorio linha : linhas){
				// imprime linha
				if (linha.getTipoRefeicao().equals(parcial.getKey())){
					for (Object coluna : colunas){
						// Se não for substancia
						if (coluna.getClass().equals(String.class)){
							if (((String) coluna).contains(QTD)){
								sbLinha.append(new char[sbTitulo.indexOf(QTD) - sbLinha.length()])
									.append(linha.getQuantidade());
							} else if (((String) coluna).contains(ALIMENTO)){
								sbLinha.append(new char[sbTitulo.indexOf(ALIMENTO) - sbLinha.length()])
									.append(linha.getAlimento().getDetalhe());
							} else if (((String) coluna).contains(REFEICAO)){
								sbLinha.append(new char[sbTitulo.indexOf(REFEICAO) - sbLinha.length()])
									.append(linha.getTipoRefeicao());
							} else if (((String) coluna).contains(ENERGIA)){
								sbLinha.append(new char[sbTitulo.indexOf(ENERGIA) - sbLinha.length()])
									.append(linha.getEnergia());
							} else if (((String) coluna).contains(PERCENERGIA)){
								sbLinha.append(new char[sbTitulo.indexOf(PERCENERGIA) - sbLinha.length()])
								.append((linha.getEnergia() / this.caloriaAlvo) * 100)
								.append("%");
							}
						} else {
							for (Map.Entry<Substancia, Float> entrada : linha.getSubstancias().entrySet()){
								if (entrada.getKey().equals(coluna)){
									sbLinha.append(new char[sbTitulo.indexOf(entrada.getKey().getDetalhe()) - sbLinha.length()])
										.append(entrada.getValue());
								}
							}
						}
					}
					sbLinhas.append(sbLinha + "\n");
					sbLinha.setLength(0);
				}
			}
			// imprime parcial
			for (Object coluna : colunas){
				if (coluna.getClass().equals(String.class)){
					if (((String) coluna).contains(REFEICAO)){
						sbLinha.append(new char[sbTitulo.indexOf(REFEICAO) - sbLinha.length()])
							.append(parcial.getValue().getTipoRefeicao());
					} else if (((String) coluna).contains(ENERGIA)){
						sbLinha.append(new char[sbTitulo.indexOf(ENERGIA) - sbLinha.length()])
							.append(parcial.getValue().getEnergia());
					} else if (((String) coluna).contains(PERCENERGIA)){
						sbLinha.append(new char[sbTitulo.indexOf(PERCENERGIA) - sbLinha.length()])
						.append((parcial.getValue().getEnergia() / this.caloriaAlvo) * 100)
						.append("%");
						for (LimiteEnergetico limiteEnergetico : divisaoRefeicao.getLimitesEnergeticos()){
							if (limiteEnergetico.getTipoRefeicao().equals(parcial.getValue().getTipoRefeicao())){
								sbLinha.append("/" + limiteEnergetico.getPercentualEnergetico() + "%")
								.append("(" + (((this.caloriaAlvo * limiteEnergetico.getPercentualEnergetico())/100) - limiteEnergetico.getTolerancia()) + "-" + (((this.caloriaAlvo * limiteEnergetico.getPercentualEnergetico())/100) + limiteEnergetico.getTolerancia()) + ")");
								break;
							}
						}
					} else if (((String) coluna).contains(QTD)){
						sbLinha.append(new char[sbTitulo.indexOf(QTD) - sbLinha.length()])
							.append(parcial.getValue().getTipoLinha());
					}
				} else {
					for (Map.Entry<Substancia, Float> entrada : parcial.getValue().getSubstancias().entrySet()){
						if (entrada.getKey().equals(coluna)){
							sbLinha.append(new char[sbTitulo.indexOf(entrada.getKey().getDetalhe()) - sbLinha.length()])
								.append(entrada.getValue());
						}
					}
				}
			}
			sbLinhas.append(sbLinha + "\n\n");
			sbLinha.setLength(0);
		}
		// imprime total
		for (Object coluna : colunas){
			if (coluna.getClass().equals(String.class)){
				if (((String) coluna).contains(ENERGIA)){
					sbLinha.append(new char[sbTitulo.indexOf(ENERGIA) - sbLinha.length()])
						.append(total.getEnergia());
				} else if (((String) coluna).contains(PERCENERGIA)){
					sbLinha.append(new char[sbTitulo.indexOf(PERCENERGIA) - sbLinha.length()])
					.append((total.getEnergia() / this.caloriaAlvo) * 100)
					.append("%/100%(" + (this.caloriaAlvo - 40) + "-" + (this.caloriaAlvo + 40) + ")");
				} else if (((String) coluna).contains(QTD)){
					sbLinha.append(new char[sbTitulo.indexOf(QTD) - sbLinha.length()])
						.append(total.getTipoLinha());
				}
			} else {
				for (Map.Entry<Substancia, Float> entrada : total.getSubstancias().entrySet()){
					if (entrada.getKey().equals(coluna)){
						sbLinha.append(new char[sbTitulo.indexOf(entrada.getKey().getDetalhe()) - sbLinha.length()])
							.append(entrada.getValue());
					}
				}
			}
		}
		sbLinhas.append(sbLinha + "\n");
		sbLinha.setLength(0);
		sbTitulo.append("\n").append(sbLinhas);

		// Calculos por diretriz
		//.append(this.diretrizAlimentar.getNormasAlimentares().get(0).getNormaMinima())
		//.append("-" + this.diretrizAlimentar.getNormasAlimentares().get(0).getNormaMaxima())
		//.append("(" + +  "-" + +  ")");

		return sbTitulo.toString().replace('\0', ' ');
	}
}
