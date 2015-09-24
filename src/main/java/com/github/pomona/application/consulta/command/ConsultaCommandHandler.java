package com.github.pomona.application.consulta.command;

import java.io.Serializable;

import com.github.common.application.command.CommandResult;
import com.github.pomona.application.calculaIndiceMeta.command.CalculaIndiceMetaCommandHandler;
import com.github.pomona.application.divisaoRefeicao.command.DivisaoRefeicaoCommandHandler;

public interface ConsultaCommandHandler extends CalculaIndiceMetaCommandHandler, DivisaoRefeicaoCommandHandler, Serializable {
	public CommandResult handle(AgendarConsultaDoPacienteCommand command);
	public CommandResult handle(ReAgendarConsultaDoPacienteCommand command);
	public CommandResult handle(AtualizarFatorAtividadeFisicaPacienteNaConsultaCommand command);
	public CommandResult handle(AtualizarPesoPacienteNaConsulta command);
	public CommandResult handle(RegistrarAntropometriaCircunferenciaNaConsultaCommand command);
	public CommandResult handle(RegistrarAntropometriaDobraNaConsultaCommand command);
	public CommandResult handle(AtualizarDiretrizAlimentarNaConsultaCommand command);
	public CommandResult handle(AtualizarAntropometriaPesoAlturaNaConsultaCommand command);
	public CommandResult handle(AtualizarValorAntropometriaCircunferenciaNaConsultaCommand command);
	public CommandResult handle(AtualizarValorAntropometriaDobraNaConsultaCommand command);
	public CommandResult handle(RemoverAntropometriaCircunferenciaNaConsultaCommand command);
	public CommandResult handle(RemoverAntropometriaDobraNaConsultaCommand command);
	public CommandResult handle(DefinirMetaDaConsultaCommand command);
	public CommandResult handle(ExcluirConsultaDoPacienteCommand command);
}
