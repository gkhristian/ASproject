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

	public Estrena(Sessio sessio, Local nom,  int recarrec) {
		this.representacio = new Representacio(sessio, nom);
		this.recarrec = recarrec;
	}

	public Estrena(Sessio sessio, Local nom, float preu, Date data,
			int nombreSeientsLliures,
			int recarrec) {
		this.representacio = new Representacio(sessio, nom, preu, data,
				nombreSeientsLliures);
		this.recarrec = recarrec;
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