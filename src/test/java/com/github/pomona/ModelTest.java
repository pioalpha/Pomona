package com.github.pomona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.github.pomona.application.AlimentoApplicationService;
import com.github.pomona.application.SubstanciaApplicationService;
import com.github.pomona.application.command.alimento.CadastrarAlimentoGranelCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaComumCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaOrdenadaCommand;
import com.github.pomona.domain.model.*;
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
import com.github.pomona.domain.service.PlanoReeducacaoAlimentarBuilder;
import com.github.pomona.domain.service.RelatorioPlanoReeducacaoAlimentar;
import com.github.pomona.domain.service.SubstanciaBuilder;
import com.github.pomona.service.commandHandler.AlimentoCommandHandler;
import com.github.pomona.service.commandHandler.SubstanciaCommandHandler;

public class ModelTest {

	public static void main(String[] args) throws ParseException {
		//SubstanciaApplicationService
		SubstanciaRepo substanciaRepoImpl = new SubstanciaRepoImpl();
		EnergiaSubstanciaRepo energiaSubstanciaRepoImpl = new EnergiaSubstanciaRepoImpl();
		DiretrizAlimentarRepo diretrizAlimentarRepoImpl = new DiretrizAlimentarRepoImpl();
		
		//AlimentoApplicationService
		AlimentoRepo alimentoRepoImpl = new AlimentoRepoImpl();
		TipoMedidaRepo tipoMedidaRepoImpl = new TipoMedidaRepoImpl();
		TipoPreparoRepo tipoPreparoRepoImpl = new TipoPreparoRepoImpl();
		PreparoMedidaAlimentoRepo preparoMedidaAlimentoRepoImpl = new PreparoMedidaAlimentoRepoImpl();
		
		//CardapioApplicationService
		EnergiaAlimentoRepo energiaAlimentoRepoImpl = new EnergiaAlimentoRepoImpl();
		DivisaoRefeicaoRepo divisaoRefeicaoRepoImpl = new DivisaoRefeicaoRepoImpl();
		CardapioRepo cardapioRepoImpl = new CardapioRepoImpl();
		
		//ConsultaApplicationService
		ClassificacaoIMCRepo classificacaoIMCRepoImpl = new ClassificacaoIMCRepoImpl();
		FatorAtividadeFisicaRepo fatorAtividadeFisicaRepoImpl = new FatorAtividadeFisicaRepoImpl();
		FatorMetabolicoRepo fatorMetabolicoRepoImpl = new FatorMetabolicoRepoImpl();
		ConsultaRepo consultaRepoImpl = new ConsultaRepoImpl();
		
		//PacienteApplicationService
		PlanoAlimentarRepo planoAlimentarRepoImpl = new PlanoAlimentarRepoImpl();
		PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepoImpl = new PerfilAlimentarPacienteRepoImpl();
		
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		
		AlimentoCommandHandler ach = new AlimentoApplicationService(alimentoRepoImpl, energiaAlimentoRepoImpl, substanciaRepoImpl, tipoMedidaRepoImpl, tipoPreparoRepoImpl, preparoMedidaAlimentoRepoImpl);
		ach.handle(new CadastrarAlimentoGranelCommand("Alimento1", UnidadeGranel.g, 100f));
		ach.handle(new CadastrarAlimentoGranelCommand("Alimento2", UnidadeGranel.ml, 100f));
		
		SubstanciaCommandHandler sch = new SubstanciaApplicationService(diretrizAlimentarRepoImpl, energiaSubstanciaRepoImpl, substanciaRepoImpl);
		sch.handle(new CadastrarSubstanciaComumCommand("Fibra", UnidadeSubstancia.g));
		sch.handle(new CadastrarSubstanciaComumCommand("Ferro", UnidadeSubstancia.mg));
		sch.handle(new CadastrarSubstanciaComumCommand("Vitamina C", UnidadeSubstancia.mg));
		sch.handle(new CadastrarSubstanciaComumCommand("Sódio", UnidadeSubstancia.mg));
		sch.handle(new CadastrarSubstanciaComumCommand("Potássio", UnidadeSubstancia.mg));
		sch.handle(new CadastrarSubstanciaComumCommand("Fosforo", UnidadeSubstancia.mg));
		sch.handle(new CadastrarSubstanciaComumCommand("Zinco", UnidadeSubstancia.mg));
		sch.handle(new CadastrarSubstanciaComumCommand("Cálcio", UnidadeSubstancia.mg));
		sch.handle(new CadastrarSubstanciaComumCommand("Magnésio", UnidadeSubstancia.mg));
		sch.handle(new CadastrarSubstanciaOrdenadaCommand("Carboidrato", UnidadeSubstancia.g, 0));
		sch.handle(new CadastrarSubstanciaOrdenadaCommand("Proteína", UnidadeSubstancia.g, 1));
		sch.handle(new CadastrarSubstanciaOrdenadaCommand("Lipídio", UnidadeSubstancia.g, 2));

		
		
		new CalculosNutricaoBuilder()
				.adicionarFatorAtividadeFisica("Sedentário", 1f)
				.adicionarFatorAtividadeFisica("Atividade Leve", 1.12f)
				.adicionarFatorAtividadeFisica("Atividade Moderada", 1.27f)
				.adicionarFatorAtividadeFisica("Atividade Intensa", 1.45f)
				
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
				.adicionarFatorMetabolico(18, 30, 15.3f, 679, 14.7f, 496)
				.adicionarFatorMetabolico(30, 60, 11.6f, 879, 8.7f, 829)
				.adicionarFatorMetabolico(60, null, 13.5f, 487, 10.5f, 596)
				.construir();
		

		Substancia carboidrato = new SubstanciaBuilder("Carboidrato", UnidadeSubstancia.g, 1).construir();
		Substancia proteina = new SubstanciaBuilder("Proteína", UnidadeSubstancia.g, 2).construir();
		Substancia lipidio = new SubstanciaBuilder("Lipídio", UnidadeSubstancia.g, 3).construir();
		Substancia fibra = new SubstanciaBuilder("Fibra", UnidadeSubstancia.g, 4).construir();
		Substancia ferro = new SubstanciaBuilder("Ferro", UnidadeSubstancia.mg, 5).construir();
		Substancia vitaminaC = new SubstanciaBuilder("Vitamina C", UnidadeSubstancia.mg, 6).construir();
		Substancia sodio = new SubstanciaBuilder("Sódio", UnidadeSubstancia.mg, 7).construir();
		Substancia potassio = new SubstanciaBuilder("Potássio", UnidadeSubstancia.mg, 8).construir();
		Substancia fosforo = new SubstanciaBuilder("Fosforo", UnidadeSubstancia.mg, 9).construir();
		Substancia zinco = new SubstanciaBuilder("Zinco", UnidadeSubstancia.mg, 10).construir();
		Substancia calcio = new SubstanciaBuilder("Cálcio", UnidadeSubstancia.mg, 11).construir();
		Substancia magnesio = new SubstanciaBuilder("Magnésio", UnidadeSubstancia.mg, 12).construir();

		
		AlimentoUnitario abacate = new AlimentoBuilder()
				.adicionarComponenteAlimentar(proteina, 1.9f)
				.adicionarComponenteAlimentar(lipidio, 18.7f)
				.adicionarComponenteAlimentar(carboidrato, 5.2f)
				.adicionarComponenteAlimentar(fibra, 1.4f)
				.adicionarComponenteAlimentar(ferro, 0.9f)
				.adicionarComponenteAlimentar(vitaminaC, 11f)
				.adicionarComponenteAlimentar(sodio, 46f)
				.adicionarComponenteAlimentar(potassio, 340f)
				.adicionarComponenteAlimentar(fosforo, 46f)
				.adicionarComponenteAlimentar(zinco, 1.9f)
				.adicionarComponenteAlimentar(calcio, 25f)
				.adicionarComponenteAlimentar(magnesio, 18f)
				.construir("Abacate");
		
		
		CalculaEnergiaAlimento calcEne = new CalculaEnergiaBuilder()
				.adicionarEnergiaSubstancia(proteina, 4f)
				.adicionarEnergiaSubstancia(lipidio, 9f)
				.adicionarEnergiaSubstancia(carboidrato, 4f)
				.adicionarEnergiaAlimento(abacate, 1.9f * 4 + 18.7f * 9 + 5.2f * 4)
				.construir();
		
		
		DiretrizAlimentar dirDiabetico = new DiretrizAlimentarBuilder("Diretriz Diabético")
				.adicionarNormaAlimentar(proteina, TipoNorma.PERCENTUAL, 10f, 25f)
				.adicionarNormaAlimentar(lipidio, TipoNorma.PERCENTUAL, 20f, 35f)
				.adicionarNormaAlimentar(carboidrato, TipoNorma.PERCENTUAL, 45f, 65f)
				.construir();

		DiretrizAlimentar dirPadrao = new DiretrizAlimentarBuilder("Diretriz Padrão")
				.adicionarNormaAlimentar(proteina, TipoNorma.PERCENTUAL, 10f, 15f)
				.adicionarNormaAlimentar(lipidio, TipoNorma.PERCENTUAL, 10f, 30f)
				.adicionarNormaAlimentar(carboidrato, TipoNorma.PERCENTUAL, 55f, 75f)
				.construir();

		
		DivisaoRefeicao div4Refeicoes = new DivisaoRefeicaoBuilder("4 Refeições")
				.adicionarLimiteEnergetico(TipoRefeicao.DESEJUM, 20f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.ALMOCO, 40f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.LANCHE, 10f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.JANTAR, 30f, 40f)
				.construir();
		
		DivisaoRefeicao div6Refeicoes = new DivisaoRefeicaoBuilder("6 Refeições")
				.adicionarLimiteEnergetico(TipoRefeicao.DESEJUM, 15f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.COLACAO, 5f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.ALMOCO, 30f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.LANCHE, 15f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.JANTAR, 30f, 40f)
				.adicionarLimiteEnergetico(TipoRefeicao.CEIA, 5f, 40f)
				.construir();
		
		PlanoReeducacaoAlimentar planoPedro = new PlanoReeducacaoAlimentarBuilder(
				"Pedro", (Date)format.parse("29/06/1978"), 1.71f, TipoSexo.MASCULINO)
				.comPerfilAlimentar(abacate, PreferenciaConsumo.REJEITA)
				.construir();
		
		Consulta consPedro = new ConsultaBuilder(new Date(), 90f, dirDiabetico,
				CalculaREE.getFatoresAtividadeFisica().get(0), planoPedro)
				.definirMeta(TipoMeta.IMC, 29f)
				.construir();
		
		planoPedro.setConsultas(new ArrayList<Consulta>());
		planoPedro.getConsultas().add(consPedro);
		
		Cardapio cardPedro1 = new CardapioBuilder(new Date(), div4Refeicoes, calcEne)
				.adicionarAlimento(abacate, 2f, TipoRefeicao.DESEJUM)
				.construir();
		
		Cardapio cardPedro2 = new CardapioBuilder(new Date(), div6Refeicoes, calcEne)
				.adicionarAlimento(abacate, 2f, TipoRefeicao.ALMOCO)
				.construir();
		
		consPedro.setCardapios(new ArrayList<Cardapio>());
		consPedro.getCardapios().add(cardPedro1);
		consPedro.getCardapios().add(cardPedro2);
		
		System.out.println(new RelatorioPlanoReeducacaoAlimentar(planoPedro).toString());
		for(Object o : substanciaRepoImpl.todasSubstancias()){
			System.out.println(o.toString());
		}
		for(Object o : alimentoRepoImpl.todosAlimentos()){
			System.out.println(o.toString());
		}
	}
}
