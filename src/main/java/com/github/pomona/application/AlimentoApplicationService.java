package com.github.pomona.application;

import java.util.Date;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.alimento.AdicionarComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.AtualizarCategoriaAlimentoCommand;
import com.github.pomona.application.command.alimento.AtualizarNomeDoAlimentoCommand;
import com.github.pomona.application.command.alimento.AtualizarNomeDoTipoMedidaCommand;
import com.github.pomona.application.command.alimento.AtualizarNomeDoTipoPreparoCommand;
import com.github.pomona.application.command.alimento.AtualizarPorcaoDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.AtualizarPorcaoPreparoMedidaDoAlimentoCommand;
import com.github.pomona.application.command.alimento.AtualizarQuantidadeComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.AtualizarUnidadeDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarAlimentoUnitarioCommand;
import com.github.pomona.application.command.alimento.CadastrarCategoriaAlimentoCommand;
import com.github.pomona.application.command.alimento.CadastrarPreparoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarTipoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarTipoPreparoDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirAlimentoCommand;
import com.github.pomona.application.command.alimento.ExcluirComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.ExcluirPreparoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirTipoMedidaDoAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.ExcluirTipoPreparoDoAlimentoGranelCommand;
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.CategoriaAlimento;
import com.github.pomona.domain.model.CategoriaAlimentoId;
import com.github.pomona.domain.model.CategoriaAlimentoRepo;
import com.github.pomona.domain.model.ComponenteAlimentar;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;
import com.github.pomona.domain.model.PreparoMedidaAlimento;
import com.github.pomona.domain.model.PreparoMedidaAlimentoRepo;
import com.github.pomona.domain.model.SubstanciaId;
import com.github.pomona.domain.model.SubstanciaRepo;
import com.github.pomona.domain.model.TipoMedida;
import com.github.pomona.domain.model.TipoMedidaId;
import com.github.pomona.domain.model.TipoMedidaRepo;
import com.github.pomona.domain.model.TipoPreparo;
import com.github.pomona.domain.model.TipoPreparoId;
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
	private CategoriaAlimentoRepo categoriaAlimentoRepo;

	public AlimentoApplicationService(AlimentoRepo alimentoRepo, EnergiaAlimentoRepo energiaAlimentoRepo,
			SubstanciaRepo substanciaRepo, TipoMedidaRepo tipoMedidaRepo, TipoPreparoRepo tipoPreparoRepo,
			PreparoMedidaAlimentoRepo preparoMedidaAlimentoRepo, CategoriaAlimentoRepo categoriaAlimentoRepo) {
		super();

		this.alimentoRepo = alimentoRepo;
		this.energiaAlimentoRepo = energiaAlimentoRepo;
		this.substanciaRepo = substanciaRepo;
		this.tipoMedidaRepo = tipoMedidaRepo;
		this.tipoPreparoRepo = tipoPreparoRepo;
		this.preparoMedidaAlimentoRepo = preparoMedidaAlimentoRepo;
		this.categoriaAlimentoRepo = categoriaAlimentoRepo;
	}

	public CommandResult handle(AdicionarComponenteAlimentarCommand command) {
		CommandResult resultado = null;
		
		ComponenteAlimentar ca = new ComponenteAlimentar();
		ca.setDataCadastro(new Date());
		ca.setQuantidade(command.getQuantidade());
		ca.setSubstancia(this.substanciaRepo().objetoDeId(new SubstanciaId(command.getSubstanciaId())));
		this.alimentoRepo().objetoDeId(new AlimentoId(command.getAlimentoId())).getComposicaoAlimentar().add(ca);

		resultado = new CommandResult(true, "Componente Alimentar Adicionado com Sucesso!", null);
		
		return resultado;
	}

	public CommandResult handle(AtualizarNomeDoAlimentoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(AtualizarNomeDoTipoMedidaCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(AtualizarNomeDoTipoPreparoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(AtualizarPorcaoDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(AtualizarQuantidadeComponenteAlimentarCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(AtualizarUnidadeDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(CadastrarAlimentoGranelCommand command) {
		CommandResult resultado = null;

		AlimentoGranel ag = new AlimentoBuilder().construir(command.getNome(), command.getUnidadeGranel(),
				command.getPorcao(),
				this.categoriaAlimentoRepo().objetoDeId(new CategoriaAlimentoId(command.getCategoriaAlimentoId())));
		ag.setAlimentoId(this.alimentoRepo().proximaIdentidade());
		this.alimentoRepo().adicionar(ag);
		
		resultado = new CommandResult(true, "Alimento Cadastrado", ag.alimentoId().id());

		return resultado;
	}

	public CommandResult handle(CadastrarAlimentoUnitarioCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(CadastrarPreparoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		PreparoMedidaAlimento pma = new PreparoMedidaAlimento();
		pma.setQuantidade(command.getQuantidade());
		pma.setAlimentoGranel((AlimentoGranel) this.alimentoRepo().objetoDeId(new AlimentoId(command.getAlimentoGranelId())));
		pma.setTipoMedida(this.tipoMedidaRepo().objetoDeId(new TipoMedidaId(command.getTipoMedidaId())));
		pma.setTipoPreparo(this.tipoPreparoRepo().objetoDeId(new TipoPreparoId(command.getTipoPreparoId())));
		pma.setPreparoMedidaAlimentoId(this.preparoMedidaAlimentoRepo().proximaIdentidade());
		this.preparoMedidaAlimentoRepo().adicionar(pma);
		
		resultado = new CommandResult(true, "Medida em Preparo do Alimento cadastrado com sucesso!", pma.preparoMedidaAlimentoId().id());

		return resultado;
	}

	public CommandResult handle(CadastrarTipoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		TipoMedida tm = new TipoMedida();
		tm.setNome(command.getNome());
		tm.setTipoMedidaId(this.tipoMedidaRepo().proximaIdentidade());
		this.tipoMedidaRepo().adicionar(tm);

		resultado = new CommandResult(true, "Tipo de Medida cadastrado com sucesso!", tm.tipoMedidaId().id());

		return resultado;
	}

	public CommandResult handle(CadastrarTipoPreparoDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		TipoPreparo tp = new TipoPreparo();
		tp.setNome(command.getNome());
		tp.setTipoPreparoId(this.tipoPreparoRepo().proximaIdentidade());
		this.tipoPreparoRepo().adicionar(tp);

		resultado = new CommandResult(true, "Tipo de Preparo cadastrado com sucesso!", tp.tipoPreparoId().id());

		return resultado;
	}

	public CommandResult handle(ExcluirAlimentoCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(ExcluirComponenteAlimentarCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(ExcluirPreparoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(ExcluirTipoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	public CommandResult handle(ExcluirTipoPreparoDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarPorcaoPreparoMedidaDoAlimentoCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(AtualizarCategoriaAlimentoCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(CadastrarCategoriaAlimentoCommand command) {
		CommandResult resultado = null;

		CategoriaAlimento ca = new CategoriaAlimento();
		ca.setNome(command.getNome());
		ca.setCategoriaAlimentoId(this.categoriaAlimentoRepo().proximaIdentidade());
		this.categoriaAlimentoRepo().adicionar(ca);

		resultado = new CommandResult(true, "Categoria Alimento Cadastrada", ca.categoriaAlimentoId().id());

		return resultado;
	}

	private AlimentoRepo alimentoRepo() {
		return alimentoRepo;
	}

	private EnergiaAlimentoRepo energiaAlimentoRepo() {
		return energiaAlimentoRepo;
	}

	private SubstanciaRepo substanciaRepo() {
		return substanciaRepo;
	}

	private TipoMedidaRepo tipoMedidaRepo() {
		return tipoMedidaRepo;
	}

	private TipoPreparoRepo tipoPreparoRepo() {
		return tipoPreparoRepo;
	}

	private PreparoMedidaAlimentoRepo preparoMedidaAlimentoRepo() {
		return preparoMedidaAlimentoRepo;
	}

	private CategoriaAlimentoRepo categoriaAlimentoRepo() {
		return categoriaAlimentoRepo;
	}

}
