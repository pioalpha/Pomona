package com.github.pomona.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.github.pomona.application.AlimentoQueryService;
import com.github.pomona.application.SubstanciaQueryService;
import com.github.pomona.application.dto.AlimentoDTO;
import com.github.pomona.application.dto.ComponenteAlimentarDTO;
import com.github.pomona.application.dto.MedidaDTO;
import com.github.pomona.application.dto.PreparoDTO;
import com.github.pomona.application.dto.PreparoMedidaAlimentoDTO;
import com.github.pomona.application.dto.SubstanciaDTO;
import com.github.pomona.domain.reference.UnidadeGranel;
import com.github.pomona.domain.reference.UnidadeSubstancia;
import com.github.pomona.service.commandHandler.AlimentoCommandHandler;
import com.github.pomona.service.commandHandler.SubstanciaCommandHandler;

@ManagedBean
@ViewScoped
public class AlimentoBean implements Serializable {

	private static final long serialVersionUID = -8620927385542527384L;

	// interfaces de Consultas necessárias as listagens
	@Inject
	private SubstanciaQueryService sqs;
	private AlimentoQueryService aqs;
	
	// interfaces de Comandos necessários ao cadastro
	@Inject
	private SubstanciaCommandHandler sch;
	private AlimentoCommandHandler ach;
	
	// Para listar combos
	private List<SubstanciaDTO> substancias;
	private List<PreparoDTO> preparos;
	private List<MedidaDTO> medidas;
	
	// Para validar cadastro de novas substancias e novos alimentos
	private UnidadeSubstancia unidadeSubstancia;
	private UnidadeGranel unidadeGranel;
	
	// Núcleo de informação da página
	private List<AlimentoDTO> alimentos; //Contém componentes alimentares
	private List<PreparoMedidaAlimentoDTO> preparosMedidasAlimentos; // Conforme alimento selecionado
	
	// Para cadastros, edições e exclusões
	private AlimentoDTO alimentoSelecionado;
	private ComponenteAlimentarDTO componenteAlimentarSelecionado;
	private PreparoMedidaAlimentoDTO preparoMedidaAlimentoSelecionado;
	
	
	
}
