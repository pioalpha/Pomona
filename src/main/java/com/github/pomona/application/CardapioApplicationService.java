package com.github.pomona.application;

import java.util.Date;

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
import com.github.pomona.domain.model.ConsultaRepo;
import com.github.pomona.domain.model.DivisaoRefeicao;
import com.github.pomona.domain.model.DivisaoRefeicaoId;
import com.github.pomona.domain.model.DivisaoRefeicaoRepo;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;
import com.github.pomona.domain.model.EnergiaSubstanciaRepo;
import com.github.pomona.domain.model.LimiteEnergetico;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;
import com.github.pomona.service.commandHandler.CardapioCommandHandler;

public class CardapioApplicationService implements CardapioCommandHandler {

	private AlimentoRepo alimentoRepo;
	private CardapioRepo cardapioRepo;
	private ConsultaRepo consultaRepo;
	private EnergiaAlimentoRepo energiaAlimentarRepo;
	private EnergiaSubstanciaRepo energiaSubstanciaRepo;
	private PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo;
	private DivisaoRefeicaoRepo divisaoRefeicaoRepo;

	public CardapioApplicationService(AlimentoRepo alimentoRepo, CardapioRepo cardapioRepo, ConsultaRepo consultaRepo,
			EnergiaAlimentoRepo energiaAlimentarRepo, EnergiaSubstanciaRepo energiaSubstanciaRepo,
			PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo, DivisaoRefeicaoRepo divisaoRefeicaoRepo) {
		super();

		this.alimentoRepo = alimentoRepo;
		this.cardapioRepo = cardapioRepo;
		this.consultaRepo = consultaRepo;
		this.energiaAlimentarRepo = energiaAlimentarRepo;
		this.energiaSubstanciaRepo = energiaSubstanciaRepo;
		this.perfilAlimentarPacienteRepo = perfilAlimentarPacienteRepo;
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
		this.divisaoRefeicaoRepo().objetoDeId(new DivisaoRefeicaoId(command.getDivisaoRefeicaoId())).getLimitesEnergeticos().add(le);

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

	private AlimentoRepo alimentoRepo() {
		return alimentoRepo;
	}

	private CardapioRepo cardapioRepo() {
		return cardapioRepo;
	}

	private ConsultaRepo consultaRepo() {
		return consultaRepo;
	}

	private EnergiaAlimentoRepo energiaAlimentarRepo() {
		return energiaAlimentarRepo;
	}

	private EnergiaSubstanciaRepo energiaSubstanciaRepo() {
		return energiaSubstanciaRepo;
	}

	private PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo() {
		return perfilAlimentarPacienteRepo;
	}

	private DivisaoRefeicaoRepo divisaoRefeicaoRepo() {
		return divisaoRefeicaoRepo;
	}

}
