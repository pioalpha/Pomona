package com.github.pomona.port.adapter.jsf.bean;

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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.github.common.application.command.CommandResult;
import com.github.pomona.application.alimento.command.AdicionarComponenteAlimentarCommand;
import com.github.pomona.application.alimento.command.AlimentoCommandHandler;
import com.github.pomona.application.alimento.command.AtualizarCategoriaAlimentarCommand;
import com.github.pomona.application.alimento.command.AtualizarCategoriaDoAlimentoCommand;
import com.github.pomona.application.alimento.command.AtualizarNomeDoAlimentoCommand;
import com.github.pomona.application.alimento.command.AtualizarPorcaoDoAlimentoGranelCommand;
import com.github.pomona.application.alimento.command.AtualizarUnidadeDoAlimentoGranelCommand;
import com.github.pomona.application.alimento.command.CadastrarAlimentoGranelCommand;
import com.github.pomona.application.alimento.command.CadastrarCategoriaAlimentarCommand;
import com.github.pomona.application.alimento.query.AlimentoDTO;
import com.github.pomona.application.alimento.query.AlimentoParametrosPesquisa;
import com.github.pomona.application.alimento.query.AlimentoQueryService;
import com.github.pomona.application.alimento.query.ApresentacaoDTO;
import com.github.pomona.application.alimento.query.ApresentacaoMedidaAlimentoDTO;
import com.github.pomona.application.alimento.query.ApresentacaoMedidaParametrosPesquisa;
import com.github.pomona.application.alimento.query.ApresentacaoParametrosPesquisa;
import com.github.pomona.application.alimento.query.CategoriaDTO;
import com.github.pomona.application.alimento.query.CategoriaParametrosPesquisa;
import com.github.pomona.application.alimento.query.ComponenteAlimentarDTO;
import com.github.pomona.application.alimento.query.ComponenteParametrosPesquisa;
import com.github.pomona.application.alimento.query.MedidaDTO;
import com.github.pomona.application.alimento.query.MedidaParametrosPesquisa;
import com.github.pomona.application.substancia.command.CadastrarSubstanciaComumCommand;
import com.github.pomona.application.substancia.command.SubstanciaCommandHandler;
import com.github.pomona.application.substancia.query.SubstanciaDTO;
import com.github.pomona.application.substancia.query.SubstanciaParametrosPesquisa;
import com.github.pomona.application.substancia.query.SubstanciaQueryService;
import com.github.pomona.domain.reference.UnidadeGranel;
import com.github.pomona.domain.reference.UnidadeSubstancia;
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
	private List<ApresentacaoDTO> apresentacoes;
	private List<MedidaDTO> medidas;
	private List<CategoriaDTO> categorias;

	// Núcleo de informações da página
	private List<AlimentoDTO> alimentos;
	private List<ComponenteAlimentarDTO> componentes;
	private List<ApresentacaoMedidaAlimentoDTO> apresentacoesMedidasAlimentos;

	// informações filtradas
	private List<AlimentoDTO> alimentosFiltrados;
	private List<ComponenteAlimentarDTO> componentesFiltrados;
	private List<ApresentacaoMedidaAlimentoDTO> apresentacoesMedidasFiltrados;

	// Cadastro/Edição de alimento
	@NotBlank
	@Size(min = 3, max = 100)
	private String nomeAlimento;
	@NotNull
	@DecimalMin(value="0.01")
	private Float porcaoAlimento;
	@NotNull
	private UnidadeGranel unidadeAlimento;
	private String categoriaAlimento;
	private CategoriaDTO categoriaSelecionada;

	// Cadastro/Edicao de componente
	private String nomeSubstancia;
	private Float quantidadeSubstancia;
	private SubstanciaDTO substanciaSelecionada;

	// Cadastro/Edicao de categoria
	@NotBlank
	@Size(min = 3, max = 100)
	private String nomeCategoria;
	@DecimalMin(value="0.01")
	private Float caloriasPorcaoCategoria;
	// private CategoriaDTO categoriaSelecionada;

	// Cadastro/Edicao de substancia
	// private String nomeSubstancia;
	private Float fatorEnergeticoSubstancia;
	private UnidadeSubstancia unidadeSubstancia;
	// private SubstanciaDTO substanciaSelecionada;

	// Para cadastros, edições e exclusões
	private AlimentoDTO alimentoSelecionado;
	private ComponenteAlimentarDTO componenteAlimentarSelecionado;
	private ApresentacaoMedidaAlimentoDTO apresentacaoMedidaAlimentoSelecionado;

	@PostConstruct
	public void inicializar() {
		this.alimentos = aqs.Executar(new AlimentoParametrosPesquisa(null, null, null));
		this.apresentacoes = aqs.Executar(new ApresentacaoParametrosPesquisa());
		this.medidas = aqs.Executar(new MedidaParametrosPesquisa());
		this.categorias = aqs.Executar(new CategoriaParametrosPesquisa());
		this.substancias = sqs.Executar(new SubstanciaParametrosPesquisa());
	}

	public void cargaInicial() throws ParseException {
		c.executa2();
	}

	public void cadastrarCategoria() {
		CommandResult resultado = null;
		// se a categoria existir, atualizar apenas as calorias por porção
		List<CategoriaDTO> cats = aqs.Executar(new CategoriaParametrosPesquisa(this.nomeCategoria.trim()));
		if (cats.isEmpty()) {
			resultado = ach.handle(new CadastrarCategoriaAlimentarCommand(this.nomeCategoria.trim(), this.caloriasPorcaoCategoria));

			if (resultado.success) {
				this.inicializar();
				
				this.nomeCategoria = null;
				this.caloriasPorcaoCategoria = null;
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						resultado.message, resultado.message));
			}
		}
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
					.Executar(new ApresentacaoMedidaParametrosPesquisa(new Date(), this.alimentoSelecionado, null, null));
		}
	}

	public void onRowEditCategoria(RowEditEvent event) {
		CommandResult resultado = null;
		
        CategoriaDTO c = ((CategoriaDTO) event.getObject());
        if (c.isEditado()) {
        	resultado = ach.handle(new AtualizarCategoriaAlimentarCommand(c.getUuid(), c.getNome(), c.getCaloriasPorPorcao()));

        	if (resultado.success) {
    	        this.inicializar();
    	        
    	        this.categoriaAlimento = null;
    		} else {
    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
    					resultado.message, resultado.message));
    		}
        }
	}

	public void onRowEditAlimento(RowEditEvent event) {
		CommandResult resultado = null;
		boolean sucesso = false;
		
        AlimentoDTO a = ((AlimentoDTO) event.getObject());
        if (a.isEditado()) {
        	List<CategoriaDTO> cats = aqs.Executar(new CategoriaParametrosPesquisa(a.getCategoria().getNome()));
        	if (!cats.isEmpty()) {
        		if (a.getUuid() != cats.get(0).getUuid()) {
    	        	resultado = ach.handle(new AtualizarCategoriaDoAlimentoCommand(a.getUuid(), cats.get(0).getUuid()));

    	        	if (resultado.success) {
    	        		sucesso = true;
    	        	} else {
    	    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
    	    					resultado.message, resultado.message));
    	        	}
        		}
        	}
        	
        	resultado = ach.handle(new AtualizarNomeDoAlimentoCommand(a.getUuid(), a.getNome()));
        	if (resultado.success) {
        		sucesso = true;
        	} else {
    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
    					resultado.message, resultado.message));
        	}
        	
        	resultado = ach.handle(new AtualizarPorcaoDoAlimentoGranelCommand(a.getUuid(), a.getPorcao()));
        	if (resultado.success) {
        		sucesso = true;
        	} else {
    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
    					resultado.message, resultado.message));
        	}
        	
        	resultado = ach.handle(new AtualizarUnidadeDoAlimentoGranelCommand(a.getUuid(), a.getUnidadeGranel()));
        	if (resultado.success) {
        		sucesso = true;
        	} else {
    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
    					resultado.message, resultado.message));
        	}
        }
        
        if (sucesso) {
        	this.inicializar();
        }
	}
	
	public void cadastrarAlimento() {
		String uuidCategoria = null;
		CommandResult resultado = null;

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
				resultado = ach.handle(new CadastrarCategoriaAlimentarCommand(this.categoriaAlimento.trim()));
				if (resultado.success) {
					uuidCategoria = resultado.id;
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							resultado.message, resultado.message));
				}
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

			resultado = ach.handle(new CadastrarAlimentoGranelCommand(this.nomeAlimento.trim(), this.unidadeAlimento,
					this.porcaoAlimento, uuidCategoria));
			if (resultado.success) {
				System.out.println(">>>" + this.categoriaAlimento + " - " + this.nomeAlimento + " - " + this.porcaoAlimento
						+ " - " + this.unidadeAlimento);

				this.inicializar();
				// this.nomeAlimento = null;
				this.categoriaSelecionada = null;
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						resultado.message, resultado.message));
			}
		}
	}

	public void cadastrarComponente() {
		String uuidSubstancia = null;
		CommandResult resultado = null;

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
					resultado = sch
							.handle(new CadastrarSubstanciaComumCommand(nomeSubstanciaTemp, unidadeSubstanciaTemp));
					if (resultado.success) {
						uuidSubstancia = resultado.id;
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								resultado.message, resultado.message));
					}
				}
			} else {
				uuidSubstancia = this.substanciaSelecionada.getUuid();
			}

			if (this.quantidadeSubstancia != null) {
				resultado = ach.handle(new AdicionarComponenteAlimentarCommand(this.alimentoSelecionado.getUuid(), uuidSubstancia,
						this.quantidadeSubstancia));
				if (resultado.success) {
					System.out.println(">>>" + this.alimentoSelecionado.getUuid());

					this.inicializar();
					// this.componentes =
					// this.alimentoSelecionado.getComponentesAlimentares();
					this.nomeSubstancia = null;
					this.substanciaSelecionada = null;
					this.quantidadeSubstancia = null;
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							resultado.message, resultado.message));
				}
			}
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

	public List<ApresentacaoDTO> getApresentacoes() {
		return apresentacoes;
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

	public List<ApresentacaoMedidaAlimentoDTO> getApresentacoesMedidasAlimentos() {
		return apresentacoesMedidasAlimentos;
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

	public ApresentacaoMedidaAlimentoDTO getApresentacaoMedidaAlimentoSelecionado() {
		return apresentacaoMedidaAlimentoSelecionado;
	}

	public void setApresentacaoMedidaAlimentoSelecionado(ApresentacaoMedidaAlimentoDTO apresentacaoMedidaAlimentoSelecionado) {
		this.apresentacaoMedidaAlimentoSelecionado = apresentacaoMedidaAlimentoSelecionado;
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

	public UnidadeSubstancia getUnidadeSubstancia() {
		return unidadeSubstancia;
	}

	public void setUnidadeSubstancia(UnidadeSubstancia unidadeSubstancia) {
		this.unidadeSubstancia = unidadeSubstancia;
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

	public List<ApresentacaoMedidaAlimentoDTO> getApresentacoesMedidasFiltrados() {
		return apresentacoesMedidasFiltrados;
	}

	public void setApresentacoesMedidasFiltrados(List<ApresentacaoMedidaAlimentoDTO> apresentacoesMedidasFiltrados) {
		this.apresentacoesMedidasFiltrados = apresentacoesMedidasFiltrados;
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
