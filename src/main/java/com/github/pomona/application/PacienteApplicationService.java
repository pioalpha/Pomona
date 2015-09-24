package com.github.pomona.application;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

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
import com.github.pomona.domain.model.PacienteRepo;
import com.github.pomona.domain.model.PerfilAlimentarPaciente;
import com.github.pomona.domain.model.PerfilAlimentarPacienteRepo;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.model.PlanoAlimentarId;
import com.github.pomona.domain.model.PlanoAlimentarRepo;
import com.github.pomona.service.commandHandler.PacienteCommandHandler;

@RequestScoped
public class PacienteApplicationService implements PacienteCommandHandler {

	private static final long serialVersionUID = 1L;

	private AlimentoRepo alimentoRepo;
	private CategoriaAlimentoRepo categoriaAlimentoRepo;
	private PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo;
	private PlanoAlimentarRepo planoAlimentarRepo;
	private PacienteRepo pacienteRepo;

	@Inject
	public PacienteApplicationService(AlimentoRepo alimentoRepo, CategoriaAlimentoRepo categoriaAlimentoRepo,
			PerfilAlimentarPacienteRepo perfilAlimentarPacienteRepo, PlanoAlimentarRepo planoAlimentarRepo, PacienteRepo pacienteRepo) {
		super();
		
		this.alimentoRepo = alimentoRepo;
		this.categoriaAlimentoRepo = categoriaAlimentoRepo;
		this.perfilAlimentarPacienteRepo = perfilAlimentarPacienteRepo;
		this.planoAlimentarRepo = planoAlimentarRepo;
		this.pacienteRepo = pacienteRepo;
	}

	@Override
	@Transactional
	public CommandResult handle(AdicionarPerfilAlimentarAoPacienteCommand command) {
		CommandResult resultado = null;

		//PlanoAlimentar pa = this.planoAlimentarRepo().porId(new PlanoAlimentarId(command.getPlanoAlimentarId()));
		Paciente p = this.planoAlimentarRepo().porId(new PlanoAlimentarId(command.getPlanoAlimentarId())).getPaciente();
		
		PerfilAlimentarPaciente pap = new PerfilAlimentarPaciente();
		pap.setAlimento(this.alimentoRepo().porId(new AlimentoId(command.getAlimentoId())));
		pap.setCategoriaAlimento(null);
		pap.setDataCadastro(new Date());
		pap.setPreferenciaConsumo(command.getPreferenciaConsumo());
		pap.setPaciente(p);
		pap.setPerfilAlimentarPacienteId(this.perfilAlimentarPacienteRepo().proximaIdentidade());
		pap = this.perfilAlimentarPacienteRepo().adicionar(pap);
		p.getPerfilAlimentarPaciente().add(pap);
		this.pacienteRepo().adicionar(p);
		
		resultado = new CommandResult(true, "Perfil Alimentar do Paciente adicionado com sucesso!", pap.perfilAlimentarPacienteId().uuid());

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AdicionarPerfilCategoriaAlimentarAoPacienteCommand command) {
		CommandResult resultado = null;

		Paciente p = this.planoAlimentarRepo().porId(new PlanoAlimentarId(command.getPlanoAlimentarId())).getPaciente();
		
		PerfilAlimentarPaciente pap = new PerfilAlimentarPaciente();
		pap.setAlimento(null);
		pap.setCategoriaAlimento(this.categoriaAlimentoRepo().porId(new CategoriaAlimentoId(command.getCategoriaAlimentoId())));
		pap.setDataCadastro(new Date());
		pap.setPreferenciaConsumo(command.getPreferenciaConsumo());
		pap.setPaciente(p);
		pap.setPerfilAlimentarPacienteId(this.perfilAlimentarPacienteRepo().proximaIdentidade());
		pap = this.perfilAlimentarPacienteRepo().adicionar(pap);
		p.getPerfilAlimentarPaciente().add(pap);
		this.pacienteRepo().adicionar(p);
		
		resultado = new CommandResult(true, "Perfil de Categoria Alimentar do Paciente adicionada com sucesso!", pap.perfilAlimentarPacienteId().uuid());

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarCorPeleDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarNomeDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarPerfilAlimentarDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarSexoDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CorrigirDataNascimentoDoPacienteCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(true, "", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CriarPlanoAlimentarDoPacienteCommand command) {
		CommandResult resultado = null;
		
		Paciente p = new Paciente();
		p.setDataNascimento(command.getDataNascimento());
		p.setNome(command.getNome());
		p.setPacienteId(null);
		p.setTipoSexo(command.getTipoSexo());
		p.setTipoCorPele(command.getTipoCorPele());
		p.setPacienteId(this.pacienteRepo().proximaIdentidade());
		p = this.pacienteRepo().adicionar(p);
		//this.pacienteRepo().adicionar(p);
		
		PlanoAlimentar pa = new PlanoAlimentar();
		pa.setPaciente(p);
		pa.setPlanoAlimentarId(this.planoAlimentarRepo().proximaIdentidade());
		pa = this.planoAlimentarRepo().adicionar(pa);

		resultado = new CommandResult(true, "Plano Alimentar cadastrado com sucesso!", pa.planoAlimentarId().uuid());

		return resultado;
	}

	@Override
	@Transactional
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

	private PacienteRepo pacienteRepo() {
		return pacienteRepo;
	}

}
