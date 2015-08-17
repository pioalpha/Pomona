package com.github.pomona.application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.calculaIndiceMeta.AtualizarClassificacaoIMCCommand;
import com.github.pomona.application.command.calculaIndiceMeta.AtualizarFatorAtividadeFisicaCommand;
import com.github.pomona.application.command.calculaIndiceMeta.AtualizarFatorMetabolicoCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarClassificacaoIMCCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarFatorAtividadeFisicaCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarFatorMetabolicoCommand;
import com.github.pomona.application.command.consulta.AgendarConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarPesoPacienteNaConsulta;
import com.github.pomona.application.command.consulta.AtualizarValorAntropometriaCircunferenciaNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarValorAntropometriaDobraNaConsultaCommand;
import com.github.pomona.application.command.consulta.DefinirMetaDaConsultaCommand;
import com.github.pomona.application.command.consulta.ExcluirConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.ReAgendarConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.RegistrarAntropometriaCircunferenciaNaConsultaCommand;
import com.github.pomona.application.command.consulta.RegistrarAntropometriaDobraNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarAntropometriaPesoAlturaNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarDiretrizAlimentarNaConsultaCommand;
import com.github.pomona.application.command.consulta.RemoverAntropometriaCircunferenciaNaConsultaCommand;
import com.github.pomona.application.command.consulta.RemoverAntropometriaDobraNaConsultaCommand;
import com.github.pomona.application.command.divisaoRefeicao.AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.AtualizarLimiteEnergeticoDaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.AtualizarNomeDaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.CadastrarDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.ExcluirDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand;
import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.CardapioRepo;
import com.github.pomona.domain.model.ClassificacaoIMC;
import com.github.pomona.domain.model.ClassificacaoIMCRepo;
import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.ConsultaId;
import com.github.pomona.domain.model.ConsultaRepo;
import com.github.pomona.domain.model.DiretrizAlimentarId;
import com.github.pomona.domain.model.DiretrizAlimentarRepo;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.DivisaoRefeicaoId;
import com.github.pomona.domain.model.DivisaoRefeicaoRepo;
import com.github.pomona.domain.model.FatorAtividadeFisica;
import com.github.pomona.domain.model.FatorAtividadeFisicaId;
import com.github.pomona.domain.model.FatorAtividadeFisicaRepo;
import com.github.pomona.domain.model.FatorMetabolico;
import com.github.pomona.domain.model.FatorMetabolicoRepo;
import com.github.pomona.domain.model.LimiteEnergetico;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.model.PlanoAlimentarId;
import com.github.pomona.domain.model.PlanoAlimentarRepo;
import com.github.pomona.domain.service.CalculaIMC;
import com.github.pomona.service.commandHandler.ConsultaCommandHandler;

public class ConsultaApplicationService implements ConsultaCommandHandler {

	private PlanoAlimentarRepo planoAlimentarRepo;
	private CardapioRepo cardapioRepo;
	private ClassificacaoIMCRepo classificacaoIMCRepo;
	private ConsultaRepo consultaRepo;
	private DiretrizAlimentarRepo diretrizAlimentarRepo;
	private FatorAtividadeFisicaRepo fatorAtividadeFisicaRepo;
	private FatorMetabolicoRepo fatorMetabolicoRepo;
	private DivisaoRefeicaoRepo divisaoRefeicaoRepo;

	public ConsultaApplicationService(PlanoAlimentarRepo planoAlimentarRepo, CardapioRepo cardapioRepo, ClassificacaoIMCRepo classificacaoIMCRepo,
			ConsultaRepo consultaRepo, DiretrizAlimentarRepo diretrizAlimentarRepo,
			FatorAtividadeFisicaRepo fatorAtividadeFisicaRepo, FatorMetabolicoRepo fatorMetabolicoRepo,
			DivisaoRefeicaoRepo divisaoRefeicaoRepo) {
		super();

		this.planoAlimentarRepo = planoAlimentarRepo;
		this.cardapioRepo = cardapioRepo;
		this.classificacaoIMCRepo = classificacaoIMCRepo;
		this.consultaRepo = consultaRepo;
		this.diretrizAlimentarRepo = diretrizAlimentarRepo;
		this.fatorAtividadeFisicaRepo = fatorAtividadeFisicaRepo;
		this.fatorMetabolicoRepo = fatorMetabolicoRepo;
		this.divisaoRefeicaoRepo = divisaoRefeicaoRepo;
	}

	@Override
	public CommandResult handle(AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		LimiteEnergetico le = new LimiteEnergetico();
		le.setDataCadastro(new Date());
		le.setTipoRefeicao(command.getTipoRefeicao());
		le.setPercentualEnergetico(command.getPercentualEnergetico());
		le.setTolerancia(command.getTolerancia());
		this.divisaoRefeicaoRepo().objetoDeId(new DivisaoRefeicaoId(command.getDivisaoRefeicaoId()))
				.getLimitesEnergeticos().add(le);

		resultado = new CommandResult(true, "Limite Energético adicionado com sucesso!", null);

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarLimiteEnergeticoDaDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarNomeDaDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(CadastrarDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		DivisaoRefeicao dr = new DivisaoRefeicao();
		dr.setNome(command.getNome());
		dr.setDivisaoRefeicaoId(this.divisaoRefeicaoRepo().proximaIdentidade());
		this.divisaoRefeicaoRepo().adicionar(dr);

		resultado = new CommandResult(true, "Divisão Refeição cadastrada com sucesso!", dr.divisaoRefeicaoId().id());

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AgendarConsultaDoPacienteCommand command) {
		CommandResult resultado = null;
		
		PlanoAlimentar pa = this.planoAlimentarRepo().objetoDeId(new PlanoAlimentarId(command.getPlanoAlimentarId())); 
		Consulta c = new Consulta();
		c.setDataConsulta(command.getDataConsulta());
		c.setConsultaId(this.consultaRepo().proximaIdentidade());
		c.setPlanoAlimentarId(pa.planoAlimentarId());
		this.consultaRepo().adicionar(c);
		pa.getConsultas().add(c);
		
		resultado = new CommandResult(true, "Consulta agendada com sucesso", c.consultaId().id());

		return resultado;
	}

	@Override
	public CommandResult handle(ReAgendarConsultaDoPacienteCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand command) {
		CommandResult resultado = null;

		Consulta c = this.consultaRepo().objetoDeId(new ConsultaId(command.getConsultaId()));
		c.setFatorAtividadeFisica(this.fatorAtividadeFisicaRepo().objetoDeId(new FatorAtividadeFisicaId(command.getFatorAtividadeFisicaId())));

		resultado = new CommandResult(true, "Fator de Atividade Física atualizada com sucesso!", null);

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarPesoPacienteNaConsulta command) {
		CommandResult resultado = null;

		Consulta c = this.consultaRepo().objetoDeId(new ConsultaId(command.getConsultaId()));
		c.getExameAntropometrico().setPeso(command.getPeso());
		c.setImcConsulta(CalculaIMC.calculaIMC(c.getExameAntropometrico().getPeso(),
				c.getExameAntropometrico().getAltura())); // Automatico

		resultado = new CommandResult(true, "Peso atualizado com sucesso!", null);

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarAntropometriaPesoAlturaNaConsultaCommand command) {
		CommandResult resultado = null;

		Consulta c = this.consultaRepo().objetoDeId(new ConsultaId(command.getConsultaId()));
		c.getExameAntropometrico().setPeso(command.getPeso());
		c.getExameAntropometrico().setAltura(command.getAltura());
		c.setImcConsulta(CalculaIMC.calculaIMC(c.getExameAntropometrico().getPeso(),
				c.getExameAntropometrico().getAltura())); // Automatico
		
		resultado = new CommandResult(true, "Peso e Altura atualizados com sucesso!", null);

		return resultado;
	}

	@Override
	public CommandResult handle(RegistrarAntropometriaCircunferenciaNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(RegistrarAntropometriaDobraNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarDiretrizAlimentarNaConsultaCommand command) {
		CommandResult resultado = null;

		Consulta c = this.consultaRepo().objetoDeId(new ConsultaId(command.getConsultaId()));
		c.setDiretrizAlimentar(this.diretrizAlimentarRepo().objetoDeId(new DiretrizAlimentarId(command.getDiretrizAlimentarId())));

		resultado = new CommandResult(true, "Diretriz Alimentar atualizada com sucesso!", null);

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarValorAntropometriaCircunferenciaNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarValorAntropometriaDobraNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(RemoverAntropometriaCircunferenciaNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(RemoverAntropometriaDobraNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(DefinirMetaDaConsultaCommand command) {
		CommandResult resultado = null;

		PlanoAlimentar pa = this.planoAlimentarRepo().objetoDeId(new PlanoAlimentarId(command.getPlanoAlimentarId()));
		Consulta c = this.consultaRepo().objetoDeId(new ConsultaId(command.getConsultaId()));
		c.setDataInicioVigencia(command.getDataInicioVigencia());
		c.setDataFimVigencia(command.getDataFimVigencia());
		c.setTipoMeta(command.getTipoMeta());
		c.setValorMeta(command.getValorMeta());
		c.setCaloriasAlvo(c.getTipoMeta().caloriaAlvo(pa.getPaciente(), c, c.getValorMeta())); // Automatico
		c.setCardapios(new ArrayList<Cardapio>());
		
		// Gerar cardapios
		Calendar start = Calendar.getInstance();
		start.setTime(c.getDataInicioVigencia());
		Calendar end = Calendar.getInstance();
		end.setTime(c.getDataFimVigencia());
		end.add(Calendar.DATE, 1);
		for (Date d = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), d = start.getTime()) {
			Cardapio cr = new Cardapio();
			cr.setDia(d);
			cr.setDivisaoRefeicao(this.divisaoRefeicaoRepo().objetoDeId(new DivisaoRefeicaoId(command.getDivisaoRefeicaoId())));
			cr.setCardapioId(this.cardapioRepo().proximaIdentidade());
			this.cardapioRepo().adicionar(cr);
			c.getCardapios().add(cr);
		}
		
		resultado = new CommandResult(true, "Novos cardapios gerados com sucesso!", null);

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirConsultaDoPacienteCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarClassificacaoIMCCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarFatorAtividadeFisicaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarFatorMetabolicoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(CadastrarClassificacaoIMCCommand command) {
		CommandResult resultado = null;

		ClassificacaoIMC cimc = new ClassificacaoIMC();
		cimc.setSituacao(command.getSituacao());
		cimc.setImcMinimo(command.getImcMinimo());
		cimc.setImcMaximo(command.getImcMaximo());
		cimc.setClassificacaoIMCId(this.classificacaoIMCRepo().proximaIdentidade());
		this.classificacaoIMCRepo().adicionar(cimc);

		resultado = new CommandResult(true, "Classificação do IMC cadastrada com sucesso!",
				cimc.classificacaoIMCId().id());

		return resultado;
	}

	@Override
	public CommandResult handle(CadastrarFatorAtividadeFisicaCommand command) {
		CommandResult resultado = null;

		FatorAtividadeFisica faf = new FatorAtividadeFisica();
		faf.setDataCadastro(new Date());
		faf.setAtividade(command.getAtividade());
		faf.setFator(command.getFator());
		faf.setFatorAtividadeFisicaId(this.fatorAtividadeFisicaRepo().proximaIdentidade());
		this.fatorAtividadeFisicaRepo().adicionar(faf);

		resultado = new CommandResult(true, "Fator de Atividade Física cadastrada com sucesso!",
				faf.fatorAtividadeFisicaId().id());

		return resultado;
	}

	@Override
	public CommandResult handle(CadastrarFatorMetabolicoCommand command) {
		CommandResult resultado = null;

		FatorMetabolico fm = new FatorMetabolico();
		fm.setDataCriacao(new Date());
		fm.setIdadeMinima(command.getIdadeMinima());
		fm.setIdadeMaxima(command.getIdadeMaxima());
		fm.setFatorFeminino(command.getFatorFeminino());
		fm.setDiferencialFeminino(command.getDiferencialFeminino());
		fm.setFatorMasculino(command.getFatorMasculino());
		fm.setDiferencialMasculino(command.getDiferencialMasculino());
		fm.setFatorMetabolicoId(this.fatorMetabolicoRepo().proximaIdentidade());
		this.fatorMetabolicoRepo().adicionar(fm);

		resultado = new CommandResult(true, "Fator Metabólico cadastrado com sucesso!", fm.fatorMetabolicoId().id());

		return resultado;
	}

	private PlanoAlimentarRepo planoAlimentarRepo() {
		return planoAlimentarRepo;
	}
	
	private CardapioRepo cardapioRepo() {
		return cardapioRepo;
	}

	private ClassificacaoIMCRepo classificacaoIMCRepo() {
		return classificacaoIMCRepo;
	}

	private ConsultaRepo consultaRepo() {
		return consultaRepo;
	}

	private DiretrizAlimentarRepo diretrizAlimentarRepo() {
		return diretrizAlimentarRepo;
	}

	private FatorAtividadeFisicaRepo fatorAtividadeFisicaRepo() {
		return fatorAtividadeFisicaRepo;
	}

	private FatorMetabolicoRepo fatorMetabolicoRepo() {
		return fatorMetabolicoRepo;
	}

	private DivisaoRefeicaoRepo divisaoRefeicaoRepo() {
		return divisaoRefeicaoRepo;
	}

}
