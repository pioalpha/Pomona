package com.github.pomona.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pomona.domain.model.AlimentoGranel;
import com.github.pomona.domain.model.AlimentoUnitario;
import com.github.pomona.domain.model.ComponenteAlimentar;
import com.github.pomona.domain.model.Substancia;
import com.github.pomona.domain.reference.UnidadeGranel;

public class AlimentoBuilder {
	private List<ComponenteAlimentar> componentes;
	
	public AlimentoBuilder(){
		this.componentes = new ArrayList<ComponenteAlimentar>();
	}
	
	public AlimentoBuilder adicionarComponenteAlimentar(Substancia substancia,
			float quantidade){
		ComponenteAlimentar componenteAlimentar = new ComponenteAlimentar();
		componenteAlimentar.setDataCadastro(new Date());
		componenteAlimentar.setSubstancia(substancia);
		componenteAlimentar.setQuantidade(quantidade);
		
		this.componentes.add(componenteAlimentar);
		
		return this;
	}
	
	public AlimentoUnitario construir(String nome){
		AlimentoUnitario alimentoUnitario = new AlimentoUnitario();
		alimentoUnitario.setNome(nome);
		alimentoUnitario.setComposicaoAlimentar(this.componentes);
		return alimentoUnitario;
	}
	public AlimentoGranel construir(String nome, UnidadeGranel unidadeGranel, float porcao){
		AlimentoGranel alimentoGranel = new AlimentoGranel();
		alimentoGranel.setNome(nome);
		alimentoGranel.setComposicaoAlimentar(this.componentes);
		alimentoGranel.setUnidadeGranel(unidadeGranel);
		alimentoGranel.setPorcao(porcao);
		return alimentoGranel;
	}
}
