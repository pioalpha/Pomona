package com.github.pomona.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.github.common.domain.model.ConcurrencySafeEntity;
import com.github.pomona.domain.reference.TipoMeta;

@Entity
public class Consulta extends ConcurrencySafeEntity {

	private static final long serialVersionUID = 7570544330947278407L;
	
	@Embedded
	private ConsultaId consultaId;
	@ManyToOne
	@JoinColumn(nullable = false)
	private PlanoAlimentar planoAlimentar;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataConsulta;
	@Column(precision = 10, scale = 2)
	private float imcConsulta; // calculado automatico pelo peso
	@Column(precision = 10, scale = 2)
	private Float valorMeta;
	@Column(precision = 10, scale = 2)
	private Float caloriasAlvo; // calculado automatico após estabelecer a meta
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private TipoMeta tipoMeta;
	@OneToOne
	private FatorAtividadeFisica fatorAtividadeFisica;
	@OneToOne
	private DiretrizAlimentar diretrizAlimentar;
	@OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
	private List<Cardapio> cardapios;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataInicioVigencia;
	@Temporal(TemporalType.DATE)
	private Date dataFimVigencia;
	@Embedded
	private ExameAntropometrico exameAntropometrico;

	public Consulta() {
		super();
		
		this.exameAntropometrico = new ExameAntropometrico();
	}

	public PlanoAlimentar getPlanoAlimentar() {
		return planoAlimentar;
	}

	public void setPlanoAlimentar(PlanoAlimentar planoAlimentar) {
		this.planoAlimentar = planoAlimentar;
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
		return "Consulta [consultaId=" + consultaId + ", planoAlimentarId=" + planoAlimentar.planoAlimentarId().uuid() + ", dataConsulta="
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
