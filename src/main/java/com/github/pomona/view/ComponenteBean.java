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

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.github.pomona.application.AlimentoQueryService;
import com.github.pomona.application.SubstanciaQueryService;
import com.github.pomona.application.command.alimento.AdicionarComponenteAlimentarCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaComumCommand;
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
	private String nomeSubstancia;
	@DecimalMin(value="0.01")
	@NotNull
	private Float quantidadeSubstancia;
	
	// Cadastro/Edicao de substancia
	private Float fatorEnergeticoSubstancia;
	private UnidadeSubstancia unidadeSubstancia;
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
	
	public void cadastrarComponente() {
		String uuidSubstancia = null;

		if (this.nomeSubstancia != null && !this.nomeSubstancia.trim().isEmpty()) {
			String nomeSubstanciaTemp = null;
			UnidadeSubstancia unidadeSubstanciaTemp = null;
			int temp;
			for (UnidadeSubstancia us : UnidadeSubstancia.values()) {
				if ((temp = this.nomeSubstancia.indexOf("(" + us.name() + ")")) > 0) {
					nomeSubstanciaTemp = this.nomeSubstancia.substring(0, temp).trim();
					unidadeSubstanciaTemp = us;

					break;
				}
			}

			if (nomeSubstanciaTemp == null) {
				nomeSubstanciaTemp = this.nomeSubstancia.trim();
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

			if (this.quantidadeSubstancia != null) {
				ach.handle(new AdicionarComponenteAlimentarCommand(this.alimentoSelecionado.getUuid(), uuidSubstancia,
						this.quantidadeSubstancia));
			}

			System.out.println(">>>" + this.alimentoSelecionado.getUuid());

			this.inicializar();
			// this.componentes =
			// this.alimentoSelecionado.getComponentesAlimentares();
			this.nomeSubstancia = null;
			this.substanciaSelecionada = null;
			this.quantidadeSubstancia = null;
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

	public String getNomeSubstancia() {
		return nomeSubstancia;
	}

	public void setNomeSubstancia(String nomeSubstancia) {
		this.nomeSubstancia = nomeSubstancia;
	}

	public Float getQuantidadeSubstancia() {
		return quantidadeSubstancia;
	}

	public void setQuantidadeSubstancia(Float quantidadeSubstancia) {
		this.quantidadeSubstancia = quantidadeSubstancia;
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
