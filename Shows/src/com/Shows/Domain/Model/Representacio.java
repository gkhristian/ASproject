package com.Shows.Domain.Model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Representacio {

	@Id
	private AuxiliarRepresentacio aux;
	private Float preu;
	private Date data;
	private Integer nombreSeientsLliures;
	@OneToMany
	private Set<Entrada> entradas;
	@OneToMany
	private Set<SeientEnRepresentacio> seientsEnRepresentacio;

	public Representacio(Sessio sessio, Local nom) {
		this.setAux(new AuxiliarRepresentacio(sessio, nom));
		this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
		this.entradas = new HashSet<Entrada>();
	}

	public Representacio(Sessio sessio, Local nom, Float preu, Date data,
			Integer nombreSeientsLliures) {
		setAux(new AuxiliarRepresentacio(sessio, nom));
		this.preu = preu;
		this.data = data;
		this.nombreSeientsLliures = nombreSeientsLliures;
		this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
		this.entradas = new HashSet<Entrada>();
	}

	public Float getPreu() {
		return preu;
	}

	public void setPreu(Float preu) {
		this.preu = preu;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	public void setNombreSeientsLliures(Integer nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}
	
	public void createEntrada(String titol, String dni, int nombEspectadors, Date data, float preuTotal) {
		
		//TO CHECK: COM ES SAP L'IDENTIFICADOR?????????????????????
		String identificador = ((Integer) getEntradas().size()).toString();
		
		Entrada e = new Entrada(identificador, dni, nombEspectadors, data, preuTotal, this);
		entradas.add(e);
	}

	public Set<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Set<SeientEnRepresentacio> getSeientsEnRepresentacio() {
		return seientsEnRepresentacio;
	}

	public void setSeientsEnRepresentacio(
			Set<SeientEnRepresentacio> seientsEnRepresentacio) {
		this.seientsEnRepresentacio = seientsEnRepresentacio;
	}

	public AuxiliarRepresentacio getAux() {
		return aux;
	}

	public void setAux(AuxiliarRepresentacio aux) {
		this.aux = aux;
	}
}
