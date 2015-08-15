package com.github.pomona.application;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.cardapio.AtualizarPreparoItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.AtualizarQuantidadeItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.CadastrarItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.ExcluirItemDoCardapioCommand;
import com.github.pomona.application.command.divisaoRefeicao.AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.AtualizarLimiteEnergeticoDaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.AtualizarNomeDaDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.CadastrarDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.ExcluirDivisaoRefeicaoCommand;
import com.github.pomona.application.command.divisaoRefeicao.ExcluirLimiteEnergeticoDaDivisaoRefeicaoCommand;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.CardapioRepo;
import com.github.pomona.domain.model.ClassificacaoIMCRepo;
import com.github.pomona.domain.model.ConsultaRepo;
import com.github.pomona.domain.model.DiretrizAlimentarRepo;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;
import com.github.pomona.domain.model.EnergiaSubstanciaRepo;
import com.github.pomona.domain.model.FatorAtividadeFisicaRepo;
import com.github.pomona.domain.model.FatorMetabolicoRepo;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;
import com.github.pomona.domain.model.PlanoAlimentarRepo;
import com.github.pomona.domain.model.SubstanciaRepo;
import com.github.pomona.service.commandHandler.CardapioCommandHandler;

public class CardapioApplicationService implements CardapioCommandHandler {

	private AlimentoRepo alimentoRepo;
	private CardapioRepo cardapioRepo;
	private ClassificacaoIMCRepo classificacaoIMCRepo;
	private ConsultaRepo consultaRepo;
	private DiretrizAlimentarRepo diretrizAlimentarRepo;
	private EnergiaAlimentoRepo energiaAlimentarRepo;
	private EnergiaSubstanciaRepo energiaSubstanciaRepo;
	private FatorAtividadeFisicaRepo fatorAtividadeFisicaRepo;
	private FatorMetabolicoRepo fatorMetabolicoRepo;
	private PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo;
	private PlanoAlimentarRepo planoAlimentarRepo;
	private SubstanciaRepo substanciaRepo;

	@Override
	public CommandResult handle(AdicionarLimiteEnergeticoNaDivisaoRefeicaoCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

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
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

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
	public CommandResult handle(AtualizarPreparoItemNoCardapioCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarQuantidadeItemNoCardapioCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(CadastrarItemNoCardapioCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirItemDoCardapioCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

}
