package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Consulta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7570544330947278407L;
	private PlanoReeducacaoAlimentar planoReeducacaoAlimentar;
	private Date dataConsulta;
	private float pesoConsulta;
	private float imcConsulta; // calculado automatico pelo peso
	private Float abdomemConsulta;
	private Float quadrilConsulta;
	private Float gorduraCorporalConsulta;
	private Float valorMeta;
	private Float caloriasAlvo; // calculado automatico após estabelecer a meta
	private TipoMeta tipoMeta;
	private FatorAtividadeFisica fatorAtividadeFisica;
	private DiretrizAlimentar diretrizAlimentar;
	private List<Cardapio> cardapios;
	
	public PlanoReeducacaoAlimentar getPlanoReeducacaoAlimentar() {
		return planoReeducacaoAlimentar;
	}
	public void setPlanoReeducacaoAlimentar(
			PlanoReeducacaoAlimentar planoReeducacaoAlimentar) {
		this.planoReeducacaoAlimentar = planoReeducacaoAlimentar;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public float getPesoConsulta() {
		return pesoConsulta;
	}
	public void setPesoConsulta(float pesoConsulta) {
		this.pesoConsulta = pesoConsulta;
	}
	public void setImcConsulta(float imcConsulta) {
		this.imcConsulta = imcConsulta;
	}
	public float getImcConsulta() {
		return imcConsulta;
	}
	public float getAbdomemConsulta() {
		return abdomemConsulta;
	}
	public void setAbdomemConsulta(float abdomemConsulta) {
		this.abdomemConsulta = abdomemConsulta;
	}
	public float getGorduraCorporalConsulta() {
		return gorduraCorporalConsulta;
	}
	public void setGorduraCorporalConsulta(float gorduraCorporalConsulta) {
		this.gorduraCorporalConsulta = gorduraCorporalConsulta;
	}
	public float getValorMeta() {
		return valorMeta;
	}
	public void setValorMeta(float valorMeta) {
		this.valorMeta = valorMeta;
	}
	public void setCaloriasAlvo(Float caloriasAlvo) {
		this.caloriasAlvo = caloriasAlvo;
	}
	public float getCaloriasAlvo() {
		return caloriasAlvo;
	}
	public TipoMeta getTipoMeta() {
		return tipoMeta;
	}
	public void setTipoMeta(TipoMeta tipoMeta) {
		this.tipoMeta = tipoMeta;
	}
	public List<Cardapio> getCardapios() {
		return cardapios;
	}
	public void setCardapios(List<Cardapio> cardapios) {
		this.cardapios = cardapios;
	}
	public FatorAtividadeFisica getFatorAtividadeFisica() {
		return fatorAtividadeFisica;
	}
	public void setFatorAtividadeFisica(FatorAtividadeFisica fatorAtividadeFisica) {
		this.fatorAtividadeFisica = fatorAtividadeFisica;
	}
	public DiretrizAlimentar getDiretrizAlimentar() {
		return diretrizAlimentar;
	}
	public void setDiretrizAlimentar(DiretrizAlimentar diretrizAlimentar) {
		this.diretrizAlimentar = diretrizAlimentar;
	}
	public Float getQuadrilConsulta() {
		return quadrilConsulta;
	}
	public void setQuadrilConsulta(Float quadrilConsulta) {
		this.quadrilConsulta = quadrilConsulta;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("Consulta Dia: "+ dataConsulta)
				.append(" (Peso: " + pesoConsulta + " kg, ")
				.append("IMC: " + imcConsulta + ", ")
				.append(diretrizAlimentar.getNome() + ", ")
				.append("Tipo Meta: " + tipoMeta + ", ")
				.append("Valor Meta: " + valorMeta + ", ")
				.append("Caloria Alvo: " + caloriasAlvo + ")\n")
				.append(">>CARDAPIOS\n")
				.append(cardapios.toString())
				.toString();
	}
}
