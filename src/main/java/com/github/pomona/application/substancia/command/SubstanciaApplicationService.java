package com.github.pomona.application.substancia.command;

import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang3.time.DateUtils;

import com.github.common.application.command.CommandResult;
import com.github.pomona.application.diretrizAlimentar.command.AdicionarNormaADiretrizAlimentarCommand;
import com.github.pomona.application.diretrizAlimentar.command.AtualizarNomeDaDiretrizAlimentarCommand;
import com.github.pomona.application.diretrizAlimentar.command.AtualizarNormaDaDiretrizAlimentarCommand;
import com.github.pomona.application.diretrizAlimentar.command.CadastrarDiretrizAlimentarCommand;
import com.github.pomona.application.diretrizAlimentar.command.DesativarDiretrizAlimentarCommand;
import com.github.pomona.application.diretrizAlimentar.command.ExcluirDiretrizAlimentarCommand;
import com.github.pomona.application.diretrizAlimentar.command.ExcluirNormaDaDiretrizAlimentarCommand;
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

@RequestScoped
public class SubstanciaApplicationService implements SubstanciaCommandHandler {
	
	private static final long serialVersionUID = 1L;

	private DiretrizAlimentarRepo diretrizAlimentarRepo;
	private EnergiaSubstanciaRepo energiaSubstanciaRepo;
	private SubstanciaRepo substanciaRepo;
	private Date dataOperacao = DateUtils.truncate(new Date(), Calendar.SECOND);

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
		
		try {
			DiretrizAlimentar da = this.diretrizAlimentarRepo().porId(new DiretrizAlimentarId(command.getDiretrizAlimentarId()));
			NormaAlimentar na = new NormaAlimentar();
			na.setDataCriacao(this.dataOperacao);
			na.setSubstancia(this.substanciaRepo().porId(new SubstanciaId(command.getSubstanciaId())));
			na.setTipoNorma(command.getTipoNorma());
			na.setNormaMinima(command.getNormaMinima());
			na.setNormaMaxima(command.getNormaMaxima());
			na.setDiretrizAlimentar(da);
			da.getNormasAlimentares().add(na);
			//this.diretrizAlimentarRepo().adicionar(da);
			
			resultado = new CommandResult(true, "Adicionado a Norma Alimentar com sucesso!", null);
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao adicionar a Norma Alimentar a Diretriz" + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarNomeDaDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(false, command.getClass() + " não implementado", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarNormaDaDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(false, command.getClass() + " não implementado", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		try {
			DiretrizAlimentar da = new DiretrizAlimentarBuilder(command.getNome()).construir();
			da.setDiretrizAlimentarId(new DiretrizAlimentarId(this.diretrizAlimentarRepo().proximaIdentidade().uuid()));
			da = this.diretrizAlimentarRepo().adicionar(da);
	
			resultado = new CommandResult(true, "Diretriz Alimentar cadastrada com sucesso!", da.diretrizAlimentarId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar a Diretriz Alimentar" + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(DesativarDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(false, command.getClass() + " não implementado", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ExcluirDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(false, command.getClass() + " não implementado", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ExcluirNormaDaDiretrizAlimentarCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(false, command.getClass() + " não implementado", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarFatorEnergeticoDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		try {
			// TODO se o fator energético atual diferir do anterior
			EnergiaSubstancia es = new EnergiaSubstancia();
			es.setFatorEnergetico(command.getFatorEnergetico());
			es.setSubstancia(this.substanciaRepo().porId(new SubstanciaId(command.getSubstanciaId())));
			es.setDataCadastro(this.dataOperacao);
			es.setEnergiaSubstanciaId(this.energiaSubstanciaRepo().proximaIdentidade());
			es = this.energiaSubstanciaRepo().adicionar(es);
			
			System.out.println("dataCadastro:" + this.dataOperacao + " (" + this.dataOperacao.getTime() + ")");
			resultado = new CommandResult(true, "Atualizado Fator Energético com sucesso!", null);
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar o Fator Energético da Substância" + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarNomeDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		try {
			Substancia s = this.substanciaRepo().porId(new SubstanciaId(command.getSubstanciaId()));
			s.setNome(command.getNome());
			s = this.substanciaRepo().adicionar(s);
	
			resultado = new CommandResult(true, "Nome atualizado com sucesso!", null);
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar o Nome da Substância" + e, null);
		}
		
		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarUnidadeDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		try {
			Substancia s = this.substanciaRepo().porId(new SubstanciaId(command.getSubstanciaId()));
			s.setUnidadeSubstancia(command.getUnidadeSubstancia());
			s = this.substanciaRepo().adicionar(s);
	
			resultado = new CommandResult(true, "Unidade atualizada com sucesso!", null);
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar a Unidada da Susbstância" + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarSubstanciaComumCommand command) {
		CommandResult resultado = null;

		try {
			Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(),
					this.substanciaRepo().proximaOrdem().intValue()).construir();
			s.setSubstanciaId(this.substanciaRepo().proximaIdentidade());
			s = this.substanciaRepo().adicionar(s);
	
			resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar Substância Comum" + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarSubstanciaOrdenadaCommand command) {
		CommandResult resultado = null;
		
		try {
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
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar Substância Ordenada" + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarSubstanciaEnergeticaCommand command) {
		CommandResult resultado = null;

		try {
			Substancia s = new SubstanciaBuilder(command.getNome(), command.getUnidadeSubstancia(),
					this.substanciaRepo().proximaOrdem().intValue()).construir();
			s.setSubstanciaId(this.substanciaRepo().proximaIdentidade());
			s = this.substanciaRepo().adicionar(s);
	
			EnergiaSubstancia es = new EnergiaSubstancia();
			es.setDataCadastro(this.dataOperacao);
			es.setFatorEnergetico(command.getFatorEnergetico());
			es.setSubstancia(s);
			es.setEnergiaSubstanciaId(energiaSubstanciaRepo().proximaIdentidade());
			es = this.energiaSubstanciaRepo().adicionar(es);
	
			System.out.println("dataCadastro:" + this.dataOperacao + " (" + this.dataOperacao.getTime() + ")");
			resultado = new CommandResult(true, "Substância cadastrada com sucesso!", s.substanciaId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar Substância Energética" + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(ExcluirSubstanciaCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(false, command.getClass() + " não implementado", "");

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(PriorizarOrdemDaSubstanciaCommand command) {
		CommandResult resultado = null;
		
		// TODO Auto-generated method stub
		resultado = new CommandResult(false, command.getClass() + " não implementado", "");

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
