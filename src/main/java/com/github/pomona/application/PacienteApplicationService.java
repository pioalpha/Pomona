package com.github.pomona.application;

import java.util.Date;

import com.github.common.service.command.CommandResult;
import com.github.pomona.application.command.paciente.AdicionarPerfilAlimentarAoPacienteCommand;
import com.github.pomona.application.command.paciente.AdicionarPerfilCategoriaAlimentarAoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarCorPeleDoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarNomeDoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarPerfilAlimentarDoPacienteCommand;
import com.github.pomona.application.command.paciente.AtualizarSexoDoPacienteCommand;
import com.github.pomona.application.command.paciente.CorrigirDataNascimentoDoPacienteCommand;
import com.github.pomona.application.command.paciente.CriarPlanoAlimentarDoPacienteCommand;
import com.github.pomona.application.command.paciente.ExcluirPerfilAlimentarDoPacienteCommand;
import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.CategoriaAlimentoId;
import com.github.pomona.domain.model.CategoriaAlimentoRepo;
import com.github.pomona.domain.model.Paciente;
import com.github.pomona.domain.model.PerfilAlimentarPaciente;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.model.PlanoAlimentarId;
import com.github.pomona.domain.model.PlanoAlimentarRepo;
import com.github.pomona.service.commandHandler.PacienteCommandHandler;

public class PacienteApplicationService implements PacienteCommandHandler {

	private AlimentoRepo alimentoRepo;
	private CategoriaAlimentoRepo categoriaAlimentoRepo;
	private PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo;
	private PlanoAlimentarRepo planoAlimentarRepo;

	public PacienteApplicationService(AlimentoRepo alimentoRepo, CategoriaAlimentoRepo categoriaAlimentoRepo,
			PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo, PlanoAlimentarRepo planoAlimentarRepo) {
		super();
		
		this.alimentoRepo = alimentoRepo;
		this.categoriaAlimentoRepo = categoriaAlimentoRepo;
		this.perfilAlimentarPacienteRepo = perfilAlimentarPacienteRepo;
		this.planoAlimentarRepo = planoAlimentarRepo;
	}

	@Override
	public CommandResult handle(AdicionarPerfilAlimentarAoPacienteCommand command) {
		CommandResult resultado = null;

		PlanoAlimentar pa = this.planoAlimentarRepo().objetoDeId(new PlanoAlimentarId(command.getPlanoAlimentarId()));
		
		PerfilAlimentarPaciente pap = new PerfilAlimentarPaciente();
		pap.setAlimento(this.alimentoRepo().objetoDeId(new AlimentoId(command.getAlimentoId())));
		pap.setCategoriaAlimento(null);
		pap.setDataCadastro(new Date());
		pap.setPreferenciaConsumo(command.getPreferenciaConsumo());
		pap.setPlanoAlimentarId(pa.planoAlimentarId());
		pap.setPerfilAlimentarPacienteId(this.perfilAlimentarPacienteRepo().proximaIdentidade());
		this.perfilAlimentarPacienteRepo().adicionar(pap);
		pa.getPerfilAlimentarPaciente().add(pap);
		
		resultado = new CommandResult(true, "Perfil Alimentar do Paciente adicionado com sucesso!", pap.perfilAlimentarPacienteId().id());

		return resultado;
	}

	@Override
	public CommandResult handle(AdicionarPerfilCategoriaAlimentarAoPacienteCommand command) {
		CommandResult resultado = null;

		PlanoAlimentar pa = this.planoAlimentarRepo().objetoDeId(new PlanoAlimentarId(command.getPlanoAlimentarId()));
		
		PerfilAlimentarPaciente pap = new PerfilAlimentarPaciente();
		pap.setAlimento(null);
		pap.setCategoriaAlimento(this.categoriaAlimentoRepo().objetoDeId(new CategoriaAlimentoId(command.getCategoriaAlimentoId())));
		pap.setDataCadastro(new Date());
		pap.setPreferenciaConsumo(command.getPreferenciaConsumo());
		pap.setPlanoAlimentarId(pa.planoAlimentarId());
		pap.setPerfilAlimentarPacienteId(this.perfilAlimentarPacienteRepo().proximaIdentidade());
		this.perfilAlimentarPacienteRepo().adicionar(pap);
		pa.getPerfilAlimentarPaciente().add(pap);
		
		resultado = new CommandResult(true, "Perfil de Categoria Alimentar do Paciente adicionada com sucesso!", pap.perfilAlimentarPacienteId().id());

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
	public CommandResult handle(CorrigirDataNascimentoDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	public CommandResult handle(CriarPlanoAlimentarDoPacienteCommand command) {
		CommandResult resultado = null;
		
		Paciente p = new Paciente();
		p.setDataNascimento(command.getDataNascimento());
		p.setNome(command.getNome());
		p.setPacienteId(null);
		p.setTipoSexo(command.getTipoSexo());
		p.setTipoCorPele(command.getTipoCorPele());
		
		PlanoAlimentar pa = new PlanoAlimentar();
		pa.setPaciente(p);
		pa.setPlanoAlimentarId(this.planoAlimentarRepo().proximaIdentidade());
		this.planoAlimentarRepo().adicionar(pa);

		resultado = new CommandResult(true, "Plano Alimentar cadastrado com sucesso!", pa.planoAlimentarId().id());

		return resultado;
	}

	@Override
	public CommandResult handle(ExcluirPerfilAlimentarDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	private AlimentoRepo alimentoRepo() {
		return alimentoRepo;
	}

	private CategoriaAlimentoRepo categoriaAlimentoRepo() {
		return categoriaAlimentoRepo;
	}

	private PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo() {
		return perfilAlimentarPacienteRepo;
	}

	private PlanoAlimentarRepo planoAlimentarRepo() {
		return planoAlimentarRepo;
	}

}
