package com.github.pomona.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.github.pomona.application.AlimentoQueryService;
import com.github.pomona.application.SubstanciaQueryService;
import com.github.pomona.application.dto.AlimentoDTO;
import com.github.pomona.application.dto.AlimentoParametrosPesquisa;
import com.github.pomona.application.dto.CategoriaDTO;
import com.github.pomona.application.dto.CategoriaParametrosPesquisa;
import com.github.pomona.application.dto.ComponenteAlimentarDTO;
import com.github.pomona.application.dto.MedidaDTO;
import com.github.pomona.application.dto.MedidaParametrosPesquisa;
import com.github.pomona.application.dto.PreparoDTO;
import com.github.pomona.application.dto.PreparoMedidaAlimentoDTO;
import com.github.pomona.application.dto.PreparoParametrosPesquisa;
import com.github.pomona.application.dto.SubstanciaDTO;
import com.github.pomona.application.dto.SubstanciaParametrosPesquisa;
import com.github.pomona.domain.reference.UnidadeGranel;
import com.github.pomona.domain.reference.UnidadeSubstancia;
import com.github.pomona.service.commandHandler.AlimentoCommandHandler;
import com.github.pomona.service.commandHandler.SubstanciaCommandHandler;

//@ManagedBean
//@ViewScoped
@Named
//@RequestScoped
@ViewScoped
public class AlimentoBean implements Serializable {

	private static final long serialVersionUID = -8620927385542527384L;

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
	
	
	/*@Inject
	public AlimentoBean(SubstanciaQueryService sqs, AlimentoQueryService aqs, SubstanciaCommandHandler sch,
			AlimentoCommandHandler ach) {
		super();
		
		this.sqs = sqs;
		this.aqs = aqs;
		this.sch = sch;
		this.ach = ach;
	}*/

	// Para listar combos
	private List<SubstanciaDTO> substancias;
	private List<PreparoDTO> preparos;
	private List<MedidaDTO> medidas;
	private List<CategoriaDTO> categorias;
	
	// Para validar cadastro de novas substancias e novos alimentos
	private UnidadeSubstancia unidadeSubstancia;
	private UnidadeGranel unidadeGranel;
	
	// Núcleo de informação da página
	private List<AlimentoDTO> alimentos; //Contém componentes alimentares
	private List<PreparoMedidaAlimentoDTO> preparosMedidasAlimentos; // Conforme alimento selecionado
	private List<AlimentoDTO> alimentosFiltrados;
	
	// Cadastro/Edição de alimento
	private String nomeAlimento;
	private Float porcaoAlimento;
	private UnidadeGranel unidadeAlimento;
	private String categoriaAlimento;
	
	// Cadastro/Edicao de componente
	private String nomeSubstancia;
	private String quantidadeSubstancia;
		
	// Para cadastros, edições e exclusões
	private AlimentoDTO alimentoSelecionado;
	private ComponenteAlimentarDTO componenteAlimentarSelecionado;
	private PreparoMedidaAlimentoDTO preparoMedidaAlimentoSelecionado;
	
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
	
	public void inicializar() {
		this.alimentos = aqs.Executar(new AlimentoParametrosPesquisa(true, new Date(), null, null));
		this.preparos = aqs.Executar(new PreparoParametrosPesquisa());
		this.medidas = aqs.Executar(new MedidaParametrosPesquisa());
		this.categorias = aqs.Executar(new CategoriaParametrosPesquisa());
		this.substancias = sqs.Executar(new SubstanciaParametrosPesquisa());
		
		//this.alimentos.add(new AlimentoDTO(null, "123456", null, null, null, null, null, new ArrayList<ComponenteAlimentarDTO>()));
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
	
	public void onRowSelect(SelectEvent event) {
		this.alimentoSelecionado = (AlimentoDTO) event.getObject();
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

	public String getQuantidadeSubstancia() {
		return quantidadeSubstancia;
	}

	public void setQuantidadeSubstancia(String quantidadeSubstancia) {
		this.quantidadeSubstancia = quantidadeSubstancia;
	}

	public void cadastrarAlimento() {
		System.out.println(">>>" + this.categoriaAlimento + " - " + this.nomeAlimento + " - " + this.porcaoAlimento + " - " + this.unidadeAlimento);
	}

	public List<AlimentoDTO> getAlimentosFiltrados() {
		return alimentosFiltrados;
	}

	public void setAlimentosFiltrados(List<AlimentoDTO> alimentosFiltrados) {
		this.alimentosFiltrados = alimentosFiltrados;
	}
	
}
