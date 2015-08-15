package com.github.pomona.application;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.paciente.AdicionarPerfilAlimentarAoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarCorPeleDoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarNomeDoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarPerfilAlimentarDoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarSexoDoPacienteCommand;
import com.github.pomona.application.command.paciente.CorrigirAlturaDoPacienteCommand;
import com.github.pomona.application.command.paciente.CorrigirDataNascimentoDoPacienteCommand;
import com.github.pomona.application.command.paciente.CriarPlanoAlimentarDoPacienteCommand;
import com.github.pomona.application.command.paciente.ExcluirPerfilAlimentarDoPacienteCommand;
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
import com.github.pomona.service.commandHandler.PacienteCommandHandler;

public class PacienteApplicationService implements PacienteCommandHandler {

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
	public CommandResult handle(AdicionarPerfilAlimentarAoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarCorPeleDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarNomeDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarPerfilAlimentarDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(AtualizarSexoDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(CorrigirAlturaDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(CorrigirDataNascimentoDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(CriarPlanoAlimentarDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirPerfilAlimentarDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

}
