package com.Shows.Domain.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
}
