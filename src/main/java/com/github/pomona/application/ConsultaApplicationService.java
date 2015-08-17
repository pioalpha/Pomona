package com.github.pomona.application;

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
import com.github.pomona.application.command.consulta.RemoverAntropometriaCircunferenciaNaConsultaCommand;
import com.github.pomona.application.command.consulta.RemoverAntropometriaDobraNaConsultaCommand;
import com.github.pomona.domain.model.CardapioRepo;
import com.github.pomona.domain.model.ClassificacaoIMC;
import com.github.pomona.domain.model.ClassificacaoIMCRepo;
import com.github.pomona.domain.model.ConsultaRepo;
import com.github.pomona.domain.model.DiretrizAlimentarRepo;
import com.github.pomona.domain.model.FatorAtividadeFisica;
import com.github.pomona.domain.model.FatorAtividadeFisicaRepo;
import com.github.pomona.domain.model.FatorMetabolico;
import com.github.pomona.domain.model.FatorMetabolicoRepo;
import com.github.pomona.service.commandHandler.ConsultaCommandHandler;

public class ConsultaApplicationService implements ConsultaCommandHandler {

	private CardapioRepo cardapioRepo;
	private ClassificacaoIMCRepo classificacaoIMCRepo;
	private ConsultaRepo consultaRepo;
	private DiretrizAlimentarRepo diretrizAlimentarRepo;
	private FatorAtividadeFisicaRepo fatorAtividadeFisicaRepo;
	private FatorMetabolicoRepo fatorMetabolicoRepo;

	public ConsultaApplicationService(CardapioRepo cardapioRepo, ClassificacaoIMCRepo classificacaoIMCRepo,
			ConsultaRepo consultaRepo, DiretrizAlimentarRepo diretrizAlimentarRepo,
			FatorAtividadeFisicaRepo fatorAtividadeFisicaRepo, FatorMetabolicoRepo fatorMetabolicoRepo) {
		super();
		
		this.cardapioRepo = cardapioRepo;
		this.classificacaoIMCRepo = classificacaoIMCRepo;
		this.consultaRepo = consultaRepo;
		this.diretrizAlimentarRepo = diretrizAlimentarRepo;
		this.fatorAtividadeFisicaRepo = fatorAtividadeFisicaRepo;
		this.fatorMetabolicoRepo = fatorMetabolicoRepo;
	}

	@Override
	public CommandResult handle(AgendarConsultaDoPacienteCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

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

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarPesoPacienteNaConsulta command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

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

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

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
		
		resultado = new CommandResult(true, "Classificação do IMC cadastrada com sucesso!", cimc.classificacaoIMCId().id());

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
		
		resultado = new CommandResult(true, "Fator de Atividade Física cadastrada com sucesso!", faf.fatorAtividadeFisicaId().id());

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

}
