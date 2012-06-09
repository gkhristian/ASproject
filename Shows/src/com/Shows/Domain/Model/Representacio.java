package com.Shows.Domain.Model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Representacio {

	@Id
	@ManyToOne
	private Sessio sessio;
	@Id
	@ManyToOne
	private Local nom;
	private Float preu;
	private Date data;
	private Integer nombreSeientsLliures;
	@OneToMany
	private Set<Entrada> entradas;
	@OneToMany
	private Set<SeientEnRepresentacio> seientsEnRepresentacio;

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

	public Local getNom() {
		return nom;
	}

	public void setNom(Local nom) {
		this.nom = nom;
	}

	public Sessio getSessio() {
		return sessio;
	}

	public void setSessio(Sessio sessio) {
		this.sessio = sessio;
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
}
