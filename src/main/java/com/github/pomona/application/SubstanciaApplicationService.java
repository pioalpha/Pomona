package com.github.pomona.application;

import java.util.Date;

import javax.inject.Inject;
import javax.transaction.Transactional;

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
import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.DiretrizAlimentarId;
import com.github.pomona.domain.model.DiretrizAlimentarRepo;
import com.github.pomona.domain.model.EnergiaSubstancia;
import com.github.pomona.domain.model.EnergiaSubstanciaRepo;
import com.github.pomona.domain.model.NormaAlimentar;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.model.SubstanciaId;
import com.github.pomona.domain.model.SubstanciaRepo;
import com.github.pomona.domain.service.DiretrizAlimentarBuilder;
import com.github.pomona.domain.service.SubstanciaBuilder;
import com.github.pomona.service.commandHandler.SubstanciaCommandHandler;

public class SubstanciaApplicationService implements SubstanciaCommandHandler {
	
	private static final long serialVersionUID = 1L;

	private DiretrizAlimentarRepo diretrizAlimentarRepo;
	private EnergiaSubstanciaRepo energiaSubstanciaRepo;
	private SubstanciaRepo substanciaRepo;

	@Inject
	public SubstanciaApplicationService(DiretrizAlimentarRepo diretrizAlimentarRepo,
			EnergiaSubstanciaRepo energiaSubstanciaRepo, SubstanciaRepo substanciaRepo) {
		super();
		
		this.diretrizAlimentarRepo = diretrizAlimentarRepo;
		this.energiaSubstanciaRepo = energiaSubstanciaRepo;
		this.substanciaRepo = substanciaRepo;
	}

	@Override
	@Transactional
	public CommandResult handle(AdicionarNormaADiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		DiretrizAlimentar da = this.diretrizAlimentarRepo().porId(new DiretrizAlimentarId(command.getDiretrizAlimentarId()));
		NormaAlimentar na = new NormaAlimentar();
		na.setDataCriacao(new Date());
		na.setSubstancia(this.substanciaRepo().porId(new SubstanciaId(command.getSubstanciaId())));
		na.setTipoNorma(command.getTipoNorma());
		na.setNormaMinima(command.getNormaMinima());
		na.setNormaMaxima(command.getNormaMaxima());
		na.setDiretrizAlimentar(da);
		da.getNormasAlimentares().add(na);
		//this.diretrizAlimentarRepo().adicionar(da);
		
		resultado = new CommandResult(true, "Adicionado a Norma Alimentar com sucesso!", null);

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarNomeDaDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarNormaDaDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		DiretrizAlimentar da = new DiretrizAlimentarBuilder(command.getNome()).construir();
		da.setDiretrizAlimentarId(new DiretrizAlimentarId(this.diretrizAlimentarRepo().proximaIdentidade().uuid()));
		da = this.diretrizAlimentarRepo().adicionar(da);

		resultado = new CommandResult(true, "Diretriz Alimentar cadastrada com sucesso!", da.diretrizAlimentarId().uuid());

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(DesativarDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ExcluirDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ExcluirNormaDaDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarFatorEnergeticoDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		EnergiaSubstancia es = new EnergiaSubstancia();
		es.setFatorEnergetico(command.getFatorEnergetico());
		es.setSubstancia(this.substanciaRepo().porId(new SubstanciaId(command.getSubstanciaId())));
		es.setDataCadastro(new Date());
		es.setEnergiaSubstanciaId(this.energiaSubstanciaRepo().proximaIdentidade());
		es = this.energiaSubstanciaRepo().adicionar(es);
		
		resultado = new CommandResult(true, "Atualizado Fator Energético com sucesso!", null);

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarNomeDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarUnidadeDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarSubstanciaComumCommand command) {
		CommandResult resultado = null;

		Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(),
				this.substanciaRepo().proximaOrdem().intValue()).construir();
		s.setSubstanciaId(this.substanciaRepo().proximaIdentidade());
		s = this.substanciaRepo().adicionar(s);

		resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().uuid());

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarSubstanciaOrdenadaCommand command) {
		CommandResult resultado = null;

		if (command.getOrdem() <= this.substanciaRepo().proximaOrdem()) {
			for (Substancia s : this.substanciaRepo().todos()) {
				if (s.getOrdem() >= command.getOrdem()) {
					s.setOrdem(s.getOrdem() + 1);
					this.substanciaRepo().adicionar(s);
				}
			}

			Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(), command.getOrdem())
					.construir();
			s.setSubstanciaId(this.substanciaRepo().proximaIdentidade());
			s = this.substanciaRepo().adicionar(s);

			resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().uuid());
		} else {
			resultado = new CommandResult(false, "Inserção inválida: Fora da ordem!", null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarSubstanciaEnergeticaCommand command) {
		CommandResult resultado = null;

		Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(),
				this.substanciaRepo().proximaOrdem().intValue()).construir();
		s.setSubstanciaId(this.substanciaRepo().proximaIdentidade());
		s = this.substanciaRepo().adicionar(s);

		EnergiaSubstancia es = new EnergiaSubstancia();
		es.setDataCadastro(new Date());
		es.setFatorEnergetico(command.getFatorEnergetico());
		es.setSubstancia(s);
		es.setEnergiaSubstanciaId(energiaSubstanciaRepo().proximaIdentidade());
		es = this.energiaSubstanciaRepo().adicionar(es);

		resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().uuid());

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ExcluirSubstanciaCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
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
