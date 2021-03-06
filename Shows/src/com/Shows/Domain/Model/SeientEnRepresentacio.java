package com.Shows.Domain.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.Shows.TupleTypes.PosicioSeient;

@Entity
public class SeientEnRepresentacio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private AuxiliarSeientEnRepresentacio auxpk;

	@Enumerated(EnumType.STRING)
	private Estat estat;

	public SeientEnRepresentacio() {
	}

	public SeientEnRepresentacio(Seient seient, Representacio representacio,
			Estat estat) {
		this.auxpk = new AuxiliarSeientEnRepresentacio(seient, representacio);
		this.estat = estat;
	}

	public Estat getEstat() {
		return estat;
	}

	public void setEstat(Estat estat) {
		this.estat = estat;
	}

	public PosicioSeient esLliure() {
		if (this.estat == Estat.lliure) {
			PosicioSeient lliure = this.auxpk.getSeient().seient();
			return lliure;
		}
		return null;
	}

	public void ocuparSeient() {
		if (this.estat == Estat.lliure) {
			this.estat = Estat.ocupat;
		}
	}
}
