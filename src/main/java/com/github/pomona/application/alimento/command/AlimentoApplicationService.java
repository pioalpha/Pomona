package com.github.pomona.application.alimento.command;

import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang3.time.DateUtils;

import com.github.common.application.command.CommandResult;
import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.AlimentoId;
import com.github.pomona.domain.model.AlimentoRepo;
import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.CategoriaAlimento;
import com.github.pomona.domain.model.CategoriaAlimentoId;
import com.github.pomona.domain.model.CategoriaAlimentoRepo;
import com.github.pomona.domain.model.ComponenteAlimentar;
import com.github.pomona.domain.model.ApresentacaoMedidaAlimento;
import com.github.pomona.domain.model.ApresentacaoMedidaAlimentoRepo;
import com.github.pomona.domain.model.SubstanciaId;
import com.github.pomona.domain.model.SubstanciaRepo;
import com.github.pomona.domain.model.TipoMedida;
import com.github.pomona.domain.model.TipoMedidaId;
import com.github.pomona.domain.model.TipoMedidaRepo;
import com.github.pomona.domain.model.TipoApresentacao;
import com.github.pomona.domain.model.TipoApresentacaoId;
import com.github.pomona.domain.model.TipoApresentacaoRepo;
import com.github.pomona.domain.service.AlimentoBuilder;

@RequestScoped
public class AlimentoApplicationService implements AlimentoCommandHandler {
	
	private static final long serialVersionUID = 1L;

	private AlimentoRepo alimentoRepo;
	private SubstanciaRepo substanciaRepo;
	private TipoMedidaRepo tipoMedidaRepo;
	private TipoApresentacaoRepo tipoApresentacaoRepo;
	private ApresentacaoMedidaAlimentoRepo apresentacaoMedidaAlimentoRepo;
	private CategoriaAlimentoRepo categoriaAlimentoRepo;
	private Date dataOperacao = DateUtils.truncate(new Date(), Calendar.SECOND);

	@Inject
	public AlimentoApplicationService(AlimentoRepo alimentoRepo,
			SubstanciaRepo substanciaRepo, TipoMedidaRepo tipoMedidaRepo, TipoApresentacaoRepo tipoApresentacaoRepo,
			ApresentacaoMedidaAlimentoRepo apresentacaoMedidaAlimentoRepo, CategoriaAlimentoRepo categoriaAlimentoRepo) {
		super();

		this.alimentoRepo = alimentoRepo;
		this.substanciaRepo = substanciaRepo;
		this.tipoMedidaRepo = tipoMedidaRepo;
		this.tipoApresentacaoRepo = tipoApresentacaoRepo;
		this.apresentacaoMedidaAlimentoRepo = apresentacaoMedidaAlimentoRepo;
		this.categoriaAlimentoRepo = categoriaAlimentoRepo;
	}

	@Transactional
	public CommandResult handle(AdicionarComponenteAlimentarCommand command) {
		CommandResult resultado = null;

		try {
			AlimentoUnitario au = this.alimentoRepo().porId(new AlimentoId(command.getAlimentoId()));
			
			ComponenteAlimentar ca = new ComponenteAlimentar();
			ca.setDataCadastro(this.dataOperacao);
			ca.setQuantidade(command.getQuantidade());
			ca.setSubstancia(this.substanciaRepo().porId(new SubstanciaId(command.getSubstanciaId())));
			ca.setAlimentoUnitario(au);
			au.getComposicaoAlimentar().add(ca);
			//au = this.alimentoRepo().adicionar(au);
	
			resultado = new CommandResult(true, "Componente Alimentar Adicionado com Sucesso!", null);
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao adicionar o Componente Alimentar " + e, null);
		}
		
		return resultado;
	}

	@Transactional
	public CommandResult handle(AtualizarCategoriaDoAlimentoCommand command) {
		CommandResult resultado = null;
		
		try {
			AlimentoUnitario au = this.alimentoRepo().porId(new AlimentoId(command.getAlimentoId()));
			CategoriaAlimento ca = this.categoriaAlimentoRepo().porId(new CategoriaAlimentoId(command.getCategoriaId()));
			au.setCategoriaAlimento(ca);
			au = this.alimentoRepo().adicionar(au);

			resultado = new CommandResult(true, "Categoria do Alimento atualizado com sucesso!", null);
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar a Categoria do Alimento " + e, null);
		}

		return resultado;
	}
	
	@Transactional
	public CommandResult handle(AtualizarNomeDoAlimentoCommand command) {
		CommandResult resultado = null;
		
		try {
			AlimentoUnitario au = this.alimentoRepo().porId(new AlimentoId(command.getAlimentoId()));
			au.setNome(command.getNome());
			au = this.alimentoRepo().adicionar(au);
			
			resultado = new CommandResult(true, "Nome do Alimento atualizado com sucesso!", null);
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar o Nome do Alimento " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(AtualizarNomeDoTipoMedidaCommand command) {
		CommandResult resultado = null;
		
		try {
			// TODO Auto-generated method stub
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar o Nome do Tipo de Medida " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(AtualizarNomeDoTipoApresentacaoCommand command) {
		CommandResult resultado = null;

		try {
			// TODO Auto-generated method stub
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar o Nome do Tipo de Apresentação " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(AtualizarPorcaoDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		try {
			AlimentoGranel ag = (AlimentoGranel) this.alimentoRepo().porId(new AlimentoId(command.getAlimentoGranelId()));
			ag.setPorcao(command.getPorcao());
			ag = (AlimentoGranel) this.alimentoRepo().adicionar(ag);
			
			resultado = new CommandResult(true, "Atualizado a Porção do Alimento Granel com sucesso!", ag.alimentoId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar a Porção do Alimento Granel " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(AtualizarQuantidadeComponenteAlimentarCommand command) {
		CommandResult resultado = null;

		try {
			// TODO Auto-generated method stub
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar a Quantidade do Componente Alimentar " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(AtualizarUnidadeDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		try {
			AlimentoGranel ag = (AlimentoGranel) this.alimentoRepo().porId(new AlimentoId(command.getAlimentoGranelId()));
			ag.setUnidadeGranel(command.getUnidadeGranel());
			ag = (AlimentoGranel) this.alimentoRepo().adicionar(ag);
			
			resultado = new CommandResult(true, "Atualizado a Unidade do Alimento Granel com sucesso!", ag.alimentoId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar a Unidade do Alimento " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(CadastrarAlimentoGranelCommand command) {
		CommandResult resultado = null;

		try {
			CategoriaAlimento categoria = null;
			
			if (command.getCategoriaAlimentoId() != null){
				categoria = this.categoriaAlimentoRepo().porId(new CategoriaAlimentoId(command.getCategoriaAlimentoId()));
			}
			
			AlimentoGranel ag = new AlimentoBuilder().construir(command.getNome(), command.getUnidadeGranel(),
					command.getPorcao(),
					categoria);
			ag.setAlimentoId(this.alimentoRepo().proximaIdentidade());
			ag = (AlimentoGranel) this.alimentoRepo().adicionar(ag);
			
			resultado = new CommandResult(true, "Alimento Cadastrado", ag.alimentoId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar o Alimento Granel" + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(CadastrarAlimentoUnitarioCommand command) {
		CommandResult resultado = null;

		try {
			// TODO Auto-generated method stub
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar o Alimento Unitário " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(CadastrarApresentacaoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		try {
			ApresentacaoMedidaAlimento pma = new ApresentacaoMedidaAlimento();
			pma.setQuantidade(command.getQuantidade());
			pma.setAlimentoGranel((AlimentoGranel) this.alimentoRepo().porId(new AlimentoId(command.getAlimentoGranelId())));
			pma.setTipoMedida(this.tipoMedidaRepo().porId(new TipoMedidaId(command.getTipoMedidaId())));
			pma.setTipoApresentacao(this.tipoApresentacaoRepo().porId(new TipoApresentacaoId(command.getTipoApresentacaoId())));
			pma.setApresentacaoMedidaAlimentoId(this.apresentacaoMedidaAlimentoRepo().proximaIdentidade());
			pma = this.apresentacaoMedidaAlimentoRepo().adicionar(pma);
			
			resultado = new CommandResult(true, "Medida e Apresentação do Alimento cadastrado com sucesso!", pma.apresentacaoMedidaAlimentoId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar a Apresentação e Medida do Alimento Granel " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(CadastrarTipoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		try {
			TipoMedida tm = new TipoMedida();
			tm.setNome(command.getNome());
			tm.setTipoMedidaId(this.tipoMedidaRepo().proximaIdentidade());
			tm = this.tipoMedidaRepo().adicionar(tm);
	
			resultado = new CommandResult(true, "Tipo de Medida cadastrada com sucesso!", tm.tipoMedidaId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar o Tipo de Medida " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(CadastrarTipoApresentacaoDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		try {
			TipoApresentacao tp = new TipoApresentacao();
			tp.setNome(command.getNome());
			tp.setTipoApresentacaoId(this.tipoApresentacaoRepo().proximaIdentidade());
			tp = this.tipoApresentacaoRepo().adicionar(tp);
	
			resultado = new CommandResult(true, "Tipo de Apresentação cadastrada com sucesso!", tp.tipoApresentacaoId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar o Tipo de Apresentação " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(ExcluirAlimentoCommand command) {
		CommandResult resultado = null;

		try {
			// TODO Auto-generated method stub
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao excluir o Alimento " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(ExcluirComponenteAlimentarCommand command) {
		CommandResult resultado = null;

		try {
			// TODO Auto-generated method stub: cadastrar valor nulo como componente
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao excluir o Componente Alimentar " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(ExcluirApresentacaoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		try {
			// TODO Auto-generated method stub
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao excluir a Apresentação e Medida do Alimento Granel " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(ExcluirTipoMedidaDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		try {
			// TODO Auto-generated method stub
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao excluir o Tipo de Medida " + e, null);
		}

		return resultado;
	}

	@Transactional
	public CommandResult handle(ExcluirTipoApresentacaoDoAlimentoGranelCommand command) {
		CommandResult resultado = null;

		try {
			// TODO Auto-generated method stub
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao excluir o Tipo de Apresentação " + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarPorcaoApresentacaoMedidaDoAlimentoCommand command) {
		CommandResult resultado = null;

		try {
			// TODO Auto-generated method stub
			resultado = new CommandResult(false, command.getClass() + " não implementado", "");
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar a Porção da Medida de Apresentação do Alimento " + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(AtualizarCategoriaAlimentarCommand command) {
		CommandResult resultado = null;

		try {
			CategoriaAlimento ca = this.categoriaAlimentoRepo().porId(new CategoriaAlimentoId(command.getCategoriaAlimentoId()));
			ca.setNome(command.getNome());
			ca.setCaloriasPorPorcao(command.getCaloriasPorPorcao());
			ca = this.categoriaAlimentoRepo().adicionar(ca);
	
			resultado = new CommandResult(true, "Categoria Alimentar atualizada com sucesso!", ca.categoriaAlimentoId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao atualizar a Categoria Alimentar " + e, null);
		}

		return resultado;
	}

	@Override
	@Transactional
	public CommandResult handle(CadastrarCategoriaAlimentarCommand command) {
		CommandResult resultado = null;

		try {
			CategoriaAlimento ca = new CategoriaAlimento();
			ca.setNome(command.getNome());
			ca.setCaloriasPorPorcao(command.getCaloriasPorPorcao());
			ca.setCategoriaAlimentoId(this.categoriaAlimentoRepo().proximaIdentidade());
			ca = this.categoriaAlimentoRepo().adicionar(ca);
	
			resultado = new CommandResult(true, "Categoria Alimentar cadastrada com sucesso!", ca.categoriaAlimentoId().uuid());
		} catch (Exception e) {
			resultado = new CommandResult(false, "Falha ao cadastrar a Categoria Alimentar " + e, null);
		}

		return resultado;
	}

	private AlimentoRepo alimentoRepo() {
		return alimentoRepo;
	}

	private SubstanciaRepo substanciaRepo() {
		return substanciaRepo;
	}

	private TipoMedidaRepo tipoMedidaRepo() {
		return tipoMedidaRepo;
	}

	private TipoApresentacaoRepo tipoApresentacaoRepo() {
		return tipoApresentacaoRepo;
	}

	private ApresentacaoMedidaAlimentoRepo apresentacaoMedidaAlimentoRepo() {
		return apresentacaoMedidaAlimentoRepo;
	}

	private CategoriaAlimentoRepo categoriaAlimentoRepo() {
		return categoriaAlimentoRepo;
	}

}
