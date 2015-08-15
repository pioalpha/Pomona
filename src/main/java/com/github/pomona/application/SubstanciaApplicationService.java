package com.github.pomona.application;

import java.util.Date;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.diretrizAlimentar.AdicionarNormaADiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.AtualizarNomeDaDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.AtualizarNormaDaDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.CadastrarDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.DesativarDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.ExcluirDiretrizAlimentarCommand;
import com.github.pomona.application.command.diretrizAlimentar.ExcluirNormaDaDiretrizAlimentarCommand;
import com.github.pomona.application.command.substancia.AtualizarFatorEnergeticoDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.AtualizarNomeDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.AtualizarUnidadeDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaComumCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaEnergeticaCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaOrdenadaCommand;
import com.github.pomona.application.command.substancia.ExcluirSubstanciaCommand;
import com.github.pomona.application.command.substancia.PriorizarOrdemDaSubstanciaCommand;
import com.github.pomona.domain.model.DiretrizAlimentarRepo;
import com.github.pomona.domain.model.EnergiaSubstancia;
import com.github.pomona.domain.model.EnergiaSubstanciaRepo;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.model.SubstanciaId;
import com.github.pomona.domain.model.SubstanciaRepo;
import com.github.pomona.domain.service.SubstanciaBuilder;
import com.github.pomona.service.commandHandler.SubstanciaCommandHandler;

public class SubstanciaApplicationService implements SubstanciaCommandHandler {
	private DiretrizAlimentarRepo diretrizAlimentarRepo;
	private EnergiaSubstanciaRepo energiaSubstanciaRepo;
	private SubstanciaRepo substanciaRepo;

	public SubstanciaApplicationService(DiretrizAlimentarRepo diretrizAlimentarRepo,
			EnergiaSubstanciaRepo energiaSubstanciaRepo, SubstanciaRepo substanciaRepo) {
		super();
		this.diretrizAlimentarRepo = diretrizAlimentarRepo;
		this.energiaSubstanciaRepo = energiaSubstanciaRepo;
		this.substanciaRepo = substanciaRepo;
	}

	@Override
	public CommandResult handle(AdicionarNormaADiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarNomeDaDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarNormaDaDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(CadastrarDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(DesativarDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirNormaDaDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarFatorEnergeticoDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		EnergiaSubstancia es = new EnergiaSubstancia();
		es.setFatorEnergetico(command.getFatorEnergetico());
		es.setSubstancia(this.substanciaRepo().objetoDeId(new SubstanciaId(command.getIdSubstancia())));
		es.setDataCadastro(new Date());
		es.setEnergiaSubstanciaId(this.energiaSubstanciaRepo().proximaIdentidade());
		this.energiaSubstanciaRepo().adicionar(es);
		
		resultado = new CommandResult(true, "Atualizado Fator Energético com sucesso!", null);

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarNomeDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarUnidadeDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(CadastrarSubstanciaComumCommand command) {
		CommandResult resultado = null;

		Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(),
				this.substanciaRepo().proximaOrdem()).construir();
		s.setSubstanciaId(this.substanciaRepo().proximaIdentidade());
		this.substanciaRepo().adicionar(s);

		resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().id());

		return resultado;
	}

	@Override
	public CommandResult handle(CadastrarSubstanciaOrdenadaCommand command) {
		CommandResult resultado = null;

		if (command.getOrdem() <= this.substanciaRepo().proximaOrdem()) {
			for (Substancia s : this.substanciaRepo().todosObjetos()) {
				if (s.getOrdem() >= command.getOrdem()) {
					s.setOrdem(s.getOrdem() + 1);
					this.substanciaRepo().adicionar(s);
				}
			}

			Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(), command.getOrdem())
					.construir();
			s.setSubstanciaId(this.substanciaRepo().proximaIdentidade());
			this.substanciaRepo().adicionar(s);

			resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().id());
		} else {
			resultado = new CommandResult(false, "Inserção inválida: Fora da ordem!", null);
		}

		return resultado;
	}

	@Override
	public CommandResult handle(CadastrarSubstanciaEnergeticaCommand command) {
		CommandResult resultado = null;

		Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(),
				this.substanciaRepo().proximaOrdem()).construir();
		s.setSubstanciaId(this.substanciaRepo().proximaIdentidade());
		this.substanciaRepo().adicionar(s);

		EnergiaSubstancia es = new EnergiaSubstancia();
		es.setDataCadastro(new Date());
		es.setFatorEnergetico(command.getFatorEnergetico());
		es.setSubstancia(s);
		this.energiaSubstanciaRepo().adicionar(es);

		resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().id());

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirSubstanciaCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(PriorizarOrdemDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	private DiretrizAlimentarRepo diretrizAlimentarRepo() {
		return diretrizAlimentarRepo;
	}

	private EnergiaSubstanciaRepo energiaSubstanciaRepo() {
		return energiaSubstanciaRepo;
	}

	private SubstanciaRepo substanciaRepo() {
		return substanciaRepo;
	}

}
