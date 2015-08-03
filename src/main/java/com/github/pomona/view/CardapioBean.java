package com.github.pomona.view;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.EnergiaSubstancia;
import com.github.pomona.domain.model.ItemCardapio;
import com.github.pomona.domain.model.LimiteEnergetico;
import com.github.pomona.domain.model.PlanoReeducacaoAlimentar;
import com.github.pomona.domain.model.PreferenciaConsumo;
import com.github.pomona.domain.model.RefeicaoCardapio;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.model.TipoMeta;
import com.github.pomona.domain.model.TipoNorma;
import com.github.pomona.domain.model.TipoRefeicao;
import com.github.pomona.domain.model.TipoSexo;
import com.github.pomona.domain.model.UnidadeGranel;
import com.github.pomona.domain.model.UnidadeSubstancia;
import com.github.pomona.domain.service.AlimentoBuilder;
import com.github.pomona.domain.service.CalculaEnergiaAlimento;
import com.github.pomona.domain.service.CalculaEnergiaBuilder;
import com.github.pomona.domain.service.CalculaREE;
import com.github.pomona.domain.service.CalculosNutricaoBuilder;
import com.github.pomona.domain.service.CardapioBuilder;
import com.github.pomona.domain.service.ConsultaBuilder;
import com.github.pomona.domain.service.DiretrizAlimentarBuilder;
import com.github.pomona.domain.service.DivisaoRefeicaoBuilder;
import com.github.pomona.domain.service.PlanoReeducacaoAlimentarBuilder;
import com.github.pomona.domain.service.SubstanciaBuilder;

@ManagedBean
@ViewScoped
public class CardapioBean implements Serializable{

	private static final long serialVersionUID = -7888554190222567231L;

	private List<RefeicaoCardapio> refeicoesCardapio;
	private List<LimiteEnergetico> limitesEnergeticos;
	private List<Substancia> substancias;
	private SortedMap<Integer, Substancia> listaSubstancias;
	private float caloriaAlvo;
	private Map<Substancia, Float> energiasSubstancia;
	private ItemCardapio itemCardapioSelecionado;

	public CardapioBean() throws ParseException{
		this.Consultar();
	}
	
	public void Consultar() throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
		
		//CalculosNutricao calcNutricao = new CalculosNutricaoBuilder()
		new CalculosNutricaoBuilder()
				.adicionarFatorAtividadeFisica("Sedentário", 1f)
				.adicionarFatorAtividadeFisica("Atividade Leve", 1.12f)
				.adicionarFatorAtividadeFisica("Atividade Moderada", 1.27f)
				.adicionarFatorAtividadeFisica("Atividade Intensa", 1.45f)
				.adicionarFatorAtividadeFisica("Atividade Ultra Intensa", 1.55f)
				
				.adicionarClassificacaoIMC("Muito Abaixo do Peso", null, 17f)
				.adicionarClassificacaoIMC("Abaixo do Peso", 17f, 18.49f)
				.adicionarClassificacaoIMC("Peso Normal", 18.5f, 25f)
				.adicionarClassificacaoIMC("Acima do Peso", 25f, 30f)
				.adicionarClassificacaoIMC("Obesidade I", 30f, 35f)
				.adicionarClassificacaoIMC("Obesidade II (severa)", 35f, 40f)
				.adicionarClassificacaoIMC("Obesidade III (mórbida)", 40f, null)
				
				.adicionarFatorMetabolico(null, 3, 60.3f, -54, 61f, -51)
				.adicionarFatorMetabolico(3, 10, 22.7f, 495, 22.5f, 499)
				.adicionarFatorMetabolico(10, 18, 17.5f, 651, 12.2f, 746)
				.adicionarFatorMetabolico(18, 30, 15.3f, 679, 13.23f, 446)
				.adicionarFatorMetabolico(30, 60, 11.6f, 879, 8.7f, 829)
				.adicionarFatorMetabolico(60, null, 13.5f, 487, 10.5f, 596)
				.construir();
		

		Substancia carboidrato = new SubstanciaBuilder("Carboidrato", UnidadeSubstancia.g, 1).construir();
		Substancia proteina = new SubstanciaBuilder("Proteína", UnidadeSubstancia.g, 2).construir();
		Substancia lipidio = new SubstanciaBuilder("Lipídio", UnidadeSubstancia.g, 3).construir();
		Substancia fibra = new SubstanciaBuilder("Fibra", UnidadeSubstancia.g, 4).construir();
		Substancia ferro = new SubstanciaBuilder("Ferro", UnidadeSubstancia.mg, 5).construir();
		Substancia vitaminaC = new SubstanciaBuilder("Vitamina C", UnidadeSubstancia.mg, 6).construir();
		Substancia colesterol = new SubstanciaBuilder("Colesterol", UnidadeSubstancia.mg, 7).construir();

		
		AlimentoGranel arroz100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 25.8f)
			.adicionarComponenteAlimentar(proteina, 2.6f)
			.adicionarComponenteAlimentar(lipidio, 1f)
			.adicionarComponenteAlimentar(fibra, 2.7f)
			.adicionarComponenteAlimentar(ferro, 0.3f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Arroz Integral Cozido", UnidadeGranel.g, 100f);
		AlimentoGranel feijao100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 14f)
			.adicionarComponenteAlimentar(proteina, 4.5f)
			.adicionarComponenteAlimentar(lipidio, 0.5f)
			.adicionarComponenteAlimentar(fibra, 8.4f)
			.adicionarComponenteAlimentar(ferro, 1.5f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Feijão Preto Cozido", UnidadeGranel.g, 100f);
		AlimentoGranel alface100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 2.5f)
			.adicionarComponenteAlimentar(proteina, 0.9f)
			.adicionarComponenteAlimentar(lipidio, 0.2f)
			.adicionarComponenteAlimentar(fibra, 2f)
			.adicionarComponenteAlimentar(ferro, 2.5f)
			.adicionarComponenteAlimentar(vitaminaC, 13.5f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Alface Roxa", UnidadeGranel.g, 100f);
		AlimentoGranel cenoura100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 7.7f)
			.adicionarComponenteAlimentar(proteina, 1.3f)
			.adicionarComponenteAlimentar(lipidio, 0.2f)
			.adicionarComponenteAlimentar(fibra, 3.2f)
			.adicionarComponenteAlimentar(ferro, 0.2f)
			.adicionarComponenteAlimentar(vitaminaC, 5.1f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Cenoura Crua Ralada", UnidadeGranel.g, 100f);
		AlimentoGranel batata100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 18.4f)
			.adicionarComponenteAlimentar(proteina, 0.6f)
			.adicionarComponenteAlimentar(lipidio, 0.1f)
			.adicionarComponenteAlimentar(fibra, 2.2f)
			.adicionarComponenteAlimentar(ferro, 0.2f)
			.adicionarComponenteAlimentar(vitaminaC, 23.8f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Batata Doce Cozida", UnidadeGranel.g, 100f);
		AlimentoGranel sardinha100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0f)
			.adicionarComponenteAlimentar(proteina, 33.4f)
			.adicionarComponenteAlimentar(lipidio, 12.7f)
			.adicionarComponenteAlimentar(fibra, 0f)
			.adicionarComponenteAlimentar(ferro, 0.1f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 103f)
			.construir("Sardinha Frita", UnidadeGranel.g, 100f);
		AlimentoGranel sucoLaranja100ml = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 7.6f)
			.adicionarComponenteAlimentar(proteina, 0.7f)
			.adicionarComponenteAlimentar(lipidio, 0.1f)
			.adicionarComponenteAlimentar(fibra, 0f)
			.adicionarComponenteAlimentar(ferro, 0f)
			.adicionarComponenteAlimentar(vitaminaC, 73f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Suco Laranja Pera Coado", UnidadeGranel.ml, 100f);
		AlimentoGranel beterraba100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 11.1f)
			.adicionarComponenteAlimentar(proteina, 1.9f)
			.adicionarComponenteAlimentar(lipidio, 0.1f)
			.adicionarComponenteAlimentar(fibra, 3.4f)
			.adicionarComponenteAlimentar(ferro, 0.3f)
			.adicionarComponenteAlimentar(vitaminaC, 3.1f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Beterraba Crua", UnidadeGranel.g, 100f);
		AlimentoGranel queijo100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 3.2f)
			.adicionarComponenteAlimentar(proteina, 17.4f)
			.adicionarComponenteAlimentar(lipidio, 20.2f)
			.adicionarComponenteAlimentar(fibra, 0f)
			.adicionarComponenteAlimentar(ferro, 0.9f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 62f)
			.construir("Queijo Minas Frescal", UnidadeGranel.g, 100f);
		AlimentoGranel goiabada100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 78.7f)
			.adicionarComponenteAlimentar(proteina, 0.4f)
			.adicionarComponenteAlimentar(lipidio, 0.1f)
			.adicionarComponenteAlimentar(fibra, 4.4f)
			.adicionarComponenteAlimentar(ferro, 0.4f)
			.adicionarComponenteAlimentar(vitaminaC, 34.3f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Goiabada Cascão", UnidadeGranel.g, 100f);
		AlimentoGranel oleo100ml = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0f)
			.adicionarComponenteAlimentar(proteina, 0f)
			.adicionarComponenteAlimentar(lipidio, 100f)
			.adicionarComponenteAlimentar(fibra, 0f)
			.adicionarComponenteAlimentar(ferro, 0f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Óleo de Cocção", UnidadeGranel.ml, 100f);
		
		CalculaEnergiaAlimento calcEne = new CalculaEnergiaBuilder()
				.adicionarEnergiaSubstancia(proteina, 4f)
				.adicionarEnergiaSubstancia(lipidio, 9f)
				.adicionarEnergiaSubstancia(carboidrato, 4f)
				.construir();
		
		
		DiretrizAlimentar dirPadrao = new DiretrizAlimentarBuilder("Diretriz Padrão")
				.adicionarNormaAlimentar(carboidrato, TipoNorma.PERCENTUAL, 55f, 75f)
				.adicionarNormaAlimentar(proteina, TipoNorma.PERCENTUAL, 10f, 15f)
				.adicionarNormaAlimentar(lipidio, TipoNorma.PERCENTUAL, 10f, 30f)
				.construir();

		DivisaoRefeicao divExemplo = new DivisaoRefeicaoBuilder("Exemplo Refeições")
				.adicionarLimiteEnergetico(TipoRefeicao.ALMOCO, 35f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.JANTAR, 35f, 40f)
				.construir();
		
		limitesEnergeticos = divExemplo.getLimitesEnergeticos();
		
		
		PlanoReeducacaoAlimentar planoMCP = new PlanoReeducacaoAlimentarBuilder(
				"MCP", (Date)format.parse("29/06/1990"), 1.55f, TipoSexo.FEMININO)
				.comPerfilAlimentar(arroz100g, PreferenciaConsumo.REQUER)
				.construir();
		
		Consulta consMCP = new ConsultaBuilder(new Date(), 63f, dirPadrao,
				CalculaREE.getFatoresAtividadeFisica().get(4), planoMCP)
				.definirMeta(TipoMeta.IMC, 24.14f)
				//.definirMeta(TipoMeta.PESO, 60f)
				//.definirMeta(TipoMeta.CALORIA, 2000f)
				.construir();
		
		planoMCP.setConsultas(new ArrayList<Consulta>());
		planoMCP.getConsultas().add(consMCP);
		
		this.caloriaAlvo = consMCP.getCaloriasAlvo();
		
		this.refeicoesCardapio = new CardapioBuilder(new Date(), divExemplo, calcEne)
				.adicionarAlimento(arroz100g, 63f, TipoRefeicao.JANTAR)
				.adicionarAlimento(feijao100g, 80f, TipoRefeicao.JANTAR)

				.adicionarAlimento(arroz100g, 63f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(feijao100g, 80f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(alface100g, 40f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(cenoura100g, 36f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(batata100g, 42f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(sardinha100g, 80f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(sucoLaranja100ml, 168f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(beterraba100g, 72f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(queijo100g, 20f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(goiabada100g, 20f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(oleo100ml, 4f, TipoRefeicao.ALMOCO)
				.construir().getRefeicaoCardapio();

		this.substancias = new ArrayList<Substancia>();
		this.listaSubstancias = new TreeMap<Integer, Substancia>();
		
		for(Map.Entry<Substancia, Float> substancia : this.getTotal().entrySet()){
			if(!this.substancias.contains(substancia.getKey())){
				this.substancias.add(substancia.getKey());
				this.listaSubstancias.put(substancia.getKey().getOrdem(), substancia.getKey());
			}
		}
		
		this.energiasSubstancia = new HashMap<Substancia, Float>();
		for (EnergiaSubstancia energiaSubstancia : calcEne.getEnergiaSubstancia()){
			this.energiasSubstancia.put(energiaSubstancia.getSubstancia(), energiaSubstancia.getFatorEnergetico());
		}
	}

	public Map<Substancia,Float> getTotal(){
		Map<Substancia,Float> resultado = new HashMap<Substancia, Float>();
		for(RefeicaoCardapio refeicaoCardapio : this.refeicoesCardapio){
			for(Map.Entry<Substancia, Float> parcial : refeicaoCardapio.getParcial().entrySet()){
				if(resultado.containsKey(parcial.getKey())){
					resultado.put(parcial.getKey(), resultado.get(parcial.getKey()) + parcial.getValue());
				} else {
					resultado.put(parcial.getKey(), parcial.getValue());
				}
			}
		}
		return resultado;
	}

	public float getQtdGrama() {
		float resultado = 0;
		for(RefeicaoCardapio refeicaoCardapio : this.refeicoesCardapio){
			resultado += refeicaoCardapio.getQtdGrama();
		}
		return resultado;
	}

	public float getQtdLitro() {
		float resultado = 0;
		for(RefeicaoCardapio refeicaoCardapio : this.refeicoesCardapio){
			resultado += refeicaoCardapio.getQtdLitro();
		}
		return resultado;
	}

	public float getEnergia() {
		float resultado = 0;
		for(RefeicaoCardapio refeicaoCardapio : this.refeicoesCardapio){
			resultado += refeicaoCardapio.getEnergia();
		}
		return resultado;

	}

	public Map<Substancia, Float> getEnergiasSubstancia() {
		return energiasSubstancia;
	}
	
	public List<RefeicaoCardapio> getRefeicoesCardapio() {
		return refeicoesCardapio;
	}

	public List<LimiteEnergetico> getLimitesEnergeticos() {
		return limitesEnergeticos;
	}

	public List<Substancia> getSubstancias() {
		return substancias;
	}

	public List<Substancia> getListaSubstancias() {
		return new ArrayList<Substancia>(listaSubstancias.values());
	}

	public float getCaloriaAlvo() {
		return caloriaAlvo;
	}

	public ItemCardapio getItemCardapioSelecionado() {
		return itemCardapioSelecionado;
	}

	public void setItemCardapioSelecionado(ItemCardapio itemCardapioSelecionado) {
		this.itemCardapioSelecionado = itemCardapioSelecionado;
	}

}
