package com.github.pomona.service.commandHandler;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.consulta.AgendarConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarPesoPacienteNaConsulta;
import com.github.pomona.application.command.consulta.AtualizarValorAntropometriaCircunferenciaNaConsultaCommand;
import com.github.pomona.application.command.consulta.AtualizarValorAntropometriaDobraNaConsultaCommand;
import com.github.pomona.application.command.consulta.DefinirMetaDaConsultaCommand;
import com.github.pomona.application.command.consulta.ExcluirConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.ReAgendarConsultaDoPacienteCommand;
import com.github.pomona.application.command.consulta.RegistrarAntropometriaCircunferenciaNaConsultaCommand;
import com.github.pomona.application.command.consulta.RegistrarAntropometriaDobraNaConsultaCommand;
import com.github.pomona.application.command.consulta.RemoverAntropometriaCircunferenciaNaConsultaCommand;
import com.github.pomona.application.command.consulta.RemoverAntropometriaDobraNaConsultaCommand;

public interface ConsultaCommandHandler {
	public CommandResult handle(AgendarConsultaDoPacienteCommand command);
	public CommandResult handle(ReAgendarConsultaDoPacienteCommand command);
	public CommandResult handle(AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand command);
	public CommandResult handle(AtualizarPesoPacienteNaConsulta command);
	public CommandResult handle(RegistrarAntropometriaCircunferenciaNaConsultaCommand command);
	public CommandResult handle(RegistrarAntropometriaDobraNaConsultaCommand command);
	public CommandResult handle(AtualizarValorAntropometriaCircunferenciaNaConsultaCommand command);
	public CommandResult handle(AtualizarValorAntropometriaDobraNaConsultaCommand command);
	public CommandResult handle(RemoverAntropometriaCircunferenciaNaConsultaCommand command);
	public CommandResult handle(RemoverAntropometriaDobraNaConsultaCommand command);
	public CommandResult handle(DefinirMetaDaConsultaCommand command);
	public CommandResult handle(ExcluirConsultaDoPacienteCommand command);
}
