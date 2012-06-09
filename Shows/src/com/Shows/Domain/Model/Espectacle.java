package com.Shows.Domain.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Espectacle {

	@Id
	private String titol;
	private int participants;
	@OneToOne
	private Representacio representacio;

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public Representacio getRepresentacio() {
		return representacio;
	}

	public void setRepresentacio(Representacio representacio) {
		this.representacio = representacio;
	}

}
