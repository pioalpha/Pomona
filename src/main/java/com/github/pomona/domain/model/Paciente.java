package com.github.pomona.domain.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Paciente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8683824728292662068L;
	private TipoSexo tipoSexo;
	private String nome;
	private Date dataNascimento;
	private float altura;
	
	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}
	public void setTipoSexo(TipoSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public int getIdade(){
		Calendar nascimento = new GregorianCalendar();
		nascimento.setTime(this.dataNascimento);
		Calendar hoje = Calendar.getInstance();
		int idade = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
		
		nascimento.add(Calendar.YEAR, idade);
		
		if (hoje.before(nascimento)) {
			idade--;
		}

		return idade;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("Nome: "+ nome + "\n")
				.append("Nascimento: " + dataNascimento + "\n")
				.append("Idade: " + this.getIdade() + "\n")
				.append("Altura: " + altura + "m\n")
				.append("Sexo: " + tipoSexo)
				.toString();
	}
}
