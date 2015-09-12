package com.github.pomona.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.github.common.util.WeldContext;
import com.github.pomona.application.AlimentoQueryService;
import com.github.pomona.application.DiretrizQueryService;
import com.github.pomona.application.DivisaoQueryService;
import com.github.pomona.application.SubstanciaQueryService;
import com.github.pomona.application.dto.AlimentoDTO;
import com.github.pomona.application.dto.AlimentoParametrosPesquisa;
import com.github.pomona.application.dto.ComponenteAlimentarDTO;
import com.github.pomona.application.dto.DiretrizAlimentarDTO;
import com.github.pomona.application.dto.DiretrizParametrosPesquisa;
import com.github.pomona.application.dto.DivisaoParametrosPesquisa;
import com.github.pomona.application.dto.DivisaoRefeicaoDTO;
import com.github.pomona.application.dto.LimiteEnergeticoDTO;
import com.github.pomona.application.dto.MedidaDTO;
import com.github.pomona.application.dto.MedidaParametrosPesquisa;
import com.github.pomona.application.dto.NormaAlimentarDTO;
import com.github.pomona.application.dto.ApresentacaoDTO;
import com.github.pomona.application.dto.ApresentacaoMedidaAlimentoDTO;
import com.github.pomona.application.dto.ApresentacaoMedidaParametrosPesquisa;
import com.github.pomona.application.dto.ApresentacaoParametrosPesquisa;
import com.github.pomona.application.dto.SubstanciaDTO;
import com.github.pomona.application.dto.SubstanciaParametrosPesquisa;
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.model.PlanoAlimentarRepo;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.reference.PreferenciaConsumo;
import com.github.pomona.domain.reference.TipoMeta;
import com.github.pomona.domain.reference.TipoNorma;
import com.github.pomona.domain.reference.TipoRefeicao;
import com.github.pomona.domain.reference.TipoSexo;
import com.github.pomona.domain.reference.UnidadeGranel;
import com.github.pomona.domain.reference.UnidadeSubstancia;
import com.github.pomona.domain.service.AlimentoBuilder;
import com.github.pomona.domain.service.CalculaEnergiaAlimento;
import com.github.pomona.domain.service.CalculaEnergiaBuilder;
import com.github.pomona.domain.service.CalculaREE;
import com.github.pomona.domain.service.CalculosNutricaoBuilder;
import com.github.pomona.domain.service.CardapioBuilder;
import com.github.pomona.domain.service.ConsultaBuilder;
import com.github.pomona.domain.service.DiretrizAlimentarBuilder;
import com.github.pomona.domain.service.DivisaoRefeicaoBuilder;
import com.github.pomona.domain.service.PlanoAlimentarBuilder;
import com.github.pomona.domain.service.RelatorioPlanoReeducacaoAlimentar;
import com.github.pomona.domain.service.SubstanciaBuilder;

public class TesteFernanda {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		SubstanciaQueryService sqs = WeldContext.INSTANCE.getBean(SubstanciaQueryService.class);
		for (SubstanciaDTO sDTO : sqs.Executar(new SubstanciaParametrosPesquisa())) {
			System.out.println("Substancia> " + sDTO.getNome() + "(" + sDTO.getUuid() + ") - " + sDTO.getUnidadeSubstancia() + " - Ordem: " + sDTO.getOrdem());
		}
		
		AlimentoQueryService aqs = WeldContext.INSTANCE.getBean(AlimentoQueryService.class);
		for (AlimentoDTO aDTO : aqs.Executar(new AlimentoParametrosPesquisa())){
		//for (AlimentoDTO aDTO : aqs.Executar(new AlimentoParametrosPesquisa(2, 1, format.parse("09/08/2015"), "aba", "fr"))){
			System.out.println("Alimento> " + aDTO.getCategoria() + "(" + aDTO.getCategoria() + ") - " + aDTO.getNome() + "(" + aDTO.getUuid() + ") - " + aDTO.getPorcao() + aDTO.getUnidadeGranel() + " - DataConsultada: " + aDTO.getDataConsultada());
			for (ComponenteAlimentarDTO caDTO : aDTO.getComponentesAlimentares()) {
				System.out.println("Componente> " + caDTO.getSubstancia() + caDTO.getQuantidadeSubstancia() + " - Cadastro: " + caDTO.getDataCadastro());
			}
		}
		
		for (ApresentacaoDTO pDTO : aqs.Executar(new ApresentacaoParametrosPesquisa())) {
			System.out.println("Apresentacao> " + pDTO.getNome() + "(" + pDTO.getUuid() + ")");
		}
		
		for (MedidaDTO mDTO : aqs.Executar(new MedidaParametrosPesquisa())) {
			System.out.println("Medida> " + mDTO.getNome() + "(" + mDTO.getUuid() + ")");
		}
		
		for (ApresentacaoMedidaAlimentoDTO pmDTO : aqs.Executar(new ApresentacaoMedidaParametrosPesquisa())) {
			System.out.println("ApresentacaoMedida> UUID: " + pmDTO.getUuid() + " -  Apresentacao: " + pmDTO.getApresentacao().getNome() + "(" + pmDTO.getApresentacao().getUuid() + ") - Medida: " + pmDTO.getMedida().getNome() + "(" + pmDTO.getMedida().getUuid() + ") - Quantidade: " + pmDTO.getQuantidade());
		}
		
		DiretrizQueryService dqs = WeldContext.INSTANCE.getBean(DiretrizQueryService.class);
		for (DiretrizAlimentarDTO daDTO : dqs.Executar(new DiretrizParametrosPesquisa(null, true, new Date()))){
			System.out.println("Diretriz> " + daDTO.getNome() + "(" + daDTO.getUuid() + ") - DataRevogacao: " + daDTO.getDataRevogacao() + " - DataConsultada: " + daDTO.getDataConsultada());
			for (NormaAlimentarDTO naDTO : daDTO.getNormasAlimentares()) {
				System.out.println("Norma> " + naDTO.getNomeSubstancia() + "(" + naDTO.getUuidSubstancia() + ") - " + naDTO.getUnidadeSubstancia() + " - Tipo: " + naDTO.getTipoNorma() + " - Min: " + naDTO.getNormaMinima() + "% - Max: "+ naDTO.getNormaMaxima() + "% - Criacao: " + naDTO.getDataCriacao());
			}
		}
		
		DivisaoQueryService dvqs = WeldContext.INSTANCE.getBean(DivisaoQueryService.class);
		for (DivisaoRefeicaoDTO drDTO : dvqs.Executar(new DivisaoParametrosPesquisa(null, new Date()))){
			System.out.println("Divisao> " + drDTO.getNome() + "(" + drDTO.getUuid() + ") - DataConsultada: " + drDTO.getDataConsultada());
			for (LimiteEnergeticoDTO leDTO : drDTO.getLimitesEnergeticos()) {
				System.out.println("Limite> " + leDTO.getTipoRefeicao() + " - " + leDTO.getPercentualEnergetico() + "% - " + leDTO.getTolerancia() + " - DataCadastro: " + leDTO.getDataCadastro());
			}
		}
		
		PlanoAlimentarRepo planoAlimentarRepoImpl = WeldContext.INSTANCE.getBean(PlanoAlimentarRepoImpl.class);
		for (PlanoAlimentar p : planoAlimentarRepoImpl.todos()) {
			System.out.println(new RelatorioPlanoReeducacaoAlimentar(p).toString());
		}
		
		
		
		  
		
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
		Substancia proteina = new SubstanciaBuilder("Proteína ", UnidadeSubstancia.g, 2).construir();
		Substancia lipidio = new SubstanciaBuilder("Lipídio  ", UnidadeSubstancia.g, 3).construir();
		Substancia fibra = new SubstanciaBuilder("Fibra    ", UnidadeSubstancia.g, 4).construir();
		Substancia ferro = new SubstanciaBuilder("Ferro    ", UnidadeSubstancia.mg, 5).construir();
		Substancia vitaminaC = new SubstanciaBuilder("Vitamina C ", UnidadeSubstancia.mg, 6).construir();
		Substancia colesterol = new SubstanciaBuilder("Colesterol ", UnidadeSubstancia.mg, 7).construir();

		
		AlimentoUnitario arroz = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 16.254f)
			.adicionarComponenteAlimentar(proteina, 1.638f)
			.adicionarComponenteAlimentar(lipidio, 0.63f)
			.construir("Arroz Integral Cozido 63g");
		AlimentoUnitario feijao = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 11.2f)
			.adicionarComponenteAlimentar(proteina, 3.6f)
			.adicionarComponenteAlimentar(lipidio, 0.4f)
			.construir("Feijão Preto Cozido 80g");
		AlimentoUnitario alface = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 1f)
			.adicionarComponenteAlimentar(proteina, 0.36f)
			.adicionarComponenteAlimentar(lipidio, 0.01f)
			.construir("Alface Roxa 40g");
		AlimentoUnitario cenoura = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 2.772f)
			.adicionarComponenteAlimentar(proteina, 0.468f)
			.adicionarComponenteAlimentar(lipidio, 0.072f)
			.construir("Cenoura Crua Ralada 36g");
		AlimentoUnitario batata = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 7.728f)
			.adicionarComponenteAlimentar(proteina, 0.252f)
			.adicionarComponenteAlimentar(lipidio, 0.042f)
			.construir("Batata Doce Cozida 42g");
		AlimentoUnitario sardinha = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0f)
			.adicionarComponenteAlimentar(proteina, 26.72f)
			.adicionarComponenteAlimentar(lipidio, 10.16f)
			.construir("Sardinha Frita 80g");
		AlimentoUnitario sucoLaranja = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 12.761f)
			.adicionarComponenteAlimentar(proteina, 1.176f)
			.adicionarComponenteAlimentar(lipidio, 0.168f)
			.construir("Suco Laranja Pera 168ml");
		AlimentoUnitario beterraba = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 7.992f)
			.adicionarComponenteAlimentar(proteina, 1.368f)
			.adicionarComponenteAlimentar(lipidio, 0.072f)
			.construir("Beterraba Crua 72g");
		AlimentoUnitario queijo = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0.64f)
			.adicionarComponenteAlimentar(proteina, 3.48f)
			.adicionarComponenteAlimentar(lipidio, 4.04f)
			.construir("Queijo Minas Frescal 20g");
		AlimentoUnitario goiabada = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 15.74f)
			.adicionarComponenteAlimentar(proteina, 0.08f)
			.adicionarComponenteAlimentar(lipidio, 0.02f)
			.construir("Goiabada Cascão 20g");
		AlimentoUnitario oleo = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0f)
			.adicionarComponenteAlimentar(proteina, 0f)
			.adicionarComponenteAlimentar(lipidio, 4f)
			.construir("Óleo de Cocção 4ml");
		
		AlimentoGranel arroz63g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 16.254f)
			.adicionarComponenteAlimentar(proteina, 1.638f)
			.adicionarComponenteAlimentar(lipidio, 0.63f)
			.construir("Arroz Integral Cozido", UnidadeGranel.g, 63f, null);
		AlimentoGranel feijao80g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 11.2f)
			.adicionarComponenteAlimentar(proteina, 3.6f)
			.adicionarComponenteAlimentar(lipidio, 0.4f)
			.construir("Feijão Preto Cozido", UnidadeGranel.g, 80f, null);
		AlimentoGranel alface40g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 1f)
			.adicionarComponenteAlimentar(proteina, 0.36f)
			.adicionarComponenteAlimentar(lipidio, 0.01f)
			.construir("Alface Roxa", UnidadeGranel.g, 40f, null);
		AlimentoGranel cenoura36g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 2.772f)
			.adicionarComponenteAlimentar(proteina, 0.468f)
			.adicionarComponenteAlimentar(lipidio, 0.072f)
			.construir("Cenoura Crua Ralada", UnidadeGranel.g, 36f, null);
		AlimentoGranel batata42g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 7.728f)
			.adicionarComponenteAlimentar(proteina, 0.252f)
			.adicionarComponenteAlimentar(lipidio, 0.042f)
			.construir("Batata Doce Cozida", UnidadeGranel.g, 42f, null);
		AlimentoGranel sardinha80g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0f)
			.adicionarComponenteAlimentar(proteina, 26.72f)
			.adicionarComponenteAlimentar(lipidio, 10.16f)
			.construir("Sardinha Frita", UnidadeGranel.g, 80f, null);
		AlimentoGranel sucoLaranja168ml = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 12.761f)
			.adicionarComponenteAlimentar(proteina, 1.176f)
			.adicionarComponenteAlimentar(lipidio, 0.168f)
			.construir("Suco Laranja Pera", UnidadeGranel.ml, 168, null);
		AlimentoGranel beterraba72g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 7.992f)
			.adicionarComponenteAlimentar(proteina, 1.368f)
			.adicionarComponenteAlimentar(lipidio, 0.072f)
			.construir("Beterraba Crua", UnidadeGranel.g, 72f, null);
		AlimentoGranel queijo20g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0.64f)
			.adicionarComponenteAlimentar(proteina, 3.48f)
			.adicionarComponenteAlimentar(lipidio, 4.04f)
			.construir("Queijo Minas Frescal", UnidadeGranel.g, 20f, null);
		AlimentoGranel goiabada20g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 15.74f)
			.adicionarComponenteAlimentar(proteina, 0.08f)
			.adicionarComponenteAlimentar(lipidio, 0.02f)
			.construir("Goiabada Cascão", UnidadeGranel.g, 20f, null);
		AlimentoGranel oleo4ml = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0f)
			.adicionarComponenteAlimentar(proteina, 0f)
			.adicionarComponenteAlimentar(lipidio, 4f)
			.construir("Óleo de Cocção", UnidadeGranel.ml, 4f, null);
		
		AlimentoGranel arroz100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 25.8f)
			.adicionarComponenteAlimentar(proteina, 2.6f)
			.adicionarComponenteAlimentar(lipidio, 1f)
			.adicionarComponenteAlimentar(fibra, 2.7f)
			.adicionarComponenteAlimentar(ferro, 0.3f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Arroz Integral Cozido", UnidadeGranel.g, 100f, null);
		AlimentoGranel feijao100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 14f)
			.adicionarComponenteAlimentar(proteina, 4.5f)
			.adicionarComponenteAlimentar(lipidio, 0.5f)
			.adicionarComponenteAlimentar(fibra, 8.4f)
			.adicionarComponenteAlimentar(ferro, 1.5f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Feijão Preto Cozido", UnidadeGranel.g, 100f, null);
		AlimentoGranel alface100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 2.5f)
			.adicionarComponenteAlimentar(proteina, 0.9f)
			.adicionarComponenteAlimentar(lipidio, 0.2f)
			.adicionarComponenteAlimentar(fibra, 2f)
			.adicionarComponenteAlimentar(ferro, 2.5f)
			.adicionarComponenteAlimentar(vitaminaC, 13.5f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Alface Roxa", UnidadeGranel.g, 100f, null);
		AlimentoGranel cenoura100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 7.7f)
			.adicionarComponenteAlimentar(proteina, 1.3f)
			.adicionarComponenteAlimentar(lipidio, 0.2f)
			.adicionarComponenteAlimentar(fibra, 3.2f)
			.adicionarComponenteAlimentar(ferro, 0.2f)
			.adicionarComponenteAlimentar(vitaminaC, 5.1f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Cenoura Crua Ralada", UnidadeGranel.g, 100f, null);
		AlimentoGranel batata100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 18.4f)
			.adicionarComponenteAlimentar(proteina, 0.6f)
			.adicionarComponenteAlimentar(lipidio, 0.1f)
			.adicionarComponenteAlimentar(fibra, 2.2f)
			.adicionarComponenteAlimentar(ferro, 0.2f)
			.adicionarComponenteAlimentar(vitaminaC, 23.8f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Batata Doce Cozida", UnidadeGranel.g, 100f, null);
		AlimentoGranel sardinha100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0f)
			.adicionarComponenteAlimentar(proteina, 33.4f)
			.adicionarComponenteAlimentar(lipidio, 12.7f)
			.adicionarComponenteAlimentar(fibra, 0f)
			.adicionarComponenteAlimentar(ferro, 0.1f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 103f)
			.construir("Sardinha Frita", UnidadeGranel.g, 100f, null);
		AlimentoGranel sucoLaranja100ml = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 7.6f)
			.adicionarComponenteAlimentar(proteina, 0.7f)
			.adicionarComponenteAlimentar(lipidio, 0.1f)
			.adicionarComponenteAlimentar(fibra, 0f)
			.adicionarComponenteAlimentar(ferro, 0f)
			.adicionarComponenteAlimentar(vitaminaC, 73f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Suco Laranja Pera Coado", UnidadeGranel.ml, 100f, null);
		AlimentoGranel beterraba100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 11.1f)
			.adicionarComponenteAlimentar(proteina, 1.9f)
			.adicionarComponenteAlimentar(lipidio, 0.1f)
			.adicionarComponenteAlimentar(fibra, 3.4f)
			.adicionarComponenteAlimentar(ferro, 0.3f)
			.adicionarComponenteAlimentar(vitaminaC, 3.1f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Beterraba Crua", UnidadeGranel.g, 100f, null);
		AlimentoGranel queijo100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 3.2f)
			.adicionarComponenteAlimentar(proteina, 17.4f)
			.adicionarComponenteAlimentar(lipidio, 20.2f)
			.adicionarComponenteAlimentar(fibra, 0f)
			.adicionarComponenteAlimentar(ferro, 0.9f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 62f)
			.construir("Queijo Minas Frescal", UnidadeGranel.g, 100f, null);
		AlimentoGranel goiabada100g = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 78.7f)
			.adicionarComponenteAlimentar(proteina, 0.4f)
			.adicionarComponenteAlimentar(lipidio, 0.1f)
			.adicionarComponenteAlimentar(fibra, 4.4f)
			.adicionarComponenteAlimentar(ferro, 0.4f)
			.adicionarComponenteAlimentar(vitaminaC, 34.3f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Goiabada Cascão", UnidadeGranel.g, 100f, null);
		AlimentoGranel oleo100ml = new AlimentoBuilder()
			.adicionarComponenteAlimentar(carboidrato, 0f)
			.adicionarComponenteAlimentar(proteina, 0f)
			.adicionarComponenteAlimentar(lipidio, 100f)
			.adicionarComponenteAlimentar(fibra, 0f)
			.adicionarComponenteAlimentar(ferro, 0f)
			.adicionarComponenteAlimentar(vitaminaC, 0f)
			.adicionarComponenteAlimentar(colesterol, 0f)
			.construir("Óleo de Cocção", UnidadeGranel.ml, 100f, null);
		
		CalculaEnergiaAlimento calcEne = new CalculaEnergiaBuilder()
				.adicionarEnergiaSubstancia(proteina, 4f)
				.adicionarEnergiaSubstancia(lipidio, 9f)
				.adicionarEnergiaSubstancia(carboidrato, 4f)
				/* Adicionados dinamicamente
				.adicionarEnergiaAlimento(arroz)
				.adicionarEnergiaAlimento(feijao)
				.adicionarEnergiaAlimento(alface)
				.adicionarEnergiaAlimento(cenoura)
				.adicionarEnergiaAlimento(batata)
				.adicionarEnergiaAlimento(sardinha)
				.adicionarEnergiaAlimento(sucoLaranja)
				.adicionarEnergiaAlimento(beterraba)
				.adicionarEnergiaAlimento(queijo)
				.adicionarEnergiaAlimento(goiabada)
				.adicionarEnergiaAlimento(oleo)
				.adicionarEnergiaAlimento(arroz63g)
				.adicionarEnergiaAlimento(feijao80g)
				.adicionarEnergiaAlimento(alface40g)
				.adicionarEnergiaAlimento(cenoura36g)
				.adicionarEnergiaAlimento(batata42g)
				.adicionarEnergiaAlimento(sardinha80g)
				.adicionarEnergiaAlimento(sucoLaranja168ml)
				.adicionarEnergiaAlimento(beterraba72g)
				.adicionarEnergiaAlimento(queijo20g)
				.adicionarEnergiaAlimento(goiabada20g)
				.adicionarEnergiaAlimento(oleo4ml)
				.adicionarEnergiaAlimento(arroz100g)
				.adicionarEnergiaAlimento(feijao100g)
				.adicionarEnergiaAlimento(alface100g)
				.adicionarEnergiaAlimento(cenoura100g)
				.adicionarEnergiaAlimento(batata100g)
				.adicionarEnergiaAlimento(sardinha100g)
				.adicionarEnergiaAlimento(sucoLaranja100ml)
				.adicionarEnergiaAlimento(beterraba100g)
				.adicionarEnergiaAlimento(queijo100g)
				.adicionarEnergiaAlimento(goiabada100g)
				.adicionarEnergiaAlimento(oleo100ml)*/
				.construir();
		
		
		DiretrizAlimentar dirPadrao = new DiretrizAlimentarBuilder("Diretriz Padrão")
				.adicionarNormaAlimentar(carboidrato, TipoNorma.PERCENTUAL, 55f, 75f)
				.adicionarNormaAlimentar(proteina, TipoNorma.PERCENTUAL, 10f, 15f)
				.adicionarNormaAlimentar(lipidio, TipoNorma.PERCENTUAL, 10f, 30f)
				.construir();

		
		DivisaoRefeicao div6Refeicoes = new DivisaoRefeicaoBuilder("6 Refeições")
				.adicionarLimiteEnergetico(TipoRefeicao.DESEJUM, 15f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.COLACAO, 5f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.ALMOCO, 30f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.LANCHE, 15f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.JANTAR, 30f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.CEIA, 5f, 40f)
				.construir();

		DivisaoRefeicao divExemplo = new DivisaoRefeicaoBuilder("Exemplo Refeições")
		.adicionarLimiteEnergetico(TipoRefeicao.ALMOCO, 35f, 40f)
		.adicionarLimiteEnergetico(TipoRefeicao.JANTAR, 35f, 40f)
		.construir();
		
		PlanoAlimentar planoMCP = new PlanoAlimentarBuilder(
				"MCP", (Date)format.parse("29/06/1990"), TipoSexo.FEMININO)
				.comPerfilAlimentar(arroz, PreferenciaConsumo.REQUER)
				/*.comPerfilAlimentar(cereais, PreferenciaConsumo.REQUER)
				.comPerfilAlimentar(leguminosas, PreferenciaConsumo.REQUER)
				.comPerfilAlimentar(frutas e suco de frutas, PreferenciaConsumo.REQUER)
				.comPerfilAlimentar(proteina de origem animal, PreferenciaConsumo.REQUER)
				.comPerfilAlimentar(oleo de oliva, PreferenciaConsumo.REQUER)
				.comPerfilAlimentar(horaliça A, PreferenciaConsumo.REQUER)
				.comPerfilAlimentar(horaliça B, PreferenciaConsumo.REQUER)
				.comPerfilAlimentar(horaliça C, PreferenciaConsumo.REQUER)*/
				.construir();
		
		Consulta consMCP = new ConsultaBuilder(new Date(), 63f, 1.55f, dirPadrao,
				CalculaREE.getFatoresAtividadeFisica().get(4), planoMCP)
				.definirMeta(TipoMeta.IMC, 24.14f)
				//.definirMeta(TipoMeta.PESO, 50f)
				//.definirMeta(TipoMeta.CALORIA, 2000f)
				.construir();
		
		planoMCP.setConsultas(new ArrayList<Consulta>());
		planoMCP.getConsultas().add(consMCP);
		
		Cardapio cardMCP1 = new CardapioBuilder(new Date(), divExemplo, calcEne)
				.adicionarAlimento(arroz, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(feijao, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(alface, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(cenoura, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(batata, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(sardinha, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(sucoLaranja, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(beterraba, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(queijo, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(goiabada, 1f, TipoRefeicao.ALMOCO)
				.adicionarAlimento(oleo, 1f, TipoRefeicao.ALMOCO)
				
				.adicionarAlimento(arroz63g, 63f, TipoRefeicao.JANTAR)
				.adicionarAlimento(feijao80g, 80f, TipoRefeicao.JANTAR)
				.adicionarAlimento(alface40g, 40f, TipoRefeicao.JANTAR)
				.adicionarAlimento(cenoura36g, 36f, TipoRefeicao.JANTAR)
				.adicionarAlimento(batata42g, 42f, TipoRefeicao.JANTAR)
				.adicionarAlimento(sardinha80g, 80f, TipoRefeicao.JANTAR)
				.adicionarAlimento(sucoLaranja168ml, 168f, TipoRefeicao.JANTAR)
				.adicionarAlimento(beterraba72g, 72f, TipoRefeicao.JANTAR)
				.adicionarAlimento(queijo20g, 20f, TipoRefeicao.JANTAR)
				.adicionarAlimento(goiabada20g, 20f, TipoRefeicao.JANTAR)
				.adicionarAlimento(oleo4ml, 4f, TipoRefeicao.JANTAR)
				.construir();
		
		Cardapio cardMCP2 = new CardapioBuilder(new Date(), divExemplo, calcEne)
				.adicionarAlimento(arroz100g, 63f, TipoRefeicao.JANTAR)
				.adicionarAlimento(feijao100g, 80f, TipoRefeicao.JANTAR)
				.adicionarAlimento(alface100g, 40f, TipoRefeicao.JANTAR)
				.adicionarAlimento(cenoura100g, 36f, TipoRefeicao.JANTAR)
				.adicionarAlimento(batata100g, 42f, TipoRefeicao.JANTAR)
				.adicionarAlimento(sardinha100g, 80f, TipoRefeicao.JANTAR)
				.adicionarAlimento(sucoLaranja100ml, 168f, TipoRefeicao.JANTAR)
				.adicionarAlimento(beterraba100g, 72f, TipoRefeicao.JANTAR)
				.adicionarAlimento(queijo100g, 20f, TipoRefeicao.JANTAR)
				.adicionarAlimento(goiabada100g, 20f, TipoRefeicao.JANTAR)
				.adicionarAlimento(oleo100ml, 4f, TipoRefeicao.JANTAR)
				.construir();
		
		consMCP.setCardapios(new ArrayList<Cardapio>());
		consMCP.getCardapios().add(cardMCP1);
		consMCP.getCardapios().add(cardMCP2);
		
		System.out.println(new RelatorioPlanoReeducacaoAlimentar(planoMCP).toString());
	}
}
