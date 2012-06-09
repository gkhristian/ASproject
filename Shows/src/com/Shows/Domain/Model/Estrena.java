package com.Shows.Domain.Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estrena implements Serializable {

	private static final long serialVersionUID = 1L;

	private int recarrec;
	@Id
	@OneToOne
	private Representacio representacio;

	public Estrena(Sessio sessio, Local nom,
			Set<SeientEnRepresentacio> seientsEnRepresentacio, int recarrec) {
		this.representacio = new Representacio(sessio, nom,
				seientsEnRepresentacio);
		this.recarrec = recarrec;
		// TODO Controlar sets vacios
	}

	public Estrena(Sessio sessio, Local nom, float preu, Date data,
			int nombreSeientsLliures,
			Set<SeientEnRepresentacio> seientsEnRepresentacio, int recarrec) {
		this.representacio = new Representacio(sessio, nom, preu, data,
				nombreSeientsLliures, seientsEnRepresentacio);
		this.recarrec = recarrec;
		// TODO Controlar sets vacios
	}

	public int getRecarrec() {
		return recarrec;
	}

	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}

	public Representacio getRepresentacio() {
		return representacio;
	}

	public void setRepresentacio(Representacio representacio) {
		this.representacio = representacio;
	}

}
