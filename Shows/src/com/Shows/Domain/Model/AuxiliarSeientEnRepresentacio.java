package com.Shows.Domain.Model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AuxiliarSeientEnRepresentacio implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Seient seient;
	@ManyToOne
	private Representacio representacio;

	public AuxiliarSeientEnRepresentacio() {
	}

	public AuxiliarSeientEnRepresentacio(Seient seient,
			Representacio representacio) {
		this.seient = seient;
		this.representacio = representacio;
	}

	public Seient getSeient() {
		return seient;
	}

	public void setSeient(Seient seient) {
		this.seient = seient;
	}

	public Representacio getRepresentacio() {
		return representacio;
	}

	public void setRepresentacio(Representacio representacio) {
		this.representacio = representacio;
	}

}
