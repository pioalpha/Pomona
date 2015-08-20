package com.github.pomona.application;

import javax.inject.Inject;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.cardapio.AtualizarPreparoItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.AtualizarQuantidadeItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.CadastrarItemNoCardapioCommand;
import com.github.pomona.application.command.cardapio.ExcluirItemDoCardapioCommand;
import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.CardapioId;
import com.github.pomona.domain.model.CardapioRepo;
import com.github.pomona.domain.model.ConsultaRepo;
import com.github.pomona.domain.model.DivisaoRefeicaoRepo;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;
import com.github.pomona.domain.model.EnergiaSubstanciaRepo;
import com.github.pomona.domain.model.ItemCardapio;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;
import com.github.pomona.domain.model.RefeicaoCardapio;
import com.github.pomona.domain.model.TipoPreparoId;
import com.github.pomona.domain.model.TipoPreparoRepo;
import com.github.pomona.domain.service.CalculaEnergiaAlimento;
import com.github.pomona.service.commandHandler.CardapioCommandHandler;

public class CardapioApplicationService implements CardapioCommandHandler {
	
	private static final long serialVersionUID = 1L;

	private AlimentoRepo alimentoRepo;
	private CardapioRepo cardapioRepo;
	private ConsultaRepo consultaRepo;
	private EnergiaAlimentoRepo energiaAlimentarRepo;
	private EnergiaSubstanciaRepo energiaSubstanciaRepo;
	private PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo;
	private DivisaoRefeicaoRepo divisaoRefeicaoRepo;
	private TipoPreparoRepo tipoPreparoRepo;

	@Inject
	public CardapioApplicationService(AlimentoRepo alimentoRepo, CardapioRepo cardapioRepo, ConsultaRepo consultaRepo,
			EnergiaAlimentoRepo energiaAlimentarRepo, EnergiaSubstanciaRepo energiaSubstanciaRepo,
			PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo, DivisaoRefeicaoRepo divisaoRefeicaoRepo, TipoPreparoRepo tipoPreparoRepo) {
		super();

		this.alimentoRepo = alimentoRepo;
		this.cardapioRepo = cardapioRepo;
		this.consultaRepo = consultaRepo;
		this.energiaAlimentarRepo = energiaAlimentarRepo;
		this.energiaSubstanciaRepo = energiaSubstanciaRepo;
		this.perfilAlimentarPacienteRepo = perfilAlimentarPacienteRepo;
		this.divisaoRefeicaoRepo = divisaoRefeicaoRepo;
		this.tipoPreparoRepo = tipoPreparoRepo;
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
		
		ItemCardapio ic = new ItemCardapio();
		ic.setQuantidade(command.getQuantidade());
		ic.setTipoPreparo(this.tipoPreparoRepo().porId(new TipoPreparoId(command.getTipoPreparoId())));
		ic.setEnergiaAlimento(CalculaEnergiaAlimento.retornaEnergiaAlimento(this.alimentoRepo().porId(new AlimentoId(command.getAlimentoId())))); // Pega pelo alimento
		
		RefeicaoCardapio rc = new RefeicaoCardapio();
		rc.setTipoRefeicao(command.getTipoRefeicao());
		rc.getItensCardapio().add(ic);
		
		Cardapio cr = this.cardapioRepo().porId(new CardapioId(command.getCardapioId()));
		cr.getRefeicoesCardapio().add(rc);
		
		resultado = new CommandResult(true, "Alimento adicionado ao cardápio com sucesso!", null);

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
	
	private TipoPreparoRepo tipoPreparoRepo() {
		return tipoPreparoRepo;
	}
}
