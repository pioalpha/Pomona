package com.github.pomona.application.cardapio.command;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.github.common.application.command.CommandResult;
import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.Cardapio;
import com.github.pomona.domain.model.CardapioId;
import com.github.pomona.domain.model.CardapioRepo;
import com.github.pomona.domain.model.ConsultaRepo;
import com.github.pomona.domain.model.DivisaoRefeicaoRepo;
import com.github.pomona.domain.model.EnergiaAlimento;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;
import com.github.pomona.domain.model.EnergiaSubstanciaRepo;
import com.github.pomona.domain.model.ItemCardapio;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;
import com.github.pomona.domain.model.RefeicaoCardapio;
import com.github.pomona.domain.model.TipoApresentacaoId;
import com.github.pomona.domain.model.TipoApresentacaoRepo;
import com.github.pomona.domain.service.CalculaEnergiaAlimento;

@RequestScoped
public class CardapioApplicationService implements CardapioCommandHandler {
	
	private static final long serialVersionUID = 1L;

	private AlimentoRepo alimentoRepo;
	private CardapioRepo cardapioRepo;
	private ConsultaRepo consultaRepo;
	private EnergiaAlimentoRepo energiaAlimentarRepo;
	private EnergiaSubstanciaRepo energiaSubstanciaRepo;
	private PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo;
	private DivisaoRefeicaoRepo divisaoRefeicaoRepo;
	private TipoApresentacaoRepo tipoApresentacaoRepo;

	@Inject
	public CardapioApplicationService(AlimentoRepo alimentoRepo, CardapioRepo cardapioRepo, ConsultaRepo consultaRepo,
			EnergiaAlimentoRepo energiaAlimentarRepo, EnergiaSubstanciaRepo energiaSubstanciaRepo,
			PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo, DivisaoRefeicaoRepo divisaoRefeicaoRepo, TipoApresentacaoRepo tipoApresentacaoRepo) {
		super();

		this.alimentoRepo = alimentoRepo;
		this.cardapioRepo = cardapioRepo;
		this.consultaRepo = consultaRepo;
		this.energiaAlimentarRepo = energiaAlimentarRepo;
		this.energiaSubstanciaRepo = energiaSubstanciaRepo;
		this.perfilAlimentarPacienteRepo = perfilAlimentarPacienteRepo;
		this.divisaoRefeicaoRepo = divisaoRefeicaoRepo;
		this.tipoApresentacaoRepo = tipoApresentacaoRepo;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarApresentacaoItemNoCardapioCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarQuantidadeItemNoCardapioCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarItemNoCardapioCommand command) {
		CommandResult resultado = null;
		
		//TODO ele não deve gerar uma nova energia toda hora
		EnergiaAlimento ea = CalculaEnergiaAlimento.retornaEnergiaAlimento(this.alimentoRepo().porId(new AlimentoId(command.getAlimentoId())));
		ea.setEnergiaAlimentoId(this.energiaAlimentarRepo().proximaIdentidade());
		ea = this.energiaAlimentarRepo().adicionar(ea);  // Pega pelo alimento
		
		Cardapio cr = this.cardapioRepo().porId(new CardapioId(command.getCardapioId()));
		
		RefeicaoCardapio rc = new RefeicaoCardapio();
		rc.setTipoRefeicao(command.getTipoRefeicao());
		rc.setCardapio(cr);

		ItemCardapio ic = new ItemCardapio();
		ic.setQuantidade(command.getQuantidade());
		ic.setTipoApresentacao(this.tipoApresentacaoRepo().porId(new TipoApresentacaoId(command.getTipoApresentacaoId())));
		ic.setEnergiaAlimento(ea);
		ic.setRefeicaoCardapio(rc);

		rc.getItensCardapio().add(ic);
		
		cr.getRefeicoesCardapio().add(rc);
		//cr = this.cardapioRepo().adicionar(cr);
		
		resultado = new CommandResult(true, "Alimento adicionado ao cardápio com sucesso!", null);

		return resultado;
	}

	@Override
	@Transactional
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
	
	private TipoApresentacaoRepo tipoApresentacaoRepo() {
		return tipoApresentacaoRepo;
	}
}
