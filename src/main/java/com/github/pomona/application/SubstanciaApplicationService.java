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
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.CardapioRepo;
import com.github.pomona.domain.model.ClassificacaoIMCRepo;
import com.github.pomona.domain.model.ConsultaRepo;
import com.github.pomona.domain.model.DiretrizAlimentarRepo;
import com.github.pomona.domain.model.EnergiaAlimentoRepo;
import com.github.pomona.domain.model.EnergiaSubstancia;
import com.github.pomona.domain.model.EnergiaSubstanciaRepo;
import com.github.pomona.domain.model.FatorAtividadeFisicaRepo;
import com.github.pomona.domain.model.FatorMetabolicoRepo;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;
import com.github.pomona.domain.model.PlanoAlimentarRepo;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.model.SubstanciaRepo;
import com.github.pomona.domain.service.AlimentoBuilder;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(AtualizarNomeDaDiretrizAlimentarCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(AtualizarNormaDaDiretrizAlimentarCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(CadastrarDiretrizAlimentarCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(DesativarDiretrizAlimentarCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(ExcluirDiretrizAlimentarCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(ExcluirNormaDaDiretrizAlimentarCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(AtualizarFatorEnergeticoDaSubstanciaCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(AtualizarNomeDaSubstanciaCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(AtualizarUnidadeDaSubstanciaCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(CadastrarSubstanciaComumCommand command) {
		CommandResult resultado = null;

		Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(), substanciaRepo.proximaOrdem()).construir(); 
		s.setSubstanciaId(substanciaRepo.proximaIdentidade());
		substanciaRepo.add(s);

		resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().id());

		return resultado;
	}
	
	@Override
	public CommandResult handle(CadastrarSubstanciaOrdenadaCommand command) {
		CommandResult resultado = null;
		if (command.getOrdem() <= substanciaRepo.proximaOrdem()){
			for (Substancia s : substanciaRepo.todasSubstancias()){
				if (s.getOrdem() >= command.getOrdem()){
					s.setOrdem(s.getOrdem()+1);
					substanciaRepo.add(s);
				}
			}
			
			Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(), command.getOrdem()).construir(); 
			s.setSubstanciaId(substanciaRepo.proximaIdentidade());
			substanciaRepo.add(s);

			resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().id());
		}else{
			resultado = new CommandResult(false, "Inserção inválida: Fora da ordem!", null);
		}
		return resultado;
	}
	
	@Override
	public CommandResult handle(CadastrarSubstanciaEnergeticaCommand command) {
		CommandResult resultado = null;

		Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(), substanciaRepo.proximaOrdem()).construir(); 
		s.setSubstanciaId(substanciaRepo.proximaIdentidade());
		substanciaRepo.add(s);

		EnergiaSubstancia es = new EnergiaSubstancia();
		es.setDataCadastro(new Date());
		es.setFatorEnergetico(command.getFatorEnergetico());
		es.setSubstancia(s);
		energiaSubstanciaRepo.add(es);
		
		resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().id());

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirSubstanciaCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult handle(PriorizarOrdemDaSubstanciaCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	private DiretrizAlimentarRepo getDiretrizAlimentarRepo() {
		return diretrizAlimentarRepo;
	}

	private EnergiaSubstanciaRepo getEnergiaSubstanciaRepo() {
		return energiaSubstanciaRepo;
	}

	private SubstanciaRepo getSubstanciaRepo() {
		return substanciaRepo;
	}

	
}
