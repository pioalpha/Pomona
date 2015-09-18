package com.github.pomona.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.github.pomona.application.AlimentoQueryService;
import com.github.pomona.application.SubstanciaQueryService;
import com.github.pomona.application.command.alimento.AdicionarComponenteAlimentarCommand;
import com.github.pomona.application.command.substancia.AtualizarFatorEnergeticoDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.AtualizarNomeDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.AtualizarUnidadeDaSubstanciaCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaComumCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaEnergeticaCommand;
import com.github.pomona.application.dto.AlimentoDTO;
import com.github.pomona.application.dto.ApresentacaoMedidaAlimentoDTO;
import com.github.pomona.application.dto.ApresentacaoMedidaParametrosPesquisa;
import com.github.pomona.application.dto.ComponenteAlimentarDTO;
import com.github.pomona.application.dto.ComponenteParametrosPesquisa;
import com.github.pomona.application.dto.SubstanciaDTO;
import com.github.pomona.application.dto.SubstanciaParametrosPesquisa;
import com.github.pomona.domain.reference.UnidadeSubstancia;
import com.github.pomona.service.commandHandler.AlimentoCommandHandler;
import com.github.pomona.service.commandHandler.SubstanciaCommandHandler;

@Named
@ViewScoped
public class ComponenteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// interfaces de Consultas necessárias as listagens
	@Inject
	private SubstanciaQueryService sqs;
	@Inject
	private AlimentoQueryService aqs;

	// interfaces de Comandos necessários ao cadastro
	@Inject
	private SubstanciaCommandHandler sch;
	@Inject
	private AlimentoCommandHandler ach;
	
	// Para listar combos
	private List<SubstanciaDTO> substancias;

	// Núcleo de informações da página
	private List<ComponenteAlimentarDTO> componentes;
	private List<ApresentacaoMedidaAlimentoDTO> apresentacoesMedidasAlimentos;

	// informações filtradas
	private List<ComponenteAlimentarDTO> componentesFiltrados;

	// Cadastro/Edicao de componente
	@NotBlank
	@Size(min=3, max = 100)
	private String substanciaComponente;
	@NotNull
	@DecimalMin(value="0.01")
	private Float quantidadeComponente;
	
	
	// Cadastro/Edicao de substancia
	@NotBlank
	@Size(min = 3, max = 100)
	private String nomeSubstancia;
	@NotNull
	private UnidadeSubstancia unidadeSubstancia;
	@DecimalMin(value="0.01")
	private Float fatorEnergeticoSubstancia;
	private SubstanciaDTO substanciaSelecionada;
	
	// Para cadastros, edições e exclusões
	@NotNull
	private AlimentoDTO alimentoSelecionado;
	private ComponenteAlimentarDTO componenteAlimentarSelecionado;
	
	@PostConstruct
	public void inicializar() {
		this.substancias = sqs.Executar(new SubstanciaParametrosPesquisa());
	}
	
	public void cadastrarSubstancia() {
		// se a substancia existir, atualizar apenas o fator energético
		List<SubstanciaDTO> subs = sqs.Executar(new SubstanciaParametrosPesquisa(this.nomeSubstancia.trim(), new Date()));
		if (subs.isEmpty()) {
			if (this.fatorEnergeticoSubstancia == null) {
				sch.handle(new CadastrarSubstanciaComumCommand(this.nomeSubstancia.trim(), this.unidadeSubstancia));
			} else {
				sch.handle(new CadastrarSubstanciaEnergeticaCommand(this.nomeSubstancia.trim(), this.unidadeSubstancia, this.fatorEnergeticoSubstancia));
			}
		} else {
			if (subs.get(0).getFatorEnergetico() != this.fatorEnergeticoSubstancia){
				sch.handle(new AtualizarFatorEnergeticoDaSubstanciaCommand(subs.get(0).getUuid(), this.fatorEnergeticoSubstancia));
			}
		}

		this.inicializar();
		
		this.nomeSubstancia = null;
		this.unidadeSubstancia = null;
		this.fatorEnergeticoSubstancia = null;
	}
	
	public void onRowSelect(SelectEvent event) {
		this.alimentoSelecionado = (AlimentoDTO) event.getObject();
		if (this.alimentoSelecionado != null) {
			// TODO A lista que vem do alimento selecionado está vindo vazia no
			// primeiro cadastro
			// this.componentes =
			// alimentoSelecionado.getComponentesAlimentares();
			this.componentes = aqs
					.Executar(new ComponenteParametrosPesquisa(this.alimentoSelecionado.getUuid(), null, new Date()));
			this.apresentacoesMedidasAlimentos = aqs
					.Executar(new ApresentacaoMedidaParametrosPesquisa(this.alimentoSelecionado, null, null));
		}
	}
	
	public void onRowEditSubstancia(RowEditEvent event) {
        SubstanciaDTO s = ((SubstanciaDTO) event.getObject());
        if (s.isEditado()) {
        	sch.handle(new AtualizarNomeDaSubstanciaCommand(s.getUuid(), s.getNome()));
        	sch.handle(new AtualizarUnidadeDaSubstanciaCommand(s.getUuid(), s.getUnidadeSubstancia()));
        	sch.handle(new AtualizarFatorEnergeticoDaSubstanciaCommand(s.getUuid(), s.getFatorEnergetico()));
        }
        
        this.inicializar();
        
        this.substanciaComponente = null;
	}

	public void onRowEditComponente(RowEditEvent event) {
        ComponenteAlimentarDTO ca = ((ComponenteAlimentarDTO) event.getObject());
        if (ca.isEditado()) {
        	ach.handle(new AdicionarComponenteAlimentarCommand(ca.getAlimentoUuid(), ca.getSubstancia().getUuid(), ca.getQuantidadeSubstancia()));
        }
        
        this.inicializar();
	}

	public void cadastrarComponente() {
		String uuidSubstancia = null;

		if (this.substanciaComponente != null && !this.substanciaComponente.trim().isEmpty()) {
			String nomeSubstanciaTemp = null;
			UnidadeSubstancia unidadeSubstanciaTemp = null;
			int temp;
			for (UnidadeSubstancia us : UnidadeSubstancia.values()) {
				if ((temp = this.substanciaComponente.indexOf("(" + us.name() + ")")) > 0) {
					nomeSubstanciaTemp = this.substanciaComponente.substring(0, temp).trim();
					unidadeSubstanciaTemp = us;

					break;
				}
			}

			if (nomeSubstanciaTemp == null) {
				nomeSubstanciaTemp = this.substanciaComponente.trim();
			}

			// Confirma se a substancia está cadastrada
			if (nomeSubstanciaTemp != null && !nomeSubstanciaTemp.isEmpty()) {
				List<SubstanciaDTO> subs = sqs
						.Executar(new SubstanciaParametrosPesquisa(nomeSubstanciaTemp, new Date()));
				if (!subs.isEmpty()) {
					this.substanciaSelecionada = subs.get(0);
				}
			}

			if (this.substanciaSelecionada == null) {
				// Se a substancia não está cadastrada
				if (nomeSubstanciaTemp != null && !nomeSubstanciaTemp.isEmpty()) {
					uuidSubstancia = sch
							.handle(new CadastrarSubstanciaComumCommand(nomeSubstanciaTemp, unidadeSubstanciaTemp)).id;
				}
			} else {
				uuidSubstancia = this.substanciaSelecionada.getUuid();
			}

			if (this.quantidadeComponente != null) {
				ach.handle(new AdicionarComponenteAlimentarCommand(this.alimentoSelecionado.getUuid(), uuidSubstancia,
						this.quantidadeComponente));
			}

			System.out.println(">>>" + this.alimentoSelecionado.getUuid());

			this.inicializar();
			// this.componentes =
			// this.alimentoSelecionado.getComponentesAlimentares();
			this.substanciaComponente = null;
			this.substanciaSelecionada = null;
			this.quantidadeComponente = null;
		}
	}
	
	public List<SubstanciaDTO> getSubstancias() {
		return substancias;
	}

	public List<ApresentacaoMedidaAlimentoDTO> getApresentacoesMedidasAlimentos() {
		return apresentacoesMedidasAlimentos;
	}
	
	public AlimentoDTO getAlimentoSelecionado() {
		return alimentoSelecionado;
	}
	
	public void setAlimentoSelecionado(AlimentoDTO alimentoSelecionado) {
		this.alimentoSelecionado = alimentoSelecionado;
	}
	
	public List<ComponenteAlimentarDTO> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<ComponenteAlimentarDTO> componentes) {
		this.componentes = componentes;
	}
	
	public List<ComponenteAlimentarDTO> getComponentesFiltrados() {
		return componentesFiltrados;
	}

	public void setComponentesFiltrados(List<ComponenteAlimentarDTO> componentesFiltrados) {
		this.componentesFiltrados = componentesFiltrados;
	}

	public String getSubstanciaComponente() {
		return substanciaComponente;
	}

	public void setSubstanciaComponente(String substanciaComponente) {
		this.substanciaComponente = substanciaComponente;
	}
	
	public String getNomeSubstancia() {
		return nomeSubstancia;
	}

	public void setNomeSubstancia(String nomeSubstancia) {
		this.nomeSubstancia = nomeSubstancia;
	}

	public Float getQuantidadeComponente() {
		return quantidadeComponente;
	}

	public void setQuantidadeComponente(Float quantidadeComponente) {
		this.quantidadeComponente = quantidadeComponente;
	}
	
	public UnidadeSubstancia[] getUnidadesSubstancia() {
		return UnidadeSubstancia.values();
	}

	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}

	public void setUnidadeSubstancia(UnidadeSubstancia unidadeSubstancia) {
		this.unidadeSubstancia = unidadeSubstancia;
	}
	
	public Float getFatorEnergeticoSubstancia() {
		return fatorEnergeticoSubstancia;
	}

	public void setFatorEnergeticoSubstancia(Float fatorEnergeticoSubstancia) {
		this.fatorEnergeticoSubstancia = fatorEnergeticoSubstancia;
	}
	
	public ComponenteAlimentarDTO getComponenteAlimentarSelecionado() {
		return componenteAlimentarSelecionado;
	}

	public void setComponenteAlimentarSelecionado(ComponenteAlimentarDTO componenteAlimentarSelecionado) {
		this.componenteAlimentarSelecionado = componenteAlimentarSelecionado;
	}
}
