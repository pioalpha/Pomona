package com.github.pomona.view;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.github.pomona.application.AlimentoQueryService;
import com.github.pomona.application.SubstanciaQueryService;
import com.github.pomona.application.command.alimento.AdicionarComponenteAlimentarCommand;
import com.github.pomona.application.command.alimento.CadastrarAlimentoGranelCommand;
import com.github.pomona.application.command.alimento.CadastrarCategoriaAlimentoCommand;
import com.github.pomona.application.command.substancia.CadastrarSubstanciaComumCommand;
import com.github.pomona.application.dto.AlimentoDTO;
import com.github.pomona.application.dto.AlimentoParametrosPesquisa;
import com.github.pomona.application.dto.CategoriaDTO;
import com.github.pomona.application.dto.CategoriaParametrosPesquisa;
import com.github.pomona.application.dto.ComponenteAlimentarDTO;
import com.github.pomona.application.dto.ComponenteParametrosPesquisa;
import com.github.pomona.application.dto.MedidaDTO;
import com.github.pomona.application.dto.MedidaParametrosPesquisa;
import com.github.pomona.application.dto.PreparoDTO;
import com.github.pomona.application.dto.PreparoMedidaAlimentoDTO;
import com.github.pomona.application.dto.PreparoMedidaParametrosPesquisa;
import com.github.pomona.application.dto.PreparoParametrosPesquisa;
import com.github.pomona.application.dto.SubstanciaDTO;
import com.github.pomona.application.dto.SubstanciaParametrosPesquisa;
import com.github.pomona.domain.reference.UnidadeGranel;
import com.github.pomona.domain.reference.UnidadeSubstancia;
import com.github.pomona.service.commandHandler.AlimentoCommandHandler;
import com.github.pomona.service.commandHandler.SubstanciaCommandHandler;
import com.github.pomona.test.CargaInicialTest;

//@ManagedBean
//@ViewScoped
@Named
// @RequestScoped
@ViewScoped
public class AlimentoBean implements Serializable {

	private static final long serialVersionUID = -8620927385542527384L;

	@Inject
	private CargaInicialTest c;

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
	private List<PreparoDTO> preparos;
	private List<MedidaDTO> medidas;
	private List<CategoriaDTO> categorias;

	// Núcleo de informações da página
	private List<AlimentoDTO> alimentos;
	private List<ComponenteAlimentarDTO> componentes;
	private List<PreparoMedidaAlimentoDTO> preparosMedidasAlimentos;

	// informações filtradas
	private List<AlimentoDTO> alimentosFiltrados;
	private List<ComponenteAlimentarDTO> componentesFiltrados;
	private List<PreparoMedidaAlimentoDTO> preparosMedidasFiltrados;

	// Cadastro/Edição de alimento
	private String nomeAlimento;
	private Float porcaoAlimento;
	private UnidadeGranel unidadeAlimento;
	private String categoriaAlimento;
	private CategoriaDTO categoriaSelecionada;

	// Cadastro/Edicao de componente
	private String nomeSubstancia;
	private Float quantidadeSubstancia;
	private SubstanciaDTO substanciaSelecionada;

	// Cadastro/Edicao de categoria
	private String nomeCategoria;
	private Float caloriasPorcaoCategoria;
	// private CategoriaDTO categoriaSelecionada;

	// Cadastro/Edicao de substancia
	// private String nomeSubstancia;
	private Float fatorEnergeticoSubstancia;
	// private SubstanciaDTO substanciaSelecionada;

	// Para cadastros, edições e exclusões
	private AlimentoDTO alimentoSelecionado;
	private ComponenteAlimentarDTO componenteAlimentarSelecionado;
	private PreparoMedidaAlimentoDTO preparoMedidaAlimentoSelecionado;

	@PostConstruct
	public void inicializar() {
		this.alimentos = aqs.Executar(new AlimentoParametrosPesquisa(null, null, null));
		this.preparos = aqs.Executar(new PreparoParametrosPesquisa());
		this.medidas = aqs.Executar(new MedidaParametrosPesquisa());
		this.categorias = aqs.Executar(new CategoriaParametrosPesquisa());
		this.substancias = sqs.Executar(new SubstanciaParametrosPesquisa());
	}

	public void cargaInicial() throws ParseException {
		c.executa2();
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
			this.preparosMedidasAlimentos = aqs
					.Executar(new PreparoMedidaParametrosPesquisa(this.alimentoSelecionado, null, null));
		}
	}

	public void cadastrarAlimento() {
		String uuidCategoria = null;

		// Confirma se a categoria está cadastrada
		if (this.categoriaAlimento != null && !this.categoriaAlimento.isEmpty()) {
			List<CategoriaDTO> cats = aqs.Executar(new CategoriaParametrosPesquisa(this.categoriaAlimento.trim()));
			if (!cats.isEmpty()) {
				this.categoriaSelecionada = cats.get(0);
			}
		}

		if (this.categoriaSelecionada == null) {
			// Se a categoria não está cadastrada
			if (this.categoriaAlimento != null && !this.categoriaAlimento.isEmpty()) {
				uuidCategoria = ach.handle(new CadastrarCategoriaAlimentoCommand(this.categoriaAlimento.trim())).id;
			}
		} else {
			uuidCategoria = this.categoriaSelecionada.getUuid();
		}

		if (this.nomeAlimento != null && this.unidadeAlimento != null && this.porcaoAlimento != null) {
			// Evita cadastro de alimentos précadastrados
			if (this.nomeAlimento.trim().isEmpty()
					|| !aqs.Executar(new AlimentoParametrosPesquisa(null, this.nomeAlimento.trim(), null)).isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Alimento já cadastrado", "Alimento já cadastrado"));
			}

			ach.handle(new CadastrarAlimentoGranelCommand(this.nomeAlimento.trim(), this.unidadeAlimento,
					this.porcaoAlimento, uuidCategoria));
		}

		System.out.println(">>>" + this.categoriaAlimento + " - " + this.nomeAlimento + " - " + this.porcaoAlimento
				+ " - " + this.unidadeAlimento);

		this.inicializar();
		// this.nomeAlimento = null;
		this.categoriaSelecionada = null;
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

	public Collection<AlimentoDTO> getAlimentos() {
		return alimentos;
	}

	public UnidadeGranel[] getUnidadesGranel() {
		return UnidadeGranel.values();
	}

	public UnidadeSubstancia[] getUnidadesSubstancia() {
		return UnidadeSubstancia.values();
	}

	public List<PreparoDTO> getPreparos() {
		return preparos;
	}

	public List<MedidaDTO> getMedidas() {
		return medidas;
	}

	public List<SubstanciaDTO> getSubstancias() {
		return substancias;
	}

	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}

	public List<PreparoMedidaAlimentoDTO> getPreparosMedidasAlimentos() {
		return preparosMedidasAlimentos;
	}

	public AlimentoDTO getAlimentoSelecionado() {
		return alimentoSelecionado;
	}

	public void setAlimentoSelecionado(AlimentoDTO alimentoSelecionado) {
		this.alimentoSelecionado = alimentoSelecionado;
	}

	public ComponenteAlimentarDTO getComponenteAlimentarSelecionado() {
		return componenteAlimentarSelecionado;
	}

	public void setComponenteAlimentarSelecionado(ComponenteAlimentarDTO componenteAlimentarSelecionado) {
		this.componenteAlimentarSelecionado = componenteAlimentarSelecionado;
	}

	public PreparoMedidaAlimentoDTO getPreparoMedidaAlimentoSelecionado() {
		return preparoMedidaAlimentoSelecionado;
	}

	public void setPreparoMedidaAlimentoSelecionado(PreparoMedidaAlimentoDTO preparoMedidaAlimentoSelecionado) {
		this.preparoMedidaAlimentoSelecionado = preparoMedidaAlimentoSelecionado;
	}

	public String getNomeAlimento() {
		return nomeAlimento;
	}

	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}

	public Float getPorcaoAlimento() {
		return porcaoAlimento;
	}

	public void setPorcaoAlimento(Float porcaoAlimento) {
		this.porcaoAlimento = porcaoAlimento;
	}

	public UnidadeGranel getUnidadeAlimento() {
		return unidadeAlimento;
	}

	public void setUnidadeAlimento(UnidadeGranel unidadeAlimento) {
		this.unidadeAlimento = unidadeAlimento;
	}

	public String getCategoriaAlimento() {
		return categoriaAlimento;
	}

	public void setCategoriaAlimento(String categoriaAlimento) {
		this.categoriaAlimento = categoriaAlimento;
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

	public List<AlimentoDTO> getAlimentosFiltrados() {
		return alimentosFiltrados;
	}

	public void setAlimentosFiltrados(List<AlimentoDTO> alimentosFiltrados) {
		this.alimentosFiltrados = alimentosFiltrados;
	}

	public List<ComponenteAlimentarDTO> getComponentesFiltrados() {
		return componentesFiltrados;
	}

	public void setComponentesFiltrados(List<ComponenteAlimentarDTO> componentesFiltrados) {
		this.componentesFiltrados = componentesFiltrados;
	}

	public List<ComponenteAlimentarDTO> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<ComponenteAlimentarDTO> componentes) {
		this.componentes = componentes;
	}

	public List<PreparoMedidaAlimentoDTO> getPreparosMedidasFiltrados() {
		return preparosMedidasFiltrados;
	}

	public void setPreparosMedidasFiltrados(List<PreparoMedidaAlimentoDTO> preparosMedidasFiltrados) {
		this.preparosMedidasFiltrados = preparosMedidasFiltrados;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Float getCaloriasPorcaoCategoria() {
		return caloriasPorcaoCategoria;
	}

	public void setCaloriasPorcaoCategoria(Float caloriasPorcaoCategoria) {
		this.caloriasPorcaoCategoria = caloriasPorcaoCategoria;
	}

	public Float getFatorEnergeticoSubstancia() {
		return fatorEnergeticoSubstancia;
	}

	public void setFatorEnergeticoSubstancia(Float fatorEnergeticoSubstancia) {
		this.fatorEnergeticoSubstancia = fatorEnergeticoSubstancia;
	}

}
