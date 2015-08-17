package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.github.pomona.domain.reference.TipoMeta;

public class Consulta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7570544330947278407L;
	private ConsultaId consultaId;
	private PlanoAlimentarId planoAlimentarId;
	private Date dataConsulta;
	private float imcConsulta; // calculado automatico pelo peso
	private Float valorMeta;
	private Float caloriasAlvo; // calculado automatico após estabelecer a meta
	private TipoMeta tipoMeta;
	private FatorAtividadeFisica fatorAtividadeFisica;
	private DiretrizAlimentar diretrizAlimentar;
	private List<Cardapio> cardapios;
	private Date dataInicioVigencia;
	private Date dataFimVigencia;
	private ExameAntropometrico exameAntropometrico;

	public Consulta() {
		super();
		
		this.exameAntropometrico = new ExameAntropometrico();
	}

	public PlanoAlimentarId getPlanoAlimentarId() {
		return planoAlimentarId;
	}

	public void setPlanoAlimentarId(PlanoAlimentarId planoAlimentarId) {
		this.planoAlimentarId = planoAlimentarId;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public void setImcConsulta(float imcConsulta) {
		this.imcConsulta = imcConsulta;
	}

	public float getImcConsulta() {
		return imcConsulta;
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

	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public Date getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(Date dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	@Override
	public String toString() {
		return "Consulta [consultaId=" + consultaId + ", planoAlimentarId=" + planoAlimentarId + ", dataConsulta="
				+ dataConsulta + ", imcConsulta=" + imcConsulta + ", valorMeta=" + valorMeta + ", caloriasAlvo="
				+ caloriasAlvo + ", tipoMeta=" + tipoMeta + ", fatorAtividadeFisica=" + fatorAtividadeFisica
				+ ", diretrizAlimentar=" + diretrizAlimentar + ", cardapios=" + cardapios + ", dataInicioVigencia="
				+ dataInicioVigencia + ", dataFimVigencia=" + dataFimVigencia + ", exameAntropometrico="
				+ exameAntropometrico + "]";
	}

	public String getDetalhes() {
		return new StringBuilder()
				.append("Consulta Dia: " + dataConsulta)
				.append(" (Peso: " + exameAntropometrico.getPeso() + " kg, ")
				.append("Altura: " + exameAntropometrico.getAltura() + " m, ")
				.append("IMC: " + imcConsulta + ", ")
				.append(diretrizAlimentar.getNome() + ", ")
				.append("Tipo Meta: " + tipoMeta + ", ").append("Valor Meta: " + valorMeta + ", ")
				.append("Caloria Alvo: " + caloriasAlvo + ")\n").append(">>CARDAPIOS\n").append(cardapios.toString())
				.toString();
	}
	
	public ConsultaId consultaId() {
		return consultaId;
	}

	public void setConsultaId(ConsultaId consultaId) {
		this.consultaId = consultaId;
	}

	public ExameAntropometrico getExameAntropometrico() {
		return exameAntropometrico;
	}

	public void setExameAntropometrico(ExameAntropometrico exameAntropometrico) {
		this.exameAntropometrico = exameAntropometrico;
	}
	
}
