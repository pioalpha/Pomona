package com.github.pomona.application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.calculaIndiceMeta.AtualizarClassificacaoIMCCommand;
import com.github.pomona.application.command.calculaIndiceMeta.AtualizarFatorAtividadeFisicaCommand;
import com.github.pomona.application.command.calculaIndiceMeta.AtualizarFatorMetabolicoCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarClassificacaoIMCCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarFatorAtividadeFisicaCommand;
import com.github.pomona.application.command.calculaIndiceMeta.CadastrarFatorMetabolicoCommand;
import com.github.pomona.application.command.consulta.AgendarConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.AtualizarAntropometriaPesoAlturaNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarDiretrizAlimentarNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarPesoPacienteNaConsulta;
import com.github.pomona.application.command.consulta.AtualizarValorAntropometriaCircunferenciaNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarValorAntropometriaDobraNaConsultaCommand;
import com.github.pomona.application.command.consulta.DefinirMetaDaConsultaCommand;
import com.github.pomona.application.command.consulta.ExcluirConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.ReAgendarConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.RegistrarAntropometriaCircunferenciaNaConsultaCommand;
import com.github.pomona.application.command.consulta.RegistrarAntropometriaDobraNaConsultaCommand;
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
import com.github.pomona.domain.model.ExameAntropometrico;
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

	private static final long serialVersionUID = 1L;

	private PlanoAlimentarRepo planoAlimentarRepo;
	private CardapioRepo cardapioRepo;
	private ClassificacaoIMCRepo classificacaoIMCRepo;
	private ConsultaRepo consultaRepo;
	private DiretrizAlimentarRepo diretrizAlimentarRepo;
	private FatorAtividadeFisicaRepo fatorAtividadeFisicaRepo;
	private FatorMetabolicoRepo fatorMetabolicoRepo;
	private DivisaoRefeicaoRepo divisaoRefeicaoRepo;

	@Inject
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
	@Transactional
	public CommandResult handle(AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		DivisaoRefeicao dr = this.divisaoRefeicaoRepo().porId(new DivisaoRefeicaoId(command.getDivisaoRefeicaoId()));
		LimiteEnergetico le = new LimiteEnergetico();
		le.setDataCadastro(new Date());
		le.setTipoRefeicao(command.getTipoRefeicao());
		le.setPercentualEnergetico(command.getPercentualEnergetico());
		le.setTolerancia(command.getTolerancia());
		le.setDivisaoRefeicao(dr);
		dr.getLimitesEnergeticos().add(le);
		//this.divisaoRefeicaoRepo().adicionar(dr);

		resultado = new CommandResult(true, "Limite Energético adicionado com sucesso!", null);

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarLimiteEnergeticoDaDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarNomeDaDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		DivisaoRefeicao dr = new DivisaoRefeicao();
		dr.setNome(command.getNome());
		dr.setDivisaoRefeicaoId(this.divisaoRefeicaoRepo().proximaIdentidade());
		dr = this.divisaoRefeicaoRepo().adicionar(dr);

		resultado = new CommandResult(true, "Divisão Refeição cadastrada com sucesso!", dr.divisaoRefeicaoId().uuid());

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ExcluirDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AgendarConsultaDoPacienteCommand command) {
		CommandResult resultado = null;
		
		PlanoAlimentar pa = this.planoAlimentarRepo().porId(new PlanoAlimentarId(command.getPlanoAlimentarId())); 
		Consulta c = new Consulta();
		c.setDataConsulta(command.getDataConsulta());
		c.setConsultaId(this.consultaRepo().proximaIdentidade());
		c.setPlanoAlimentar(pa);
		c = this.consultaRepo().adicionar(c);
		pa.getConsultas().add(c);
		this.planoAlimentarRepo().adicionar(pa);
		
		resultado = new CommandResult(true, "Consulta agendada com sucesso", c.consultaId().uuid());

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ReAgendarConsultaDoPacienteCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand command) {
		CommandResult resultado = null;

		Consulta c = this.consultaRepo().porId(new ConsultaId(command.getConsultaId()));
		c.setFatorAtividadeFisica(this.fatorAtividadeFisicaRepo().porId(new FatorAtividadeFisicaId(command.getFatorAtividadeFisicaId())));
		c = this.consultaRepo().adicionar(c);
		
		resultado = new CommandResult(true, "Fator de Atividade Física atualizada com sucesso!", null);

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarPesoPacienteNaConsulta command) {
		CommandResult resultado = null;

		Consulta c = this.consultaRepo().porId(new ConsultaId(command.getConsultaId()));
		c.getExameAntropometrico().setPeso(command.getPeso());
		c.setImcConsulta(CalculaIMC.calculaIMC(c.getExameAntropometrico().getPeso(),
				c.getExameAntropometrico().getAltura())); // Automatico
		c = this.consultaRepo().adicionar(c);

		resultado = new CommandResult(true, "Peso atualizado com sucesso!", null);

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarAntropometriaPesoAlturaNaConsultaCommand command) {
		CommandResult resultado = null;

		Consulta c = this.consultaRepo().porId(new ConsultaId(command.getConsultaId()));
		if (c.getExameAntropometrico() == null) {
			c.setExameAntropometrico(new ExameAntropometrico());
		}
		c.getExameAntropometrico().setPeso(command.getPeso());
		c.getExameAntropometrico().setAltura(command.getAltura());
		c.setImcConsulta(CalculaIMC.calculaIMC(c.getExameAntropometrico().getPeso(),
				c.getExameAntropometrico().getAltura())); // Automatico
		c = this.consultaRepo().adicionar(c);
		
		resultado = new CommandResult(true, "Peso e Altura atualizados com sucesso!", null);

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(RegistrarAntropometriaCircunferenciaNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(RegistrarAntropometriaDobraNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarDiretrizAlimentarNaConsultaCommand command) {
		CommandResult resultado = null;

		Consulta c = this.consultaRepo().porId(new ConsultaId(command.getConsultaId()));
		c.setDiretrizAlimentar(this.diretrizAlimentarRepo().porId(new DiretrizAlimentarId(command.getDiretrizAlimentarId())));
		c = this.consultaRepo().adicionar(c);

		resultado = new CommandResult(true, "Diretriz Alimentar atualizada com sucesso!", null);

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarValorAntropometriaCircunferenciaNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarValorAntropometriaDobraNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(RemoverAntropometriaCircunferenciaNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(RemoverAntropometriaDobraNaConsultaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(DefinirMetaDaConsultaCommand command) {
		CommandResult resultado = null;

		PlanoAlimentar pa = this.planoAlimentarRepo().porId(new PlanoAlimentarId(command.getPlanoAlimentarId()));
		Consulta c = this.consultaRepo().porId(new ConsultaId(command.getConsultaId()));
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
			cr.setDivisaoRefeicao(this.divisaoRefeicaoRepo().porId(new DivisaoRefeicaoId(command.getDivisaoRefeicaoId())));
			cr.setCardapioId(this.cardapioRepo().proximaIdentidade());
			cr.setConsulta(c);
			cr = this.cardapioRepo().adicionar(cr);
			c.getCardapios().add(cr);
		}
		c = this.consultaRepo().adicionar(c);
		
		resultado = new CommandResult(true, "Novos cardapios gerados com sucesso!", null);

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ExcluirConsultaDoPacienteCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarClassificacaoIMCCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarFatorAtividadeFisicaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarFatorMetabolicoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarClassificacaoIMCCommand command) {
		CommandResult resultado = null;

		ClassificacaoIMC cimc = new ClassificacaoIMC();
		cimc.setSituacao(command.getSituacao());
		cimc.setImcMinimo(command.getImcMinimo());
		cimc.setImcMaximo(command.getImcMaximo());
		cimc.setClassificacaoIMCId(this.classificacaoIMCRepo().proximaIdentidade());
		cimc = this.classificacaoIMCRepo().adicionar(cimc);

		resultado = new CommandResult(true, "Classificação do IMC cadastrada com sucesso!",
				cimc.classificacaoIMCId().uuid());

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarFatorAtividadeFisicaCommand command) {
		CommandResult resultado = null;

		FatorAtividadeFisica faf = new FatorAtividadeFisica();
		faf.setDataCadastro(new Date());
		faf.setAtividade(command.getAtividade());
		faf.setFator(command.getFator());
		faf.setFatorAtividadeFisicaId(this.fatorAtividadeFisicaRepo().proximaIdentidade());
		faf = this.fatorAtividadeFisicaRepo().adicionar(faf);

		resultado = new CommandResult(true, "Fator de Atividade Física cadastrada com sucesso!",
				faf.fatorAtividadeFisicaId().uuid());

		return resultado;
	}

	@Override
	@Transactional
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
		fm = this.fatorMetabolicoRepo().adicionar(fm);

		resultado = new CommandResult(true, "Fator Metabólico cadastrado com sucesso!", fm.fatorMetabolicoId().uuid());

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
