package com.github.pomona.application;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.alimento.AdicionarComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.AtualizarNomeDoAlimentoCommand;
import com.github.pomona.application.command.alimento.AtualizarNomeDoTipoMedidaCommand;
import com.github.pomona.application.command.alimento.AtualizarNomeDoTipoPreparoCommand;
import com.github.pomona.application.command.alimento.AtualizarPorcaoDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.AtualizarPorcaoPreparoMedidaDoAlimentoCommand;
import com.github.pomona.application.command.alimento.AtualizarQuantidadeComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.AtualizarUnidadeDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarAlimentoUnitarioCommand;
import com.github.pomona.application.command.alimento.CadastrarPreparoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarTipoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarTipoPreparoDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirAlimentoCommand;
import com.github.pomona.application.command.alimento.ExcluirComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.ExcluirPreparoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirTipoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirTipoPreparoDoAlimentoGranelCommand;
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;
import com.github.pomona.domain.model.PreparoMedidaAlimentoRepo;
import com.github.pomona.domain.model.SubstanciaRepo;
import com.github.pomona.domain.model.TipoMedidaRepo;
import com.github.pomona.domain.model.TipoPreparoRepo;
import com.github.pomona.domain.service.AlimentoBuilder;
import com.github.pomona.service.commandHandler.AlimentoCommandHandler;

public class AlimentoApplicationService implements AlimentoCommandHandler {
	private AlimentoRepo alimentoRepo;

	private EnergiaAlimentoRepo energiaAlimentoRepo;

	private SubstanciaRepo substanciaRepo;
	
	private TipoMedidaRepo tipoMedidaRepo;
	
	private TipoPreparoRepo tipoPreparoRepo;
	
	private PreparoMedidaAlimentoRepo preparoMedidaAlimentoRepo;

	public AlimentoApplicationService(AlimentoRepo alimentoRepo, EnergiaAlimentoRepo energiaAlimentoRepo,
			SubstanciaRepo substanciaRepo, TipoMedidaRepo tipoMedidaRepo, TipoPreparoRepo tipoPreparoRepo,
			PreparoMedidaAlimentoRepo preparoMedidaAlimentoRepo) {
		super();
		this.alimentoRepo = alimentoRepo;
		this.energiaAlimentoRepo = energiaAlimentoRepo;
		this.substanciaRepo = substanciaRepo;
		this.tipoMedidaRepo = tipoMedidaRepo;
		this.tipoPreparoRepo = tipoPreparoRepo;
		this.preparoMedidaAlimentoRepo = preparoMedidaAlimentoRepo;
	}

	public CommandResult handle(AdicionarComponenteAlimentarCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(AtualizarNomeDoAlimentoCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(AtualizarNomeDoTipoMedidaCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(AtualizarNomeDoTipoPreparoCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(AtualizarPorcaoDoAlimentoGranelCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(AtualizarQuantidadeComponenteAlimentarCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(AtualizarUnidadeDoAlimentoGranelCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(CadastrarAlimentoGranelCommand command) {
		CommandResult resultado = null;
		AlimentoGranel ag = new AlimentoBuilder().construir(command.getNome(), command.getUnidadeGranel(), command.getPorcao()); 
		ag.setAlimentoId(alimentoRepo.proximaIdentidade());
		alimentoRepo.add(ag);
		return resultado;
	}

	public CommandResult handle(CadastrarAlimentoUnitarioCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(CadastrarPreparoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(CadastrarTipoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(CadastrarTipoPreparoDoAlimentoGranelCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(ExcluirAlimentoCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(ExcluirComponenteAlimentarCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(ExcluirPreparoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(ExcluirTipoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	public CommandResult handle(ExcluirTipoPreparoDoAlimentoGranelCommand command) {
		CommandResult resultado = null;
		return resultado;
	}

	private AlimentoRepo getAlimentoRepo() {
		return alimentoRepo;
	}

	private EnergiaAlimentoRepo getEnergiaAlimentoRepo() {
		return energiaAlimentoRepo;
	}

	private SubstanciaRepo getSubstanciaRepo() {
		return substanciaRepo;
	}

	private TipoMedidaRepo getTipoMedidaRepo() {
		return tipoMedidaRepo;
	}

	private TipoPreparoRepo getTipoPreparoRepo() {
		return tipoPreparoRepo;
	}

	private PreparoMedidaAlimentoRepo getPreparoMedidaAlimentoRepo() {
		return preparoMedidaAlimentoRepo;
	}

	@Override
	public CommandResult handle(AtualizarPorcaoPreparoMedidaDoAlimentoCommand command) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
