package com.github.pomona.domain.service;

import java.util.Date;

import com.github.pomona.domain.model.Consulta;
import com.github.pomona.domain.model.DiretrizAlimentar;
import com.github.pomona.domain.model.FatorAtividadeFisica;
import com.github.pomona.domain.model.PlanoAlimentar;
import com.github.pomona.domain.reference.TipoMeta;

public class ConsultaBuilder {
	private Consulta instancia;

	// http://www.rgnutri.com.br/sap/avaliacao/dma.php
	// Antopometria: Dobras Cutâneas, Circunferências, índice de Massa,
	// Bioimpedância
	// Meta: Avaliar a Gordura Corporal
	// Dobras (percentual gordura corporal): tríceps, bíceps, subescapular,
	// peitoral, antebraço, axilar média, supra-ilíaca, abdominal, coxa e
	// panturrilha
	// Circunferencias: pescoço, tórax, cintura, abdômen, quadril, coxa,
	// panturrilha, braço, antebraço e punho
	// Bioimpedância

	/* http://www.cdof.com.br/protocolos1.htm (Dobras)
	 * http://www.cdof.com.br/protocolos2.htm (Circunferencias)
	 * http://www.cdof.com.br/avalia1.htm#7
	 * 
	 * Dobras gera percentual de gordura corporal a meta é reduzir o percentual
	 * Circuferência gera risco cardíaco a meta é reduzir o risco de doenças
	 * 
	 * META REDUZIR PERCENTUAL DE GORDURA Protocolo de Dotson e Davis: Altura,
	 * Abdomem e pescoço (homens) Altura, Abdomem, Pescoço e Quadril (mulheres)
	 * 
	 * Protocolo de Penroe, Nelson e Fisher, 1985 e Coté e Wilmore: Punho,
	 * Abdomem ,Peso (homens), calcula a massa magra antes Abdomem, Gluteos,
	 * Estatura (mulheres)
	 * 
	 * Protocolo de Wetman e col., 1988 para pessoas obesas: Abdomem, peso
	 * (homens) Abdomem, peso, altura (mulheres)
	 * 
	 * 
	 * META REDUZIR RISCO DE DOENÇA WHR= abdomem / quadril Tabela de risco
	 * 
	 * Pode apresentar todos os indicadores para a pessoa decidir qual base
	 * definir para a meta?
	 */

	public ConsultaBuilder(Date dataConsulta, float pesoConsulta,
			DiretrizAlimentar diretrizAlimentar,
			FatorAtividadeFisica fatorAtividadeFisica,
			PlanoAlimentar planoAlimentar) {
		this.instancia = new Consulta();
		this.instancia.setPlanoReeducacaoAlimentar(planoAlimentar);
		this.instancia.setDataConsulta(dataConsulta);
		this.instancia.setPesoConsulta(pesoConsulta);
		this.instancia.setImcConsulta(CalculaIMC.calculaIMC(pesoConsulta,
				planoAlimentar.getPaciente().getAltura()));
		this.instancia.setDiretrizAlimentar(diretrizAlimentar);
		this.instancia.setFatorAtividadeFisica(fatorAtividadeFisica);
		// calcula IMC automatico
	}

	public ConsultaBuilder comCircunferencias(float cinturaConsulta,
			float abdomemConsulta, float quadrilConsulta) {

		return this;
	}

	public ConsultaBuilder definirMeta(TipoMeta tipoMeta, float valorMeta) {
		// Só pode calcular meta de circunferencia e gordura se foi definido
		// antes
		this.instancia.setTipoMeta(tipoMeta);
		this.instancia.setValorMeta(valorMeta);
		this.instancia.setCaloriasAlvo(tipoMeta.caloriaAlvo(this.instancia
				.getPlanoReeducacaoAlimentar().getPaciente(), this.instancia,
				valorMeta));

		return this;
	}

	/*
	 * public ConsultaBuilder comCardapio(Date dia, DivisaoRefeicao
	 * divisaoRefeicao){ Cardapio cardapio = new Cardapio();
	 * 
	 * 
	 * if (this.instancia.getCardapios() == null){
	 * this.instancia.setCardapios(new ArrayList<Cardapio>()); }
	 * this.instancia.getCardapios().add(cardapio); return this; }
	 */

	public Consulta construir() {
		return this.instancia;
	}
}
