package com.Shows.Domain.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SeientEnRepresentacio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	private Seient seient;
	@Id
	@ManyToOne
	private Representacio representacio;
	@Enumerated(EnumType.STRING)
	private Estat estat;

	public SeientEnRepresentacio(Seient seient, Representacio representacio, Estat estat) {
		this.seient = seient;
		this.setRepresentacio(representacio);
		this.estat = estat;
	}

	public Seient getSeient() {
		return seient;
	}

	public void setSeient(Seient seient) {
		this.seient = seient;
	}

	public Estat getEstat() {
		return estat;
	}

	public void setEstat(Estat estat) {
		this.estat = estat;
	}

	public Representacio getRepresentacio() {
		return representacio;
	}

	public void setRepresentacio(Representacio representacio) {
		this.representacio = representacio;
	}
}
