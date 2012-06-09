package com.Shows.Domain.Model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Estrena extends Representacio {

	private int recarrec;

	public Estrena(Sessio sessio, Local nom, Set<Entrada> entradas,
			Set<SeientEnRepresentacio> seientsEnRepresentacio, int recarrec) {
		super(sessio, nom, entradas, seientsEnRepresentacio);
		this.recarrec = recarrec;
	}

	public Estrena(Sessio sessio, Local nom, Float preu, Date data,
			Integer nombreSeientsLliures, Set<Entrada> entradas,
			Set<SeientEnRepresentacio> seientsEnRepresentacio, int recarrec) {
		super(sessio, nom, preu, data, nombreSeientsLliures, entradas,
				seientsEnRepresentacio);
		this.recarrec = recarrec;
	}

	public int getRecarrec() {
		return recarrec;
	}

	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}

}
