package com.Shows.Domain.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SeientEnRepresentacio {
	@Id
	@ManyToOne
	private Seient seient;
	private Estat estat;

	public SeientEnRepresentacio(Seient seient) {
		this.seient = seient;
	}
	
	public SeientEnRepresentacio(Seient seient, Estat estat) {
		this.seient = seient;
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
}
